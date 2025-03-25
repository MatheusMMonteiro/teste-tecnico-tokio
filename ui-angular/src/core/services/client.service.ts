import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {
  Client,
  ClientRequest,
  ClientResponse,
} from "../models/client.interface";
import { environment } from "src/environments/environment";
@Injectable({
  providedIn: "root",
})
export class ClientService {
  constructor(private readonly _http: HttpClient) {}
  readonly url = `${environment.backendUrl}/client/`;

  getClients(): Observable<ClientResponse[]> {
    return this._http.get<ClientResponse[]>(this.url);
  }

  postClient(data: ClientRequest): Observable<any> {
    return this._http.post<any>(this.url, data);
  }

  putClient(data: Client): Observable<Client> {
    return this._http.put<any>(this.url, data);
  }

  deleteClient(id: number): Observable<any> {
    return this._http.delete<any>(`${this.url}/${id}`);
  }
}
