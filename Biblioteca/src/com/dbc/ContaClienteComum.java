package com.dbc;

public class ContaClienteComum extends ContaCliente {

    public void imprimirContaComum() {
        System.out.println("CLIENTE CONTA PREMIUM- "
                + "Id: " + this.getIdCliente()
                + "Nome: " + this.getNome()
                + "Telefone: " + this.getTelefone()
                + "Email: " + this.getEmail()
                + "Livro alugado: " + this.getLivro()
                + "Status: " + this.getStatus());
    }


}
