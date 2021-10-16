package com.dbc;

public class ContaCLientePremium extends ContaCliente implements PlanosDeAssinatura {
    private double pontosFidelidade;

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