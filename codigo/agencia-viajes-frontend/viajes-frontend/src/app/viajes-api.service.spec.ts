import { TestBed,getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ViajesApiService } from './viajes-api.service';
import { ReservaViaje } from './reserva-viaje';
import {Vuelo} from './vuelo';

describe('ViajesApiService', () => {
  let injector: TestBed;
  let service: ViajesApiService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ViajesApiService]
    });
    injector = getTestBed();
    service = injector.get(ViajesApiService);
    httpMock = injector.get(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('debe poderse crear OK', () => {
    expect(service).toBeTruthy();
  });

  it('#getVuelosDisponibles debe retornar una lista de vuelosDisponibles', () => {
    const dummyVuelos = [
      {
        idVuelo:'vtest1',
        aerolinea: 'avianca',
        horaSalida: '00:00',
        horaLlegada: '03:00',
        permiteMaletas: 'true'
      },
      {
        idVuelo:'vtest2',
        aerolinea: 'avianca',
        horaSalida: '12:00',
        horaLlegada: '15:00',
        permiteMaletas: 'false'
      }
    ];

    const dummyReserva = new ReservaViaje('','colombia','peru','2019-01-01','2019-02-01',1,'economica');
    var vuelosDisponibles:Array<Vuelo> = [];

    service.getVuelosDisponibles(dummyReserva).subscribe((data: {}) => {
      console.log('data');
      console.log(data);
      vuelosDisponibles = data as Array<Vuelo>;
      expect(vuelosDisponibles.length).toBe(2);
      //expect(vuelosDisponibles).toEqual(dummyVuelos as Array<Vuelo>);
    });

    const req = httpMock.expectOne(`${service.endpoint}vuelos/disponibles?origen=${dummyReserva.origen}&destino=${dummyReserva.destino}&fechaIda=${dummyReserva.fechaIda}&fechaRegreso=${dummyReserva.fechaRegreso}&nroPasajeros=${dummyReserva.nroPasajeros}&clase=${dummyReserva.clase}`, "No se logró hacer match con el mock");
    expect(req.request.method).toBe("GET");
    req.flush(dummyVuelos);

  });

  
});
