import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { CreateAddressComponent } from "./create-address/create-address.component";
import { FormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";

@NgModule({
  declarations: [CreateAddressComponent],
  imports: [CommonModule, FormsModule, BrowserModule],
  exports: [CreateAddressComponent],
})
export class AddressModule {}
