package com.devco.agencia.viajes.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.devco.agencia.viajes.user_interface.ReservaVuelosPage.*;

public class BuscarVuelosDisponibles implements Task {

    private String origen;
    private String destino;
    private String fechaIda;
    private String fechaRegreso;

    public BuscarVuelosDisponibles(String origen, String destino, String fechaIda, String fechaRegreso) {
        this.origen = origen;
        this.destino = destino;
        this.fechaIda = fechaIda;
        this.fechaRegreso = fechaRegreso;
    }

    @Override
    @Step("{0} busca vuelos disponibles para #origen a #destino, desde #fechaIda hasta #fechaRegreso")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(origen).into(ORIGEN_INPUT),
                Enter.theValue(destino).into(DESTINO_INPUT),
                Enter.theValue(fechaIda).into(FECHA_IDA_INPUT),
                Enter.theValue(fechaRegreso).into(FECHA_REGRESO_INPUT),
                Click.on(CONSULTAR_VIAJE_BOTON)
        );
    }

    public static BuscarVuelosDisponiblesBuilder paraViaje(){
        return new BuscarVuelosDisponiblesBuilder();
    }

}
