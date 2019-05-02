import { Vuelo } from './vuelo';

export class ReservaViaje {
    constructor(
        public idReserva: string,
        public origen: string,
        public destino: string,
        public fechaIda: string,
        public fechaRegreso: string,
        public nroPasajeros?: number,
        public clase?: string,
        public vueloIda?: Vuelo,
        public vueloRegreso?: Vuelo
      ) {  }
}
