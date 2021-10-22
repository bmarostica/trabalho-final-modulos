package com.dbc.model;
import com.dbc.service.LivroService;

public class Emprestimo {

    private Integer idEmprestimo;
    private Livro livro;
    private LivroService livroService;
    private ContaCliente cliente;
    private Funcionario funcionario;

    public Emprestimo() {
    }

    public Emprestimo(Livro livro, ContaCliente cliente, Funcionario funcionario) {
        this.livro = livro;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LivroService getLivroService() {
        return livroService;
    }

    public void setLivroService(LivroService livroService) {
        this.livroService = livroService;
    }

    public ContaCliente getCliente() {
        return cliente;
    }

    public void setCliente(ContaCliente cliente) {
        this.cliente = cliente;
    }

    public Integer getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    @Override
    public String toString() {
        return "Empréstimo{" +
                "Cliente=" + cliente +
                ", Funcionário='" + funcionario +
                ", Livro='" + livro +
                '}';
    }

    public void setLivro(String livro) {
    }

    public void setCliente(String titulo) {
    }

    public void setFuncionario(String funcionario) {
    }
}
