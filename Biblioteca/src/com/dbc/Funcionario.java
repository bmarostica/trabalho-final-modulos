package com.dbc;
import java.util.ArrayList;
import java.util.List;
import java.lang.Override;
import java.util.Scanner;

public class Funcionario{
    Scanner scanner = new Scanner(System.in);

    private Integer registroFuncionario;
    private String nomeFuncionario;
    private String telefoneFuncionario;
    private String emailFuncionario;

    public Integer getRegistroFuncionario() {
        return registroFuncionario;
    }

    public void setRegistroFuncionario(Integer idFuncionario) {
        this.registroFuncionario = idFuncionario;
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
        return " | Registro: "+ registroFuncionario +
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


    public void listarFuncionario() {
        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
            System.out.println("id=" + (i + 1) + " | " + listaDeFuncionarios.get(i));
        }
    }


    public void alterarFuncionario(Integer index, Funcionario funcionario){
        Funcionario funcionarioProcurado = listaDeFuncionarios.get(index);
        funcionarioProcurado.setRegistroFuncionario(funcionario.getRegistroFuncionario());
        funcionarioProcurado.setNomeFuncionario(funcionario.getNomeFuncionario());
        funcionarioProcurado.setTelefoneFuncionario(funcionario.getTelefoneFuncionario());
        funcionarioProcurado.setEmailFuncionario(funcionario.getEmailFuncionario());
    }


    public void deletarFuncionario(Integer index) {
        this.listaDeFuncionarios.remove(index.intValue());
    }
    public void crudFuncionario(){
        Funcionario editorFuncionario = new Funcionario();
        int opcao = 0;
        while(opcao != 9){
            System.out.println("Digite 1 para criar funcionario.");
            System.out.println("Digite 2 para listar funcionarios.");
            System.out.println("Digite 3 para editar funcionario.");
            System.out.println("Digite 4 para excluir funcionario.");
            System.out.println("Digite 9 para sair.");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch(opcao){
                case 1:
                    Funcionario funcionario = new Funcionario();
                    System.out.println("Digite o número de registro do novo funcionario: ");
                    funcionario.setRegistroFuncionario(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Digite o nome do novo funcionario: ");
                    funcionario.setNomeFuncionario(scanner.nextLine());
                    System.out.println("Digite o telefone do novo funcionario: ");
                    funcionario.setTelefoneFuncionario(scanner.nextLine());
                    System.out.println("Digite email do novo funcionario: ");
                    funcionario.setEmailFuncionario(scanner.nextLine());
                    editorFuncionario.criarFuncionario(funcionario);
                    break;
                case 2:
                    editorFuncionario.listarFuncionario();
                    break;
                case 3:
                    System.out.println("Qual funcionario voce deseja editar?");
                    editorFuncionario.listarFuncionario();
                    int index = (scanner.nextInt() - 1);
                    scanner.nextLine();

                    Funcionario funcionarioEdit = new Funcionario();
                    System.out.println("Digite o novo registro do funcionario: ");
                    funcionarioEdit.setRegistroFuncionario(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Digite o novo nome do funcionario: ");
                    funcionarioEdit.setNomeFuncionario(scanner.nextLine());
                    System.out.println("Digite o novo telefone do funcionario: ");
                    funcionarioEdit.setTelefoneFuncionario(scanner.nextLine());
                    System.out.println("Digite o novo email do funcionario: ");
                    funcionarioEdit.setEmailFuncionario(scanner.nextLine());
                    editorFuncionario.alterarFuncionario(index, funcionarioEdit);
                    break;
                case 4:
                    System.out.println("Qual funcionario deseja excluir?");
                    editorFuncionario.listarFuncionario();
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    editorFuncionario.deletarFuncionario(id);
                    break;
                case 9:
                    break;
                default:
                    System.err.println("Opção inválida!");
                    break;


            }
        }
    }
}