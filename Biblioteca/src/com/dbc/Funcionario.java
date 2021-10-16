package com.dbc;
import java.util.ArrayList;
import java.util.List;
import java.lang.Override;

public class Funcionario{
    private Integer idFuncionario;
    private String nomeFuncionario;
    private String telefoneFuncionario;
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

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }
    @Override
    public String toString(){
        return " |Funcionario ID: "+ idFuncionario +
                " Nome: " + nomeFuncionario +
                " Telefone: " + telefoneFuncionario +
                " Email: " + emailFuncionario +
                " | ";
    }

    //Daqui pra baixo é CRUD


    private List<Funcionario> listaDeFuncionarios;

    public Funcionario(){
        this.listaDeFuncionarios = new ArrayList<>();
    }


    public void criarFuncionario(Funcionario funcionario) {
        this.listaDeFuncionarios.add(funcionario);
    }


    public void buscarFuncionario() {
        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
            System.out.println("id=" + i + " | " + listaDeFuncionarios.get(i));
        }
    }


    public void alterarFuncionario(Integer index, Funcionario funcionario){
        Funcionario funcionarioProcurado = listaDeFuncionarios.get(index);
        funcionarioProcurado.setIdFuncionario(funcionario.getIdFuncionario());
        funcionarioProcurado.setNomeFuncionario(funcionario.getNomeFuncionario());
        funcionarioProcurado.setTelefoneFuncionario(funcionario.getTelefoneFuncionario());
        funcionarioProcurado.setEmailFuncionario(funcionario.getEmailFuncionario());
    }


    public void deletarFuncionario(Integer index) {
        this.listaDeFuncionarios.remove(index.intValue());
    }
}