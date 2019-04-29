export class Vuelo {

    constructor(
        public idVuelo: string,
        public aerolinea: string,
        public horaSalida: string,
        public horaLlegada: string,
        public permiteMaletas: string,
        public selected:boolean = false
      ) {  }
}
