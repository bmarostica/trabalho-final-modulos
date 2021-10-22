package com.dbc.teste;

import com.dbc.model.Funcionario;
import com.dbc.service.FuncionarioService;

import java.util.Scanner;

public class MainTesteFuncionario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FuncionarioService funcionarioService = new FuncionarioService();

        int opcao = 0;
        while (opcao != 9) {
            System.out.println("Digite 1 para criar funcionário.");
            System.out.println("Digite 2 para listar os funcionários.");
            System.out.println("Digite 3 para editar um funcionário.");
            System.out.println("Digite 4 para excluir um funcionário.");
            System.out.println("Digite 9 para sair.");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1: {
                    Funcionario funcionario = new Funcionario();
                    System.out.println("Digite o nome do funcionário.");
                    funcionario.setNomeFuncionario(scanner.nextLine());

                    System.out.println("Digite o telefone do funcionário.");
                    funcionario.setTelFuncionario(scanner.nextLine());

                    System.out.println("Digite o email do funcionário.");
                    funcionario.setEmailFuncionario(scanner.nextLine());

                    funcionarioService.adicionarFuncionario(funcionario);
                    break;
                }
                case 2: {
                    funcionarioService.listarFuncionarios();
                    break;
                }
                case 3: {
                    System.out.println("Qual funcionário você deseja editar?");
                    funcionarioService.listarFuncionarios();
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Funcionario editFuncionario = new Funcionario();
                    System.out.println("Digite o novo nome.");
                    editFuncionario.setNomeFuncionario(scanner.nextLine());

                    System.out.println("Digite o novo telefone.");
                    editFuncionario.setTelFuncionario(scanner.nextLine());

                    System.out.println("Digite o novo email.");
                    editFuncionario.setEmailFuncionario(scanner.nextLine());

                    funcionarioService.editarFuncionario(id, editFuncionario);
                    break;
                }
                case 4: {
                    System.out.println("Qual funcionário deseja excluir?");
                    funcionarioService.listarFuncionarios();
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    funcionarioService.removerFuncionario(id);
                    break;
                }
                case 9:
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        }
    }
}
