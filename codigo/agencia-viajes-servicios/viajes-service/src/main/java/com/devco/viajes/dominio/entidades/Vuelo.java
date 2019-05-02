package com.devco.viajes.dominio.entidades;

public class Vuelo {
    private String idVuelo;
    private String aerolinea;
    private String horaSalida;
    private String horaLlegada;
    private boolean permiteMaletas;

    public Vuelo() {
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public boolean isPermiteMaletas() {
        return permiteMaletas;
    }

    public static class VueloBuilder{
        private String idVuelo;
        private String aerolinea;
        private String horaSalida;
        private String horaLlegada;
        private boolean permiteMaletas;

        public VueloBuilder(){
        }

        public VueloBuilder conIdVuelo(String idVuelo){
            this.idVuelo = idVuelo;
            return this;
        }

        public VueloBuilder conAerolinea(String aerolinea){
            this.aerolinea = aerolinea;
            return this;
        }

        public VueloBuilder conHoraSalida(String horaSalida){
            this.horaSalida = horaSalida;
            return this;
        }

        public VueloBuilder conHoraLlegada(String horaLlegada){
            this.horaLlegada = horaLlegada;
            return this;
        }

        public VueloBuilder conPermiteMaletas(boolean permiteMaletas){
            this.permiteMaletas = permiteMaletas;
            return this;
        }

        public Vuelo build(){
            Vuelo vuelo = new Vuelo();
            vuelo.idVuelo = this.idVuelo;
            vuelo.aerolinea = this.aerolinea;
            vuelo.horaSalida = this.horaSalida;
            vuelo.horaLlegada = this.horaLlegada;
            vuelo.permiteMaletas = this.permiteMaletas;

            return vuelo;
        }

        public Vuelo buildAvianca() {
            this.aerolinea = "avianca";
            return build();
        }
    }
}
