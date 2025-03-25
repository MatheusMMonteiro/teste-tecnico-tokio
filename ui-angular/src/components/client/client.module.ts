import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientCreateComponent } from './client-create/client-create.component';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { ClientListComponent } from './client-list/client-list.component';
import { AddressModule } from '../address/address.module';

@NgModule({
  declarations: [ClientCreateComponent, ClientListComponent],
  imports: [
    CommonModule,

    FormsModule,

    BrowserModule,
    AddressModule
  ],
  exports: [ClientCreateComponent, ClientListComponent]
})
export class ClientModule { }
