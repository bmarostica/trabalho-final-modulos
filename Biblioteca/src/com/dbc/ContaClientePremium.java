package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class ContaClientePremium extends ContaCliente implements PlanosDeAssinatura {
    private double pontosFidelidade;
    private List<ContaClientePremium> listaPremium = new ArrayList<>();

    public ContaClientePremium(Integer idCliente, String nome, String telefone, String email, StatusCliente status) {
        super(idCliente, nome, telefone, email, status);
    }

    public ContaClientePremium(){

    }

    public void cobrarMensalidade(double valor) {
    }

    public void imprimirContaPremium() {
        System.out.println("CLIENTE CONTA PREMIUM- "
        + "Id: " + this.getIdCliente()
        + "Nome: " + this.getNome()
        + "Telefone: " + this.getTelefone()
        + "Email: " + this.getEmail()
        //+ "Livro alugado: " + this.getLivro()
        + "Status: " + this.getStatus()
        + "Pontuação de fidelidade: " + this.getPontosFidelidade());
    }

    public double getPontosFidelidade() {
        return pontosFidelidade;
    }

    public void setPontosFidelidade(double pontosFidelidade) {
        this.pontosFidelidade = pontosFidelidade;
    }

    public List<ContaClientePremium> listarContasPremium() {
        for (int i = 0; i < listaPremium.size(); i++) {
            System.out.println("id=" + i + " | " + listaPremium.get(i));
        }
        return this.listaPremium;
    }

    public void adicionarContaNaListaPremium(ContaClientePremium conta) {
        this.listaPremium.add(conta);
    }

    public boolean removerContaPremium(Integer indice) {
        this.listaPremium.remove(indice.intValue());
        return true;
    }

    public ContaClientePremium editarContaPremium(Integer indice, ContaClientePremium conta) {
        ContaClientePremium contaParaEditar = listaPremium.get(indice);
        contaParaEditar.setIdCliente(conta.getIdCliente());
        contaParaEditar.setNome(conta.getNome());
        contaParaEditar.setEmail(conta.getEmail());
        contaParaEditar.setTelefone(conta.getTelefone());
        //contaParaEditar.setLivro(conta.getLivro());
        contaParaEditar.setStatus(conta.getStatus());
        return contaParaEditar;
    }
}