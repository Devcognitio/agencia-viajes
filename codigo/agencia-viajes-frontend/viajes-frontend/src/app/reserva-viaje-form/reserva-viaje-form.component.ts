import { Component, OnInit } from '@angular/core';
import {ReservaViaje} from '../reserva-viaje';
import {ViajesApiService} from '../viajes-api.service';
import {Vuelo} from '../vuelo';

@Component({
  selector: 'app-reserva-viaje-form',
  templateUrl: './reserva-viaje-form.component.html',
  styleUrls: ['./reserva-viaje-form.component.css']
})
export class ReservaViajeFormComponent implements OnInit {
  consultaViajesDisponiblesRealizada:boolean = false;
  vueloIdaTitle:String = "Vuelo Ida"
  vueloRegresoTitle:String = "Vuelo Regreso"
  clases = ['economica', 'ejecutiva', 'primera_clase'];
  vuelo = new Vuelo('','','','','',false)
  reserva = new ReservaViaje('', 'medellin-colombia','lima-peru','2019-01-01','2019-02-01', 1, 
  'economica',this.vuelo, this.vuelo);
  vuelosDisponibles:Array<Vuelo> = [];

  submitted = false;

  onSubmit() { this.submitted = true; }
  
  newReservaViaje() {
    
  }

  buscarVuelosDisponibles (){
    this.viajesApi.getVuelosDisponibles(this.reserva).subscribe((data: {}) => {
      console.log(data);
      this.vuelosDisponibles = data as Array<Vuelo>;
    });
    this.consultaViajesDisponiblesRealizada = true;
  }

  disableSubmit(formIsValido: boolean){
    return (!formIsValido && this.isEmpty(this.reserva.vueloIda) == null && this.isEmpty(this.reserva.vueloRegreso == null))
  }

  isEmpty(objeto) {
    if (objeto == null) return true;
    if (objeto.isArray(objeto) || objeto.isString(objeto)) return objeto.length === 0;
    for (var key in objeto) if (objeto.has(objeto, key)) return false;
    return true;
  };

  constructor(public viajesApi:ViajesApiService) { }

  ngOnInit() {
  }

}
