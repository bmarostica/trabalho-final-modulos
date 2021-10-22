package com.dbc.model;

import java.util.Arrays;

public enum Formato {
    BROCHURA(1),
    CAPA_DURA(2);

    private Integer tipo;

    Formato(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static Formato ofFormato(Integer f) {
        return Arrays.stream(Formato.values())
                .filter(tipo -> tipo.getTipo().equals(f))
                .findFirst()
                .get();
    }
}
