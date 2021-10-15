package com.dbc;

import java.util.*;

public abstract class ContaCliente {
    private Integer idCliente;
    private String nome;
    private String telefone;
    private String email;
    private Livro livro;

    public ContaCliente(Integer idCliente, String nome, String telefone, String email, Livro livro, List<ContaCliente> listaDeContas) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.livro = livro;
        this.listaDeContas = listaDeContas;
    }

    private List<ContaCliente> listaDeContas;

    public ContaCliente() {
        this.listaDeContas = new ArrayList<>();
    }

    public void adicionarContaCliente(ContaCliente novaConta) {
        this.listaDeContas.add(novaConta);
    }

    public void listarContas() {
        for (int i = 0; i < listaDeContas.size(); i++) {
            System.out.println("id=" + i + " | " + listaDeContas.get(i));
        }
    }

    public void editarId(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void editarNome(String nome) {
        this.nome = nome;
    }

    public void editarTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void editarEmail(String email) {
        this.email = email;
    }

    public void editarLivro(Livro livro) {
        this.livro = livro;
    }

    public void removerContaCliente(Integer idCliente) {
        this.listaDeContas.remove(idCliente.intValue());
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
