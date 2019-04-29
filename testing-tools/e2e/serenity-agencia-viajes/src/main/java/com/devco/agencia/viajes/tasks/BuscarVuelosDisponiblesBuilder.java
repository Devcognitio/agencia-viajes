package com.devco.agencia.viajes.tasks;

import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarVuelosDisponiblesBuilder {
    private String origen;
    private String destino;
    private String fechaIda;
    private String fechaRegreso;

    public BuscarVuelosDisponiblesBuilder de(String origen){
        this.origen = origen;
        return this;
    }

    public BuscarVuelosDisponiblesBuilder a(String destino){
        this.destino = destino;
        return this;
    }

    public BuscarVuelosDisponiblesBuilder patiendoDesde(String fechaIda){
        this.fechaIda = fechaIda;
        return this;
    }

    public Performable regresandoEn(String fechaRegreso){
        this.fechaRegreso = fechaRegreso;
        return build();
    }

    public Performable build() {
        return instrumented(BuscarVuelosDisponibles.class, origen, destino, fechaIda, fechaRegreso);
    }
}
