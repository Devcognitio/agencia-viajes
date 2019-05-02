package com.devco.viajes.infraestructura.integracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!test && !it-test")
@Configuration
public class VuelosDisponiblesClientConfig {

    @Bean
    public VuelosDisponiblesClient aviancaService(){
        return new VuelosDisponiblesAviancaClientMock();
    }
}
