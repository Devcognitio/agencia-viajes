package com.devco.viajes.infraestructura.bd;

import com.devco.viajes.dominio.entidades.ReservaViaje;
import org.junit.Test;
import org.mockito.Mock;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ReservaFactoryMockTest {
    @Mock
    ReservaViaje reservaViajeMock;

    @Test
    public void guardarReservaViajeRetornaElMismoObjQueRecibe(){
        ReservaFactoryMock reservaFactoryMock = new ReservaFactoryMock();

        ReservaViaje resp = reservaFactoryMock.guardarReservaViaje(reservaViajeMock);

        assertThat(resp, is(reservaViajeMock));
    }

}