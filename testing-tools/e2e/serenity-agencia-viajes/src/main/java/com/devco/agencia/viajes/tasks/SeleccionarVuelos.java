package com.devco.agencia.viajes.tasks;

import com.devco.agencia.viajes.interactions.ValidarVuelos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;

import static com.devco.agencia.viajes.user_interface.ReservaVuelosPage.SUBMIT_RESERVA;
import static com.devco.agencia.viajes.user_interface.VuelosDisponiblesPage.PRIMER_VUELO_EN_LISTA;
import static com.devco.agencia.viajes.user_interface.VuelosDisponiblesPage.SEGUNDO_VUELO_EN_LISTA;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SeleccionarVuelos implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight().attemptsTo(
                ValidarVuelos.suficientes(),
                Click.on(PRIMER_VUELO_EN_LISTA),
                Click.on(SEGUNDO_VUELO_EN_LISTA),
                Click.on(SUBMIT_RESERVA)
        );
    }

    public static Performable deIdayRegreso() {
        return instrumented(SeleccionarVuelos.class);
    }

}
