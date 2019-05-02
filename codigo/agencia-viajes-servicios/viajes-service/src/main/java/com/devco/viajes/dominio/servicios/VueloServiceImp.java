package com.devco.viajes.dominio.servicios;

import com.devco.viajes.dominio.entidades.ReservaViaje;
import com.devco.viajes.dominio.entidades.Vuelo;
import com.devco.viajes.infraestructura.integracion.VuelosDisponiblesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VueloServiceImp implements VueloService {

    private VuelosDisponiblesClient[] vuelosDisponiblesClients;

    @Override
    public List<Vuelo> consultarVuelosDisponibles(ReservaViaje reservaViaje) {
        List<Vuelo> resp = Arrays.stream(vuelosDisponiblesClients)
                .map((VuelosDisponiblesClient cliente) -> cliente.consultarVuelosDisponibles(reservaViaje))
                .flatMap(vuelos -> vuelos.stream())
                .collect(Collectors.toList());

        return resp;
    }

    @Autowired
    public void setVuelosDisponiblesClients(VuelosDisponiblesClient[] vuelosDisponiblesClients) {
        this.vuelosDisponiblesClients = vuelosDisponiblesClients;
    }

}
