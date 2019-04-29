package com.devco.viajes.dominio.valueobjects;

public enum ClaseViaje {
    ECONOMICA("economica"),
    EJECUTIVA("ejecutiva"),
    PRIMERA_CLASE("primera_clase");

    private String clase;

    ClaseViaje (String clase) {
        this.clase = clase;
    }

    public String getClase() {
        return this.clase;
    }
}
