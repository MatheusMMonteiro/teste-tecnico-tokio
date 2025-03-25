import { Component, OnInit } from "@angular/core";
import { Client } from "src/core/models/client.interface";
import { ClientService } from "src/core/services/client.service";

@Component({
  selector: "app-client-list",
  templateUrl: "./client-list.component.html",
  styleUrls: ["./client-list.component.scss"],
})
export class ClientListComponent implements OnInit {
  data: Client[] = [];
  client: Client;
  constructor(private readonly _service: ClientService) {}

  ngOnInit(): void {
    this.getData();
  }

  getData(): void {
    this._service.getClients().subscribe((resp) => {
      console.log(resp)
      this.data = resp.map(client => ({
        ...client,
        addresses: client.addresses || []
      }));
    });
  }

  onExclude(id: number) {
    this._service.deleteClient(id).subscribe(() => {
      this.getData();
    });
  }

  onCreateAddres(client: Client){
    this.client = client;
  }

}
