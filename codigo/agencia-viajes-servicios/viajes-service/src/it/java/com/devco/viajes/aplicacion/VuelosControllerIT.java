package com.devco.viajes.aplicacion;

import com.devco.viajes.dominio.entidades.ReservaViaje;
import com.devco.viajes.dominio.entidades.Vuelo;
import com.devco.viajes.infraestructura.integracion.VuelosDisponiblesAviancaClientMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("it-test")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VuelosControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VuelosDisponiblesAviancaClientMock vuelosDisponiblesAviancaClientMock;

    @Before
    public void setUp(){
        List<Vuelo> vuelos = Arrays.asList(new Vuelo.VueloBuilder().conIdVuelo("VTest").build(),
                new Vuelo.VueloBuilder().conIdVuelo("VTest2").build());

        when(vuelosDisponiblesAviancaClientMock.consultarVuelosDisponibles(Mockito.any(ReservaViaje.class))).thenReturn(vuelos);

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
                .andExpect(content().string("[{\"idVuelo\":\"VTest\",\"aerolinea\":null,\"horaSalida\":null" +
                        ",\"horaLlegada\":null,\"permiteMaletas\":false},{\"idVuelo\":\"VTest2\",\"aerolinea\":null" +
                        ",\"horaSalida\":null,\"horaLlegada\":null,\"permiteMaletas\":false}]"));
    }
}