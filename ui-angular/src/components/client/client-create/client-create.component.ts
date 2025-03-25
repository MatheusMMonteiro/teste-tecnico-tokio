import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Client } from 'src/core/models/client.interface';
import { ClientService } from 'src/core/services/client.service';
@Component({
  selector: 'app-client-create',
  templateUrl: './client-create.component.html',
  styleUrls: ['./client-create.component.scss']
})
export class ClientCreateComponent implements OnInit {
  firstName: string = '';
  lastName: string = '';
  email: string = '';
  firstNameError: boolean = false;
  emailError: boolean = false;
  client: Client;

  constructor(private readonly _service: ClientService) { }

  ngOnInit() {
  }

  saveUser() {
    // Resetando os erros
    this.firstNameError = !this.firstName.trim();
    this.emailError = !this.email.trim() || !this.isValidEmail(this.email);

    if (this.firstNameError || this.emailError) {
      console.log('Erro: Preencha os campos obrigatórios corretamente.');
      return;
    }

    const data =  {
      firstName: this.firstName,
      lastName: this.lastName,
      email: this.email,
    };

    this._service.postClient(data).subscribe({
      next: (response) => {
        this.client = response; // Recebe o cliente criado
        console.log(this.client);
      },
      error(err) {
        console.log(err)
        alert(err.error);
      },
    });
  }

  isValidEmail(email: string): boolean {
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return emailPattern.test(email);
  }

  cancel() {
    this.firstName = '';
    this.lastName = '';
    this.email = '';
    this.firstNameError = false;
    this.emailError = false;
    this.client = null;
  }
}
