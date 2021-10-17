package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class ContaClienteComum extends ContaCliente {
    private List<ContaClienteComum> listaClientesComum = new ArrayList<>();

    public ContaClienteComum(Integer idCliente, String nome, String telefone, String email, StatusCliente status) {
        super(idCliente, nome, telefone, email, status);
    }

    public ContaClienteComum(){

    }

    public void imprimirContaComum() {
        System.out.println("CLIENTE CONTA COMUM- "
                + "Id: " + this.getIdCliente()
                + "Nome: " + this.getNome()
                + "Telefone: " + this.getTelefone()
                + "Email: " + this.getEmail()
                + "Livro alugado: " + this.getLivro()
                + "Status: " + this.getStatus());
    }

    public List<ContaClienteComum> listarContasComum() {
        for (int i = 0; i < listaClientesComum.size(); i++) {
            System.out.println("id=" + i + " | " + listaClientesComum.get(i));
        }
        return this.listaClientesComum;
    }

    public void adicionarContaComum(ContaClienteComum conta) {
        listaClientesComum.add(conta);
    }

    public boolean removerContaComum(Integer indice) {
        this.listaClientesComum.remove(indice.intValue());
        return true;
    }

    public ContaClienteComum editarContaComum(Integer index, ContaClienteComum conta) {
        ContaClienteComum contaParaEditar = listaClientesComum.get(index);
        contaParaEditar.setIdCliente(conta.getIdCliente());
        contaParaEditar.setNome(conta.getNome());
        contaParaEditar.setEmail(conta.getEmail());
        contaParaEditar.setTelefone(conta.getTelefone());
        contaParaEditar.setLivro(conta.getLivro());
        contaParaEditar.setStatus(conta.getStatus());
        return contaParaEditar;
    }

}
