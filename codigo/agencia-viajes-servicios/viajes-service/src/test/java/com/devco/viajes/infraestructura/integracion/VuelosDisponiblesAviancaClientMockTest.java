package com.devco.viajes.infraestructura.integracion;

import com.devco.viajes.dominio.entidades.ReservaViaje;
import com.devco.viajes.dominio.entidades.Vuelo;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class VuelosDisponiblesAviancaClientMockTest {
    @Mock
    ReservaViaje reservaViaje;

    @Test
    public void obtenerListaDeVuelosAleatoriaIndependienteDeLaReserva(){
        VuelosDisponiblesClient vuelosDisponiblesClient = new VuelosDisponiblesAviancaClientMock();

        List<Vuelo> vuelos = vuelosDisponiblesClient.consultarVuelosDisponibles(reservaViaje);

        assertThat(vuelos, is(instanceOf(List.class)));
    }

    @Test
    public void obtenerListaDeVuelosVaciaCuandoConReservaNoSeEncuentranVuelos(){
        VuelosDisponiblesClient vuelosDisponiblesClient = Mockito.spy(new VuelosDisponiblesAviancaClientMock());
        ReflectionTestUtils.setField(vuelosDisponiblesClient,"vuelos",new ArrayList<Vuelo>());

        List<Vuelo> vuelos = vuelosDisponiblesClient.consultarVuelosDisponibles(reservaViaje);

        assertThat(vuelos, is(empty()));
    }
}