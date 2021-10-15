package com.dbc;

import java.util.List;

public class ContaClienteComum extends ContaCliente {
    public ContaClienteComum(Integer idCliente, String nome, String telefone, String email, Livro livro, StatusCliente status, List<ContaCliente> listaDeContas) {
        super(idCliente, nome, telefone, email, livro, status, listaDeContas);
    }

    public ContaClienteComum() {
    }
}
