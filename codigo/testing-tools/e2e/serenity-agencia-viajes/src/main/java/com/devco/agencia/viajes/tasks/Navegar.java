package com.devco.agencia.viajes.tasks;

import com.devco.agencia.viajes.user_interface.Opcion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Navegar implements Task {

    private final Opcion opcion;

    public Navegar(Opcion opcion) {
        this.opcion = opcion;
    }

    @Override
    @Step("{0} navega a la opción #opcion")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(opcion.url())
        );
    }

    public static Performable a(Opcion opcion) {
        return instrumented(Navegar.class, opcion);
    }
}
