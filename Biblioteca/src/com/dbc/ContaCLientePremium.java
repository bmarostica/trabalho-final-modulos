package com.dbc;

import java.util.List;

public class ContaCLientePremium extends ContaCliente implements PlanosDeAssinatura{
    private int pontuacao;
    //O Cliente Premium pode acumular pontos que poderão ser trocados por "prêmios" futuramente//


    public ContaCLientePremium(Integer idCliente, String nome, String telefone, String email, Livro livro, StatusCliente status, List<ContaCliente> listaDeContas, int pontuacao) {
        super(idCliente, nome, telefone, email, livro, status, listaDeContas);
        this.pontuacao = pontuacao;
    }

    public ContaCLientePremium() {
    }

    @Override
    public void cobrarMensalidade(double valor) {

    }
}
