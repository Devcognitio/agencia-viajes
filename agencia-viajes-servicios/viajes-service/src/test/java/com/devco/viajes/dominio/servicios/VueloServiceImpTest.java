package com.devco.viajes.dominio.servicios;

import com.devco.viajes.dominio.entidades.ReservaViaje;
import com.devco.viajes.dominio.entidades.Vuelo;
import com.devco.viajes.infraestructura.integracion.VuelosDisponiblesAviancaClientMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class VueloServiceImpTest {

    @Autowired
    VuelosDisponiblesAviancaClientMock vuelosDisponiblesAviancaClientMock;

    @Autowired
    VueloService vueloService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void consultarVuelosDisponiblesRetornaListaVaciaSiAlConsultarLosClienteNoEncuentranInfo() {
        ReservaViaje reservaViaje1 = Mockito.mock(ReservaViaje.class);
        Mockito.when(vuelosDisponiblesAviancaClientMock.consultarVuelosDisponibles(reservaViaje1)).thenReturn(Collections.emptyList());

        List<Vuelo> vuelosDisponibles = vueloService.consultarVuelosDisponibles(reservaViaje1);

        //vuelosDisponibles.stream().forEach( x -> System.out.println(x.getIdVuelo()));
        assertThat(vuelosDisponibles, is(empty()));
    }

    @Test
    public void consultarVuelosDisponiblesRetornaListaConInfoSiTodoEstaOK() {
        ReservaViaje reservaViajeMock = Mockito.mock(ReservaViaje.class);
        Vuelo vueloMock = new Vuelo.VueloBuilder().conIdVuelo("VTest").build();
        List<Vuelo> vuelosDisponiblesMock = new ArrayList<Vuelo>();
        vuelosDisponiblesMock.add(vueloMock);
        Mockito.when(vuelosDisponiblesAviancaClientMock.consultarVuelosDisponibles(reservaViajeMock)).thenReturn(vuelosDisponiblesMock);

        List<Vuelo> vuelosDisponibles = vueloService.consultarVuelosDisponibles(reservaViajeMock);

        //vuelosDisponibles.stream().forEach( x -> System.out.println(x.getIdVuelo()));
        assertThat(vuelosDisponibles, contains(vueloMock));
    }

}