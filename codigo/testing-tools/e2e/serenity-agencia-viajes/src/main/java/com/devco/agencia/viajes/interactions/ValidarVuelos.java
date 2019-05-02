package com.devco.agencia.viajes.interactions;

import com.devco.agencia.viajes.exceptions.VuelosDisponiblesInsuficientes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.devco.agencia.viajes.user_interface.ReservaVuelosPage.CONSULTAR_VIAJE_BOTON;
import static com.devco.agencia.viajes.user_interface.VuelosDisponiblesPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidarVuelos implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        List filasVuelosDisponibles = FILAS_TABLA_VUELOS_DISPONIBLES.resolveAllFor(actor);
        int iteraciones = 0;
        while(filasVuelosDisponibles.size() < 2){
            CONSULTAR_VIAJE_BOTON.resolveFor(actor).click();
            WaitUntil.angularRequestsHaveFinished();
            filasVuelosDisponibles = FILAS_TABLA_VUELOS_DISPONIBLES.resolveAllFor(actor);
            iteraciones ++;
            if (iteraciones > 20){
                throw new VuelosDisponiblesInsuficientes("Vuelos Disponibles Insuficientes para seleccionar", null);
            }
        }
    }

    public static Performable suficientes(){
        return instrumented(ValidarVuelos.class);
    }
}
