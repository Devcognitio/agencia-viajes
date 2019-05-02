package com.devco.viajes.dominio.servicios;

import com.devco.viajes.dominio.entidades.ReservaViaje;
import com.devco.viajes.dominio.entidades.Vuelo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VueloService {
    List<Vuelo> consultarVuelosDisponibles(ReservaViaje reservaViaje);
}
