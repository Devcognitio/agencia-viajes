package com.devco.viajes.aplicacion;

import com.devco.viajes.dominio.entidades.ReservaViaje;
import com.devco.viajes.dominio.entidades.Vuelo;
import com.devco.viajes.dominio.servicios.VueloServiceImp;
import com.devco.viajes.excepciones.ParametrosIncorrectos;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(VuelosController.class)
public class VuelosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VueloServiceImp vuelosService;
    private ReservaViaje reservaViajeMock;

    @Before
    public void setUp() throws NoSuchAlgorithmException {
        List<Vuelo> vuelos = Arrays.asList(new Vuelo.VueloBuilder().conIdVuelo("VTest").build());
        ReservaViaje reservaViajeMock = new ReservaViaje.ReservaViajeBuilder().conOrigen("colombia").conIdReserva("ROkTest").build();
        ReservaViaje reservaViajeFailMock = new ReservaViaje.ReservaViajeBuilder().conOrigen("peru").conIdReserva("RFailTest").build();

        when(vuelosService.consultarVuelosDisponibles(reservaViajeMock)).thenReturn(vuelos);
        when(vuelosService.consultarVuelosDisponibles(reservaViajeFailMock)).thenThrow(new RuntimeException());

        new MockUp<ReservaViaje.ReservaViajeBuilder>(){
            @Mock
            ReservaViaje.ReservaViajeBuilder conNroPasajeros(String input ) throws ParametrosIncorrectos {
                if (input == "5"){
                    throw new ParametrosIncorrectos();
                }
                return this.getMockInstance();
            }

            @Mock
            ReservaViaje build(){
                if (this.getMockInstance().getOrigen() == "peru"){
                    return reservaViajeFailMock;
                }
                return reservaViajeMock;
            }

        };
    }

    @Test
    public void retornaOKCuandoSeEnvianLosParametrosObligatorios() throws Exception {
        this.mockMvc.perform(get("/vuelos/disponibles")
                .param("origen", "colombia")
                .param("destino", "peru")
                .param("fechaIda", "01-01-2019")
                .param("fechaRegreso", "02-01-2019"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"idVuelo\":\"VTest\",\"aerolinea\":null,\"horaSalida\":null,\"horaLlegada\":null,\"permiteMaletas\":false}]"));
    }

    @Test
    public void retornaOKCuandoSeEnvianLosParametrosObligatoriosYOpcionales() throws Exception {
        this.mockMvc.perform(get("/vuelos/disponibles")
                .param("origen", "argentina")
                .param("destino", "peru")
                .param("fechaIda", "01-01-2019")
                .param("fechaRegreso", "02-01-2019")
                .param("nroPasajeros", "1")
                .param("clase", "ejecutiva"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"idVuelo\":\"VTest\",\"aerolinea\":null,\"horaSalida\":null,\"horaLlegada\":null,\"permiteMaletas\":false}]"));
    }

    @Test
    public void retornaBadRequestCuandoNoSeEnvianLosParametrosObligatorios() throws Exception {
        this.mockMvc.perform(get("/vuelos/disponibles"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void retornaBadRequestCuandoElServicioFallaConParametrosIncorrectos() throws Exception {
        this.mockMvc.perform(get("/vuelos/disponibles")
                .param("origen", "brasil")
                .param("destino", "peru")
                .param("fechaIda", "01-01-2019")
                .param("fechaRegreso", "02-01-2019")
                .param("nroPasajeros", "5"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void retornaInternalServerErrorCuandoElServicioFallaSinControl() throws Exception {
        this.mockMvc.perform(get("/vuelos/disponibles")
                .param("origen", "peru")
                .param("destino", "cusco")
                .param("fechaIda", "01-01-2019")
                .param("fechaRegreso", "02-01-2019"))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }
}