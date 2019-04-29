import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReservaViajeFormComponent } from './reserva-viaje-form/reserva-viaje-form.component';
import { VuelosDisponiblesComponent } from './vuelos-disponibles/vuelos-disponibles.component';
import { VuelosComponent } from './vuelos/vuelos.component';


@NgModule({
  declarations: [
    AppComponent,
    ReservaViajeFormComponent,
    VuelosDisponiblesComponent,
    VuelosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
