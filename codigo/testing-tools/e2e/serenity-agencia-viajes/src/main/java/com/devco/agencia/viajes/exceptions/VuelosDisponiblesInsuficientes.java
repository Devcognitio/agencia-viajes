package com.devco.agencia.viajes.exceptions;

public class VuelosDisponiblesInsuficientes extends AssertionError {

    public VuelosDisponiblesInsuficientes(String message, Throwable cause) {
        super(message, cause);
    }
}
