package com.devco.viajes.infraestructura.integracion;

import com.devco.viajes.dominio.entidades.ReservaViaje;
import com.devco.viajes.dominio.entidades.Vuelo;

import java.util.List;

public interface VuelosDisponiblesClient {
    public List<Vuelo> consultarVuelosDisponibles(ReservaViaje reservaViaje);
}
