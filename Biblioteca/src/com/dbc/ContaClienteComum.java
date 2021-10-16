package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class ContaClienteComum extends ContaCliente {

    private List<ContaClienteComum> listaClientesComum = new ArrayList<>();

    public void listarContas() {
        for (int i = 0; i < listaClientesComum.size(); i++) {
            System.out.println("id=" + i + " | " + listaClientesComum.get(i));
        }
    }

    public void adicionarContaComum(ContaClienteComum conta) {
        this.listaClientesComum.add(conta);
    }

    public void removerConta(Integer indice) {
        this.listaClientesComum.remove(indice.intValue());
    }

    public void editarContaComum(Integer index, ContaClienteComum conta) {
        ContaClienteComum contaParaEditar = listaClientesComum.get(index);
        contaParaEditar.setIdCliente(conta.getIdCliente());
        contaParaEditar.setNome(conta.getNome());
        contaParaEditar.setEmail(conta.getEmail());
        contaParaEditar.setTelefone(conta.getTelefone());
        contaParaEditar.setLivro(conta.getLivro());
        contaParaEditar.setStatus(conta.getStatus());
    }

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
