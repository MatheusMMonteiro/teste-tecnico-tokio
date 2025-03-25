import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Address, AddressCreate } from "../models/address.interface";
import { CepAddress } from "../models/cep-address.interface";
@Injectable({
  providedIn: "root",
})
export class AddressService {

  constructor(private readonly _http: HttpClient) {}
  readonly url = `${environment.backendUrl}/address/`;

  getAddress(): Observable<Address[]> {
    return this._http.get<Address[]>(this.url);
  }

  getAddressByCep(cep: string):  Observable<CepAddress> {
    return this._http.get<CepAddress>(`${this.url}/cep/${cep}`);
  }

  postAddress(data: AddressCreate): Observable<any> {
    return this._http.post<any>(this.url, data);
  }

  putAddress(data: Address): Observable<Address> {
    return this._http.put<any>(this.url, data);
  }

  deleteAddress(id: number): Observable<any> {
    return this._http.delete<any>(`${this.url}/${id}`);
  }
}
