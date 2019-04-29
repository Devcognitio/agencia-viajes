package com.devco.viajes.infraestructura.integracion;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class VuelosDisponiblesClientTestConf {

    @Bean
    @Primary
    public VuelosDisponiblesClient aviancaServiceMock(){
        return Mockito.mock(VuelosDisponiblesAviancaClientMock.class);
    }
}
