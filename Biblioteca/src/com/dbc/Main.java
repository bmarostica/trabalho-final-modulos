package com.dbc;

import com.dbc.model.*;
import com.dbc.service.ContaClienteService;
import com.dbc.service.EmprestimoService;
import com.dbc.service.FuncionarioService;
import com.dbc.service.LivroService;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmprestimoService emprestimoService = new EmprestimoService();
        LivroService livroService = new LivroService();
        ContaClienteService contaService = new ContaClienteService();
        FuncionarioService funcionarioService = new FuncionarioService();

        int switchControl = -1;
        do {
            System.out.println("Selecione o item que deseja manipular: ");
            System.out.println("1 - Livro");
            System.out.println("2 - Cliente");
            System.out.println("3 - Funcionário");
            System.out.println("4 - Empréstimo");
            System.out.println("0 - Sair");
            do {
                try {
                    switchControl = scanner.nextInt();
                    scanner.nextLine();
                    int opcao = 0;
                    switch (switchControl) {
                        case 1:
                            do {
                                try {
                                    System.out.println("Selecione uma das opções a seguir: ");
                                    System.out.println("1 - Adicionar livro");
                                    System.out.println("2 - Editar livro");
                                    System.out.println("3 - Listar livros");
                                    System.out.println("4 - Deletar livro");
                                    opcao = scanner.nextInt();
                                    scanner.nextLine();
                                } catch (NullPointerException e) {
                                    System.err.println("Opção inválida");
                                }
                            } while (opcao < 0 && opcao > 4);

                            do {
                                try {
                                    switch (opcao) {
                                        case 1:
                                            Livro livro = new Livro();

                                            System.out.println("Título");
                                            livro.setTitulo(scanner.nextLine());
                                            System.out.println("Autor");
                                            livro.setAutor(scanner.nextLine());
                                            System.out.println("Editora");
                                            livro.setEditora(scanner.nextLine());

                                            do {
                                                System.out.println("Número de Páginas");
                                                try {
                                                    livro.setNumeroDePaginas(scanner.nextInt());
                                                } catch (InputMismatchException e) {
                                                    System.err.println("Número inválido");
                                                }
                                                scanner.nextLine();
                                            } while (livro.getNumeroDePaginas() == null);

                                            int variavel = 0;
                                            do {
                                                System.out.println("Formato: 1 - para Brochura, 2 - para CapaDura");
                                                try {
                                                    variavel = scanner.nextInt();
                                                    livro.setFormato(Formato.ofFormato(variavel));
                                                } catch (InputMismatchException e) {
                                                    System.err.println("Número inválido");
                                                } catch (NoSuchElementException ex) {
                                                    System.err.println("Número inválido");
                                                }
                                                scanner.nextLine();
                                            } while (variavel != 1 && variavel != 2);

                                            variavel = 0;
                                            do {
                                                System.out.println("Informe o Idioma: 1 - para PORTUGUÊS, 2 - para INGLÊS ou 3 - para ESPANHOL");
                                                try {
                                                    variavel = scanner.nextInt();
                                                    livro.setIdioma(Idioma.ofIdioma(variavel));

                                                } catch (InputMismatchException e) {
                                                    System.err.println("Número inválido");
                                                }
                                                scanner.nextLine();
                                            } while (variavel != 1 && variavel != 2 && variavel != 3);

                                            livro.setStatusLivro(StatusLivro.DISPONIVEL);
                                            livroService.adicionar(livro);
                                            break;

                                        case 2:
                                            System.out.println("Qual livro deve ser alterado?");
                                            livroService.listar();
                                            int id = scanner.nextInt();
                                            scanner.nextLine();

                                            Livro livroEdicao = new Livro();

                                            System.out.println("Título");
                                            livroEdicao.setTitulo(scanner.nextLine());
                                            System.out.println("Autor");
                                            livroEdicao.setAutor(scanner.nextLine());
                                            System.out.println("Editora");
                                            livroEdicao.setEditora(scanner.nextLine());
                                            do {
                                                System.out.println("Número de Páginas");
                                                ;
                                                try {
                                                    livroEdicao.setNumeroDePaginas(scanner.nextInt());
                                                } catch (InputMismatchException e) {
                                                    System.err.println("Número inválido");
                                                }
                                                scanner.nextLine();
                                            } while (livroEdicao.getNumeroDePaginas() == null);

                                            variavel = 0;
                                            do {
                                                System.out.println("Formato: 1 - para Brochura, 2 - para CapaDura");
                                                try {
                                                    variavel = scanner.nextInt();
                                                    livroEdicao.setFormato(Formato.ofFormato(variavel));
                                                } catch (InputMismatchException e) {
                                                    System.err.println("Número inválido");
                                                } catch (NoSuchElementException ex) {
                                                    System.err.println("Número inválido");
                                                }
                                                scanner.nextLine();
                                            } while (variavel != 1 && variavel != 2);

                                            variavel = 0;
                                            do {
                                                System.out.println("Informe o Idioma: 1 - para PORTUGUÊS, 2 - para INGLÊS ou 3 - para ESPANHOL");
                                                try {
                                                    variavel = scanner.nextInt();
                                                    livroEdicao.setIdioma(Idioma.ofIdioma(variavel));

                                                } catch (InputMismatchException e) {
                                                    System.err.println("Número inválido");
                                                }
                                                scanner.nextLine();
                                            } while (variavel != 1 && variavel != 2 && variavel != 3);

                                            livroService.editar(id, livroEdicao);

                                            break;
                                        case 3:
                                            livroService.listar();
                                            break;
                                        case 4:
                                            System.out.println("Informe o livro o qual você deseja excluir ");
                                            livroService.listar();
                                            boolean validou = false;
                                            while (!validou) {
                                                try {
                                                    id = scanner.nextInt();
                                                    livroService.remover(id);
                                                    validou = true;
                                                } catch (InputMismatchException e) {
                                                    System.err.println("Registro inválido");
                                                }
                                            }
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.err.println("Opção inválida");
                                            break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.err.println("Opção inválida");
                                }
                            } while (opcao < 0 && opcao > 4);

                            break;

                        case 2:

                            opcao = -1;
                            while (opcao != 0) {
                                System.out.println("Digite 1 para criar conta");
                                System.out.println("Digite 2 para listar contas");
                                System.out.println("Digite 3 para editar uma conta");
                                System.out.println("Digite 4 para excluir contas");
                                System.out.println("Digite 0 para sair");
                                opcao = scanner.nextInt();
                                scanner.nextLine();
                                switch (opcao) {
                                    case 1:
                                        ContaCliente conta = new ContaCliente();
                                        System.out.println("Digite o nome do Cliente");
                                        conta.setNome(scanner.nextLine());

                                        System.out.println("Digite o telefone)");
                                        conta.setTelefone(scanner.nextLine());

                                        System.out.println("Digite o email");
                                        conta.setEmail(scanner.nextLine());

                                        System.out.println("Status: 1 - para OK, 2 - para Bloqueado, 3 para Cancelado");
                                        int variavel = 0;
                                        do {
                                            try {
                                                variavel = scanner.nextInt();
                                                conta.setStatus(StatusCliente.ofStatus(variavel));
                                                scanner.nextLine();
                                            } catch (InputMismatchException e) {
                                                System.err.println("Número inválido");
                                            }
                                        } while (variavel == 0);

                                        System.out.println("Tipo: 1 - para Comum, 2 - para Premium");
                                        variavel = 0;
                                        do {
                                            try {
                                                variavel = scanner.nextInt();
                                                conta.setTipoCliente(TipoCliente.ofTipo(variavel));
                                                scanner.nextLine();
                                            } catch (InputMismatchException e) {
                                                System.err.println("Número inválido");
                                            }
                                        } while (variavel == 0);


                                        contaService.adicionarConta(conta);
                                        break;

                                    case 2:

                                        contaService.listarContas();
                                        break;

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
                                        System.out.println("Status: 1 - para OK, 2 - para Bloqueado, 3 para Cancelado");
                                        variavel = 0;
                                        do {
                                            try {
                                                variavel = scanner.nextInt();
                                                contaNova.setStatus(StatusCliente.ofStatus(variavel));
                                                scanner.nextLine();
                                            } catch (InputMismatchException e) {
                                                System.err.println("Número inválido");
                                            }
                                        } while (variavel == 0);

                                        System.out.println("Tipo: 1 - para Comum, 2 - para Premium");
                                        variavel = 0;
                                        do {
                                            try {
                                                variavel = scanner.nextInt();
                                                contaNova.setTipoCliente(TipoCliente.ofTipo(variavel));
                                                scanner.nextLine();
                                            } catch (InputMismatchException e) {
                                                System.err.println("Número inválido");
                                            }
                                        } while (variavel == 0);


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
                            break;

                        case 3:

                            opcao = -1;
                            while (opcao != 0) {
                                System.out.println("Digite 1 para criar funcionário.");
                                System.out.println("Digite 2 para listar os funcionários.");
                                System.out.println("Digite 3 para editar um funcionário.");
                                System.out.println("Digite 4 para excluir um funcionário.");
                                System.out.println("Digite 0 para sair.");
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
                                    case 0:
                                        break;
                                    default:
                                        System.err.println("Opção inválida!");
                                }
                            }
                            break;

                        case 4:

                            opcao = -1;
                            while (opcao != 0) {
                                System.out.println("Digite 1 para novo emprestimo.");
                                System.out.println("Digite 2 para listar emprestimos.");
                                System.out.println("Digite 3 para excluir emprestimo.");
                                System.out.println("Digite 0 para sair.");
                                opcao = scanner.nextInt();
                                scanner.nextLine();
                                switch (opcao) {
                                    case 1: {
                                        Emprestimo emprestimo = new Emprestimo();
                                        System.out.println("Digite o ID do livro.");
                                        livroService.listar();
                                        emprestimo.setIdLivroEmprestimo(scanner.nextInt());
                                        scanner.nextLine();
                                        System.out.println("Digite o ID do cliente");
                                        contaService.listarContas();
                                        emprestimo.setIdClienteEmprestimo(scanner.nextInt());
                                        scanner.nextLine();
                                        System.out.println("Digite o ID do funcionario.");
                                        funcionarioService.listarFuncionarios();
                                        emprestimo.setIdFuncionarioEmprestimo(scanner.nextInt());
                                        scanner.nextLine();

                                        emprestimoService.adicionarEmprestimoService(emprestimo);
                                        break;
                                    }
                                    case 2: {
                                        emprestimoService.listarEmprestimoService();
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Qual emprestimo deseja excluir?");
                                        emprestimoService.listarEmprestimoService();
                                        int id = scanner.nextInt();
                                        scanner.nextLine();
                                        emprestimoService.removerEmprestimoService(id);
                                        break;
                                    }
                                    case 0:
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                            }


                        case 0:
                            break;
                    }

                } catch (InputMismatchException e) {
                    System.err.println("Opção inválida");
                }
            } while (switchControl < 0 || switchControl > 4);
        } while (switchControl != 0);
    }
}
