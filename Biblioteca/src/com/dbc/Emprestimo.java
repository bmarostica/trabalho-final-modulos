package com.dbc;


import com.dbc.model.ContaCliente;

public class Emprestimo {

    private Livro livro;
    private ContaCliente cliente;
    private Funcionario funcionario;

    public Emprestimo() {
    }

    public Emprestimo(Livro livro, ContaCliente cliente, Funcionario funcionario) {
        this.livro = livro;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public void efetuarEmprestimo(Emprestimo emprestimo) {
        livro.acidionarLivroNaBase(emprestimo.livro);
        emprestimo.cliente.setPontosFidelidade(emprestimo.cliente.getPontosFidelidade()+1);
        System.out.println("Funcionário: " + funcionario.getNomeFuncionario() + " alugou o livro "
                        + livro.getTitulo() + " para o cliente:  " + cliente.getNome());
    }

    public void emprestimoClienteComum(Livro livro, Funcionario funcionario, ContaCliente clienteComum){
        livro.deletarParaEmprestimo(livro);
        System.out.println("Funcionário: " + funcionario.getNomeFuncionario() + " fez o emprestimo do livro: " + livro.getTitulo() +
                ", a(o) cliente: " + cliente.getNome());
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public ContaCliente getClientePremium() {
        return cliente;
    }

    public void setClientePremium(ContaCliente clientePremium) {
        this.cliente = clientePremium;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
