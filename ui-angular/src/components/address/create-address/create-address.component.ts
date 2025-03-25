import { Component, Input, OnInit } from '@angular/core';
import { Address, AddressCreate } from 'src/core/models/address.interface';
import { AddressService } from 'src/core/services/address.service';

@Component({
  selector: 'app-create-address',
  templateUrl: './create-address.component.html',
  styleUrls: ['./create-address.component.scss']
})
export class CreateAddressComponent {
  @Input() clientId: number;

  address: string = '';
  number: string = '';
  complement: string = '';
  postalCode: string = '';
  city: string = '';
  state: string = '';
  country: string = '';
  addressSaved: boolean = false;

  addressError: boolean = false;
  loading = false;

  constructor(private _service: AddressService) {}

  // Função para salvar o endereço
  saveAddress() {
    // Validação do endereço
    if (!this.address) {
      this.addressError = true;
    } else {
      this.addressError = false;
    }

    // Se o campo de endereço for válido, faz a requisição
    if (!this.addressError) {
      const data: AddressCreate = {
        address: this.address,
        number: this.number,
        complement: this.complement,
        postalCode: this.postalCode,
        city: this.city,
        state: this.state,
        country: this.country,
        clientId: this.clientId,
      };

      this._service.postAddress(data).subscribe({
        next: (response) => {
          location.reload();
        },
        error: (err) => {
          console.log(err);
          alert('Erro ao salvar endereço: ' + err.error);
        },
      });
    }
  }

  // Função para limpar os campos
  cancel() {
    this.address = '';
    this.number = '';
    this.complement = '';
    this.postalCode = '';
    this.city = '';
    this.state = '';
    this.country = '';
    this.addressSaved = false;
  }

  checkAddress() {
    this.addressError = !this.address;
  }


  searchCep() {
    this.loading = true;
    this._service.getAddressByCep(this.postalCode).subscribe({
      next: (response) => {
        this.address = response.logradouro;
        this.city = response.localidade;
        this.state = response.uf;
        this.country = 'Brasil';
      },
      error: (err) => {
        console.log(err);
        alert('Erro ao buscar CEP: ' + err.error);
      },
    }).add(() => this.loading = false);
  }

}
