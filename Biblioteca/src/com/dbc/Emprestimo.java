package com.dbc;

import java.time.LocalDate;

public class Emprestimo {
    private static final Integer EMPRESTIMO_CLIENTE_PREMIUM = 30;

    private Livro livro;
    private ContaClientePremium clientePremium;
    private Funcionario funcionario;

    public Emprestimo() {
    }



    public Emprestimo(Livro livro, ContaClientePremium clientePremium, Funcionario funcionario) {
        this.livro = livro;
        this.clientePremium = clientePremium;
        this.funcionario = funcionario;
    }

    public void efetuarEmprestimo(Emprestimo emprestimo) {
        livro.cadastrar(emprestimo.livro);
        emprestimo.clientePremium.setPontosFidelidade(emprestimo.clientePremium.getPontosFidelidade()+1);
        System.out.println("Funcionário: " + funcionario.getNomeFuncionario() + " alugou o livro "
                        + livro.getTitulo() + " para o cliente:  " + clientePremium.getNome());
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public ContaClientePremium getClientePremium() {
        return clientePremium;
    }

    public void setClientePremium(ContaClientePremium clientePremium) {
        this.clientePremium = clientePremium;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
