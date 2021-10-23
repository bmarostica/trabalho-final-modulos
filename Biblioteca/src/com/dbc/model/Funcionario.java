package com.dbc.model;

public class Funcionario {
    private Integer idFuncionario;
    private String nomeFuncionario;
    private String telFuncionario;
    private String emailFuncionario;

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getTelFuncionario() {
        return telFuncionario;
    }

    public void setTelFuncionario(String telFuncionario) {
        this.telFuncionario = telFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "idFuncionario=" + idFuncionario +
                ", nomeFuncionario='" + nomeFuncionario + '\'' +
                ", telFuncionario='" + telFuncionario + '\'' +
                ", emailFuncionario='" + emailFuncionario + '\'' +
                '}';
    }
}
