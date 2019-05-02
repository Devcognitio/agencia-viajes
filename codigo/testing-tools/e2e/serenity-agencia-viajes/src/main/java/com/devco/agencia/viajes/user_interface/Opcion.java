package com.devco.agencia.viajes.user_interface;

public enum Opcion {

    AgenciaViajes("http://localhost:4200/");

    private final String url;

    Opcion(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }
}
