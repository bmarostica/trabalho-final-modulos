package com.dbc;

import java.util.*;

public abstract class ContaCliente {
    private Integer idCliente;
    private String nome;
    private String telefone;
    private String email;
    private Livro livro;
    private StatusCliente status;

    public boolean editarId(int novoId) {
        if (novoId > 0) {
            setIdCliente(novoId);
            return true;
        }
        return false;
    }

    public boolean podeAlugar(StatusCliente status) {
        return status.equals(StatusCliente.OK);
    }

    public boolean editarTelefone(ContaCliente conta, String novoTelefone){
        if (!Objects.equals(novoTelefone, conta.getTelefone())) {
            conta.setTelefone(novoTelefone);
            return true;
        }
        return false;
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


}
