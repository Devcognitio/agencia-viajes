import { Component, OnInit, Input } from '@angular/core';
import {Vuelo} from '../vuelo';
import { ReservaViaje } from '../reserva-viaje';

@Component({
  selector: 'app-vuelos-disponibles',
  templateUrl: './vuelos-disponibles.component.html',
  styleUrls: ['./vuelos-disponibles.component.css']
})
export class VuelosDisponiblesComponent implements OnInit {

  vueloRegresoChecked:boolean = false;
  @Input() vuelosDisponibles:Array<Vuelo>;
  @Input() reserva:ReservaViaje;

  constructor() { }

  ngOnInit() {}

  seleccionarVuelo(vuelo: Vuelo): void {
    if (this.reserva.vueloIda.idVuelo.length == 0){
      vuelo.selected = true;
      this.reserva.vueloIda = vuelo;
    }else{
      vuelo.selected = true;
      this.reserva.vueloRegreso = vuelo;
    }
  }

}
