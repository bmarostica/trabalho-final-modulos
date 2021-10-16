package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class ContaCLientePremium extends ContaCliente implements PlanosDeAssinatura {
    private double pontosFidelidade;

    List<ContaCLientePremium> listaPremium = new ArrayList<>();

    public void listarPremium() {
        for (int i = 0; i < listaPremium.size(); i++) {
            System.out.println("id=" + i + " | " + listaPremium.get(i));
        }
    }

    public void adicionarPremium(ContaCLientePremium conta) {
        this.listaPremium.add(conta);
    }

    public void removerPremium(Integer indice) {
        this.listaPremium.remove(indice.intValue());
    }

    public void editarPremium(Integer indice, ContaCLientePremium conta) {
        ContaCLientePremium contaParaEditar = listaPremium.get(indice);
        contaParaEditar.setIdCliente(conta.getIdCliente());
        contaParaEditar.setNome(conta.getNome());
        contaParaEditar.setEmail(conta.getEmail());
        contaParaEditar.setTelefone(conta.getTelefone());
        contaParaEditar.setLivro(conta.getLivro());
        contaParaEditar.setStatus(conta.getStatus());
    }

    public void cobrarMensalidade(double valor) {
    }

    public void imprimirContaPremium() {
        System.out.println("CLIENTE CONTA PREMIUM- "
        + "Id: " + this.getIdCliente()
        + "Nome: " + this.getNome()
        + "Telefone: " + this.getTelefone()
        + "Email: " + this.getEmail()
        + "Livro alugado: " + this.getLivro()
        + "Status: " + this.getStatus()
        + "Pontuação de fidelidade: " + this.getPontosFidelidade());
    }

    public double getPontosFidelidade() {
        return pontosFidelidade;
    }

    public void setPontosFidelidade(double pontosFidelidade) {
        this.pontosFidelidade = pontosFidelidade;
    }
}