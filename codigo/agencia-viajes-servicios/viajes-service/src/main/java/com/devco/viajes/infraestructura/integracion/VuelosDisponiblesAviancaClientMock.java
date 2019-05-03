package com.devco.viajes.infraestructura.integracion;

import com.devco.viajes.dominio.entidades.ReservaViaje;
import com.devco.viajes.dominio.entidades.Vuelo;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VuelosDisponiblesAviancaClientMock implements VuelosDisponiblesClient {
    private List<Vuelo> vuelos;

    public VuelosDisponiblesAviancaClientMock() {
        vuelos = new ArrayList<Vuelo>();
        vuelos.add(new Vuelo.VueloBuilder().conIdVuelo("v001").conHoraSalida("5:00").conHoraLlegada("6:00").conPermiteMaletas(true).buildAvianca());
        vuelos.add(new Vuelo.VueloBuilder().conIdVuelo("v002").conHoraSalida("13:00").conHoraLlegada("14:00").conPermiteMaletas(true).buildAvianca());
        vuelos.add(new Vuelo.VueloBuilder().conIdVuelo("v003").conHoraSalida("12:00").conHoraLlegada("13:00").conPermiteMaletas(false).buildAvianca());
        vuelos.add(new Vuelo.VueloBuilder().conIdVuelo("v004").conHoraSalida("3:00").conHoraLlegada("4:00").conPermiteMaletas(false).buildAvianca());
        vuelos.add(new Vuelo.VueloBuilder().conIdVuelo("v005").conHoraSalida("20:00").conHoraLlegada("21:00").conPermiteMaletas(false).buildAvianca());
        vuelos.add(new Vuelo.VueloBuilder().conIdVuelo("v006").conHoraSalida("23:00").conHoraLlegada("24:00").conPermiteMaletas(true).buildAvianca());
        vuelos.add(new Vuelo.VueloBuilder().conIdVuelo("v007").conHoraSalida("6:00").conHoraLlegada("7:00").conPermiteMaletas(true).buildAvianca());
    }

    @Override
    public List<Vuelo> consultarVuelosDisponibles(ReservaViaje reservaViaje) {
        List<Vuelo> vuelosReturn;
        try{
            int max = vuelos.size();
            int min = 0;

            Random r = SecureRandom.getInstanceStrong();
            int fromIndex = r.nextInt((max - min) + 1) + min;
            int toIndex = r.nextInt((max - fromIndex) + 1) + fromIndex;

            vuelosReturn = vuelos.subList(fromIndex, toIndex);
        }catch (Exception ex){
            vuelosReturn = new ArrayList<>();
        }
        return vuelosReturn;
    }
}
