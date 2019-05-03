package com.devco.viajes.dominio.entidades;

import com.devco.viajes.dominio.valueobjects.ClaseViaje;
import com.devco.viajes.excepciones.ParametrosIncorrectos;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class ReservaViaje {

    String idReserva;
    String origen;
    String destino;
    String fechaIda;
    String fechaRegreso;
    int nroPasajeros;
    ClaseViaje claseViaje;
    Vuelo vueloIda;
    Vuelo vueloRegreso;

    public ReservaViaje() {
    }

    public ReservaViaje(String idReserva) throws NoSuchAlgorithmException {
        if (idReserva == null || idReserva.isEmpty()){
            this.idReserva = generarIdReserva();
        }else{
            this.idReserva = idReserva;
        }
    }

    private String generarIdReserva() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        StringBuilder sb = new StringBuilder();

        // first not 0 digit
        sb.append(random.nextInt(9) + 1);

        // rest of 7 digits
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(9));
        }

        return "R-" + sb.toString();
    }

    public String getIdReserva() {
        return idReserva;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getFechaIda() {
        return fechaIda;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public int getNroPasajeros() {
        return nroPasajeros;
    }

    public ClaseViaje getClaseViaje() {
        return claseViaje;
    }

    public Vuelo getVueloIda() {
        return vueloIda;
    }

    public void setVueloIda(Vuelo vueloIda) {
        this.vueloIda = vueloIda;
    }

    public Vuelo getVueloRegreso() {
        return vueloRegreso;
    }

    public void setVueloRegreso(Vuelo vueloRegreso) {
        this.vueloRegreso = vueloRegreso;
    }

    public static class ReservaViajeBuilder {

        private String idReserva;
        private String origen;
        private String destino;
        private String fechaIda;
        private String fechaRegreso;
        private int nroPasajeros;
        private ClaseViaje claseViaje;

        public ReservaViajeBuilder(){

        }

        public String getOrigen() {
            return origen;
        }

        public ReservaViajeBuilder conIdReserva(String idReserva){
            this.idReserva = idReserva;
            return this;
        }

        public ReservaViajeBuilder conOrigen(String origen){
            this.origen = origen;
            return this;
        }

        public ReservaViajeBuilder conDestino(String destino){
            this.destino = destino;
            return this;
        }

        public ReservaViajeBuilder conFechaIda(String fechaIda){
            this.fechaIda = fechaIda;
            return this;
        }

        public ReservaViajeBuilder conFechaRegreso(String fechaRegreso){
            this.fechaRegreso = fechaRegreso;
            return this;
        }

        public ReservaViajeBuilder conNroPasajeros(String nroPasajeros) throws ParametrosIncorrectos {
            try{
                this.nroPasajeros = Integer.parseInt(nroPasajeros);
                return this;
            }catch (Exception exc){
                throw new ParametrosIncorrectos();
            }

        }

        public ReservaViajeBuilder conClase(String claseViaje){
            //TODO: Control de excepciones
            this.claseViaje = ClaseViaje.valueOf(claseViaje.toUpperCase());
            return this;
        }

        public ReservaViaje build() throws NoSuchAlgorithmException {
            ReservaViaje reservaViaje = new ReservaViaje(idReserva);
            reservaViaje.origen = this.origen;
            reservaViaje.destino = this.destino;
            reservaViaje.fechaIda = this.fechaIda;
            reservaViaje.fechaRegreso = this.fechaRegreso;
            reservaViaje.nroPasajeros = this.nroPasajeros;
            reservaViaje.claseViaje = this.claseViaje;

            return reservaViaje;
        }
    }
}
