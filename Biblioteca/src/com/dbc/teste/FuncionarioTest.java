package com.dbc.teste;

import com.dbc.Funcionario;

import java.util.Scanner;

public class FuncionarioTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Funcionario editorFuncionario = new Funcionario();
        int opcao = 0;
        while(opcao != 9){
            System.out.println("Digite 1 para criar funcionario.");
            System.out.println("Digite 2 para buscar funcionario.");
            System.out.println("Digite 3 para editar funcionario.");
            System.out.println("Digite 4 para excluir funcionario.");
            System.out.println("Digite 9 para sair.");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch(opcao){
                case 1:
                    Funcionario funcionario = new Funcionario();
                    System.out.println("Digite o id do novo funcionario: ");
                    funcionario.setIdFuncionario(scanner.nextInt());
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
                    editorFuncionario.buscarFuncionario();
                    break;
                case 3:
                    System.out.println("Qual funcionario voce deseja editar?");
                    editorFuncionario.buscarFuncionario();
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    Funcionario funcionarioEdit = new Funcionario();
                    System.out.println("Digite o novo id do funcionario: ");
                    funcionarioEdit.setIdFuncionario(scanner.nextInt());
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
                    editorFuncionario.buscarFuncionario();
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
