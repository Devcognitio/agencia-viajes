package com.devco.agencia.viajes.step_definitions;

import com.devco.agencia.viajes.questions.ElTituloDeLaPagina;
import com.devco.agencia.viajes.tasks.BuscarVuelosDisponibles;
import com.devco.agencia.viajes.tasks.Navegar;
import com.devco.agencia.viajes.tasks.SeleccionarVuelos;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.devco.agencia.viajes.user_interface.Opcion.AgenciaViajes;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;


public class ReservaVuelosStepDefinitions {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que (.*) ha decidido reservar vuelos")
    public void haDecididoReservarVuelos(String nombrePersona) throws Throwable {
        theActorCalled(nombrePersona).attemptsTo(
                Navegar.a(AgenciaViajes)
        );
    }

    @Cuando("^elige los vuelos de ida y regreso desde (.*) para (.*) en las fechas: (.*) a (.*)")
    public void elijeVuelosIdaYRegreso(String origen, String destino, String fechaIda, String fechaRegreso) throws Throwable {
        theActorInTheSpotlight().attemptsTo(
                BuscarVuelosDisponibles.paraViaje()
                        .de(origen)
                        .a(destino)
                        .patiendoDesde(fechaIda)
                        .regresandoEn(fechaRegreso),
                SeleccionarVuelos.deIdayRegreso()
        );
    }

    @Entonces("^el deberia poder confirmar su reservacion$")
    public void elDeberiaConfirmarReservacion() throws Throwable {
        theActorInTheSpotlight().should(
                seeThat(ElTituloDeLaPagina.es(), not(isEmptyString()))
        );
    }
}
