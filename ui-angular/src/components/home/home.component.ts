import { Component, OnInit } from "@angular/core";
import { Client } from "src/core/models/client.interface";
import { ClientService } from "src/core/services/client.service";

@Component({
  selector: "home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.scss"],
})
export class HomeComponent implements OnInit {
  constructor(private readonly _service: ClientService) {}
  data: Client[] = [];
  isCreate = false;
  ngOnInit(): void {
    this._service.getClients().subscribe((resp) => {
      this.data = resp;
    });
  }

  onCreate() {
    this.isCreate = !this.isCreate;
  }
}
