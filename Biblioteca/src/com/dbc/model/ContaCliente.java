package com.dbc.model;

import com.dbc.Livro;

public class ContaCliente implements PlanosDeAssinatura{
    private Integer idCliente;
    private String nome;
    private String telefone;
    private String email;
    private Livro livro;
    private StatusCliente status;
    private Integer pontosFidelidade;

    public ContaCliente(){

    }

    public ContaCliente(Integer idCliente, String nome, String telefone, String email, Livro livro, StatusCliente status, Integer pontosFidelidade) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.livro = livro;
        this.status = status;
        this.pontosFidelidade = pontosFidelidade;
    }

    public ContaCliente(Integer idCliente, String nome, String telefone, String email, StatusCliente status) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.status = status;
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

    public StatusCliente getStatus() {
        return status;
    }

    public void setStatus(StatusCliente status) {
        this.status = status;
    }

    public Integer getPontosFidelidade() {
        return pontosFidelidade;
    }

    public void setPontosFidelidade(Integer pontosFidelidade) {
        this.pontosFidelidade = pontosFidelidade;
    }

    @Override
    public String toString() {
        return "ContaCliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", livro=" + livro +
                ", status=" + status +
                ", pontos=" + pontosFidelidade +
                '}';
    }

    @Override
    public void cobrarMensalidade(double valor) {
        ContaCliente cliente = new ContaCliente();
        if(cliente.getPontosFidelidade() > 0) {
            cliente.setPontosFidelidade((int) (cliente.getPontosFidelidade() - valor));
        }
    }
}
