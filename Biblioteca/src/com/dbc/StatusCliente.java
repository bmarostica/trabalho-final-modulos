package com.dbc;

public enum StatusCliente {
    OK("Tudo certo!"),
    BLOQUEADO("Pagamento Pendente!"),
    CANCELADO("Usuário Cancelado.");

    private String descricao;

    StatusCliente(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
