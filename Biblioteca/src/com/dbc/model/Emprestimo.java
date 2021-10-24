package com.dbc.model;

public class Emprestimo {
    private Integer idEmprestimo;
    private Integer idClienteEmprestimo;
    private Integer idLivroEmprestimo;
    private Integer idFuncionarioEmprestimo;
    private String tituloLivroEmprestimo;
    private String nomeClienteEmprestimo;
    private String nomeFuncionarioEmprestimo;

    public Integer getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Integer getIdClienteEmprestimo() {
        return idClienteEmprestimo;
    }

    public void setIdClienteEmprestimo(Integer idClienteEmprestimo) {
        this.idClienteEmprestimo = idClienteEmprestimo;
    }

    public Integer getIdLivroEmprestimo() {
        return idLivroEmprestimo;
    }

    public void setIdLivroEmprestimo(Integer idLivroEmprestimo) {
        this.idLivroEmprestimo = idLivroEmprestimo;
    }

    public Integer getIdFuncionarioEmprestimo() {
        return idFuncionarioEmprestimo;
    }

    public void setIdFuncionarioEmprestimo(Integer idFuncionarioEmprestimo) {
        this.idFuncionarioEmprestimo = idFuncionarioEmprestimo;
    }

    public String getTituloLivroEmprestimo() {
        return tituloLivroEmprestimo;
    }

    public void setTituloLivroEmprestimo(String tituloLivroEmprestimo) {
        this.tituloLivroEmprestimo = tituloLivroEmprestimo;
    }

    public String getNomeClienteEmprestimo() {
        return nomeClienteEmprestimo;
    }

    public void setNomeClienteEmprestimo(String nomeClienteEmprestimo) {
        this.nomeClienteEmprestimo = nomeClienteEmprestimo;
    }

    public String getNomeFuncionarioEmprestimo() {
        return nomeFuncionarioEmprestimo;
    }

    public void setNomeFuncionarioEmprestimo(String nomeFuncionarioEmprestimo) {
        this.nomeFuncionarioEmprestimo = nomeFuncionarioEmprestimo;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "idEmprestimo=" + idEmprestimo +
                ", idCliente=" + idClienteEmprestimo +
                ", idLivro=" + idLivroEmprestimo +
                ", idFuncionario=" + idFuncionarioEmprestimo +
                ", tituloLivro='" + tituloLivroEmprestimo + '\'' +
                ", nomeCliente='" + nomeClienteEmprestimo + '\'' +
                ", nomeFuncionario='" + nomeFuncionarioEmprestimo + '\'' +
                '}';
    }
}
