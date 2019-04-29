package com.devco.viajes.infraestructura.bd;

import com.devco.viajes.dominio.entidades.ReservaViaje;

public interface ReservaFactory {
    ReservaViaje guardarReservaViaje(ReservaViaje reservaViaje);
}
