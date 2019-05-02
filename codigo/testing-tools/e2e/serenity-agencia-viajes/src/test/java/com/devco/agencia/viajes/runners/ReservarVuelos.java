package com.devco.agencia.viajes.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/reserva_de_vuelos/reserva_de_vuelos.feature",
                 glue = "com.devco.agencia.viajes.step_definitions" )
public class ReservarVuelos { }
