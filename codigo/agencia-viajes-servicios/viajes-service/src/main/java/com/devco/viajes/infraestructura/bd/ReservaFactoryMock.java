package com.devco.viajes.infraestructura.bd;

import com.devco.viajes.dominio.entidades.ReservaViaje;

public class ReservaFactoryMock implements ReservaFactory{

    @Override
    public ReservaViaje guardarReservaViaje(ReservaViaje reservaViaje) {
        return reservaViaje;
    }
}
