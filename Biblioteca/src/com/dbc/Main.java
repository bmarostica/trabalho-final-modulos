package com.dbc;

import com.dbc.model.ContaCliente;
import com.dbc.model.Funcionario;
import com.dbc.service.ContaClienteService;
import com.dbc.service.FuncionarioService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //CRIAR CONTA, FUNCIONARIO, LIVRO ANTES DE APLICAR

        System.out.println("Digite 1 para Conta, 2 para Funcionário");
        int digito = scanner.nextInt();

        switch (digito) {
            case 1:
                ContaClienteService contaService = new ContaClienteService();

                int opcao = -1;
                while (opcao != 0) {
                    System.out.println("Digite 1 para criar conta");
                    System.out.println("Digite 2 para listar contas");
                    System.out.println("Digite 3 para editar uma conta");
                    System.out.println("Digite 4 para excluir contas");
                    System.out.println("Digite 0 para sair");
                    opcao = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcao) {
                        case 1: {// adição
                            ContaCliente conta = new ContaCliente();
                            System.out.println("Digite o nome do Cliente");
                            conta.setNome(scanner.nextLine());

                            System.out.println("Digite o telefone)");
                            conta.setTelefone(scanner.nextLine());

                            System.out.println("Digite o email");
                            conta.setEmail(scanner.nextLine());

                            contaService.adicionarConta(conta);
                            break;
                        }
                        case 2: {

                            contaService.listarContas();
                            break;
                        }
                        case 3: {

                            System.out.println("Qual conta você deseja editar?");
                            contaService.listarContas();
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            ContaCliente contaNova = new ContaCliente();
                            System.out.println("Digite o nome do Cliente");

                            contaNova.setNome(scanner.nextLine());
                            System.out.println("Digite o telefone do Cliente");

                            contaNova.setTelefone(scanner.nextLine());
                            System.out.println("Digite o email");

                            contaNova.setEmail(scanner.nextLine());
                            contaService.editarConta(id, contaNova);
                            break;
                        }
                        case 4: {

                            System.out.println("Qual conta você deseja excluir?");
                            contaService.listarContas();
                            int id = scanner.nextInt();
                            contaService.removerConta(id);
                            break;
                        }

                        case 0:
                            break;
                        default:
                            System.err.println("opção inválida");
                            break;
                    }
                }
            case 2:
                FuncionarioService funcionarioService = new FuncionarioService();

                opcao = 0;
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
}