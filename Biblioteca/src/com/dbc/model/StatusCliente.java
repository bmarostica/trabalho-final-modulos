package com.dbc.model;

import java.util.Arrays;

public enum StatusCliente {
    OK(1),
    BLOQUEADO(2),
    CANCELADO(3);

    private Integer descricao;

    StatusCliente(Integer descricao) {
        this.descricao = descricao;
    }

    public Integer getDescricao() {
        return this.descricao;
    }

    public static StatusCliente ofStatus(Integer sl) {
        return Arrays.stream(StatusCliente.values())
                .filter(statusCliente -> statusCliente.getDescricao().equals(sl))
                .findFirst()
                .get();
    }
}
