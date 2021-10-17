package com.dbc;
import java.util.ArrayList;
import java.util.List;

public class Contas {

    List<ContaCLientePremium> listaPremium = new ArrayList<>();

    List<ContaClienteComum> listaClientesComum = new ArrayList<>();

    public List<ContaCLientePremium> listarContasPremium() {
        for (int i = 0; i < listaPremium.size(); i++) {
            System.out.println("id=" + i + " | " + listaPremium.get(i));
        }
        return this.listaPremium;
    }

    public void adicionarContaNaListaPremium(ContaCLientePremium conta) {
        this.listaPremium.add(conta);
    }

    public boolean removerContaPremium(Integer indice) {
        this.listaPremium.remove(indice.intValue());
        return true;
    }

    public List<ContaClienteComum> listarContasComum() {
        for (int i = 0; i < listaClientesComum.size(); i++) {
            System.out.println("id=" + i + " | " + listaClientesComum.get(i));
        }
        return this.listaClientesComum;
    }

    public void adicionarContaComum(ContaClienteComum conta) {
        this.listaClientesComum.add(conta);
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
        //contaParaEditar.setLivro(conta.getLivro());
        contaParaEditar.setStatus(conta.getStatus());
        return contaParaEditar;
    }

    public ContaCLientePremium editarContaPremium(Integer indice, ContaCLientePremium conta) {
        ContaCLientePremium contaParaEditar = listaPremium.get(indice);
        contaParaEditar.setIdCliente(conta.getIdCliente());
        contaParaEditar.setNome(conta.getNome());
        contaParaEditar.setEmail(conta.getEmail());
        contaParaEditar.setTelefone(conta.getTelefone());
        //contaParaEditar.setLivro(conta.getLivro());
        contaParaEditar.setStatus(conta.getStatus());
        return contaParaEditar;
    }



}
