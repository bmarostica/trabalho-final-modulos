package com.dbc;

import com.dbc.model.Formato;
import com.dbc.model.Idioma;
import com.dbc.model.Livro;
import com.dbc.model.StatusLivro;
import com.dbc.service.LivroService;

import java.util.*;

public class LivroMain {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LivroService livroService = new LivroService();
        int opcao = -1;

        do {
            try {
                System.out.println("Selecione uma das opções a seguir: ");
                System.out.println("1 - Adicionar livro");
                System.out.println("2 - Editar livro");
                System.out.println("3 - Listar livros");
                System.out.println("4 - Deletar livro");
                opcao = input.nextInt();
                input.nextLine();
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
                        livro.setTitulo(input.nextLine());
                        System.out.println("Autor");
                        livro.setAutor(input.nextLine());
                        System.out.println("Editora");
                        livro.setEditora(input.nextLine());
                        System.out.println("Número de Páginas");
                        livro.setNumeroDePaginas(input.nextInt());
                        input.nextLine();
                        System.out.println("Formato: 1 - para Brochura, 2 - para CapaDura");
                        int variavel = 0;
                        do {
                            try {
                                variavel = input.nextInt();
                                livro.setFormato(Formato.ofFormato(variavel));
                                input.nextLine();
                            } catch (InputMismatchException e) {
                                System.err.println("Número inválido");
                            }
                        } while (variavel == 0);

                        System.out.println("Informe o Idioma: 1 - para PORTUGUÊS, 2 - para INGLÊS ou 3 - para ESPANHOL");
                        variavel = 0;
                        do {
                            try {
                                variavel = input.nextInt();
                                livro.setIdioma(Idioma.ofIdioma(variavel));
                                input.nextLine();
                            } catch (InputMismatchException e) {
                                System.err.println("Número inválido");
                            }
                        } while (variavel == 0);

                        livro.setStatusLivro(StatusLivro.DISPONIVEL);
                        livroService.adicionar(livro);
                        break;

                    case 2:
                        System.out.println("Qual livro deve ser alterado?");
                        livroService.listar();
                        int id = input.nextInt();
                        input.nextLine();

                        Livro livroEdicao = new Livro();

                        System.out.println("Título");
                        livroEdicao.setTitulo(input.nextLine());
                        System.out.println("Autor");
                        livroEdicao.setAutor(input.nextLine());
                        System.out.println("Editora");
                        livroEdicao.setEditora(input.nextLine());
                        System.out.println("Número de Páginas");
                        livroEdicao.setNumeroDePaginas(input.nextInt());
                        input.nextLine();
                        System.out.println("Formato: 1 - para Brochura, 2 - para CapaDura");
                        variavel = 0;
                        do {
                            try {
                                variavel = input.nextInt();
                                livroEdicao.setFormato(Formato.ofFormato(variavel));
                                input.nextLine();
                            } catch (InputMismatchException e) {
                                System.err.println("Número inválido");
                            }
                        } while (variavel == 0);

                        System.out.println("Informe o Idioma: 1 - para PORTUGUÊS, 2 - para INGLÊS ou 3 - para ESPANHOL");
                        variavel = 0;
                        do {
                            try {
                                variavel = input.nextInt();
                                livroEdicao.setIdioma(Idioma.ofIdioma(variavel));
                                input.nextLine();
                            } catch (InputMismatchException e) {
                                System.err.println("Número inválido");
                            }
                        } while (variavel == 0);

                        livroEdicao.setStatusLivro(StatusLivro.DISPONIVEL);
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
                                id = input.nextInt();
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
    }
}