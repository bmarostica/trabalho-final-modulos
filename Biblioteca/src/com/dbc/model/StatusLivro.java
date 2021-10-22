package com.dbc.model;

import java.util.Arrays;

public enum StatusLivro {
    DISPONIVEL(1),
    INDISPONIVEL(2);

    private Integer status;

    StatusLivro(Integer status) {
        this.status = status;
    }

    public Integer getStatusLivro() {
        return status;
    }

    public static StatusLivro ofStatus(Integer sl) {
        return Arrays.stream(StatusLivro.values())
                .filter(status -> status.getStatusLivro().equals(sl))
                .findFirst()
                .get();
    }
}
