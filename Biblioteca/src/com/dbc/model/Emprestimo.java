package com.dbc.model;

public class Emprestimo {
    private Integer idEmprestimo;
    private Integer idClienteEmprestimo;
    private Integer idLivroEmprestimo;
    private Integer idFuncionarioEmprestimo;

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

    @Override
    public String toString() {
        return "Emprestimo{" +
                "idEmprestimo=" + idEmprestimo +
                ", idClienteEmprestimo=" + idClienteEmprestimo +
                ", idLivroEmprestimo=" + idLivroEmprestimo +
                ", idFuncionarioEmprestimo=" + idFuncionarioEmprestimo +
                '}';
    }
}
