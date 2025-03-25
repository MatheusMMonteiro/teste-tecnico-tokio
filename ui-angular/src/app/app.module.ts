import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HomeComponent } from '../components/home/home.component'
import { AboutComponent } from '../components/about/about.component';
import { HttpClientModule } from '@angular/common/http';
import { ClientModule } from '../components/client/client.module';
import { ClientCreateComponent } from 'src/components/client/client-create/client-create.component';
import { AddressModule } from 'src/components/address/address.module';

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ClientModule,
    AddressModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
