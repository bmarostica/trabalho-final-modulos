//package com.dbc;
//
//import com.dbc.model.Formato;
//import com.dbc.model.Idioma;
//import com.dbc.model.Livro;
//import com.dbc.service.LivroService;
//
//import java.util.*;
//
//public class LivroMain {
//    public static void main(String[] args) {
//
//        Scanner input = new Scanner(System.in);
//        int opcao = -1;
//
//        do {
//            try {
//                System.out.println("Selecione uma das opções a seguir: ");
//                System.out.println("1 - Adicionar livro");
//                System.out.println("2 - Editar livro");
//                System.out.println("3 - Listar livros");
//                System.out.println("4 - Deletar livro");
//                System.out.println("0 - Sair");
//                opcao = input.nextInt();
//                input.nextLine();
//            } catch (NullPointerException e) {
//                e.getMessage();
//            }
//        } while (opcao < 0 && opcao > 4);
//
//
//        switch (opcao){
//            case 1:
//                Livro livro = new Livro();
//
//                System.out.println("Título");
//                livro.setTitulo(input.nextLine());
//                System.out.println("Autor");
//                livro.setAutor(input.nextLine());
//                System.out.println("Editora");
//                livro.setEditora(input.nextLine());
//                System.out.println("Número de Páginas");
//                livro.setNumeroDePaginas(input.nextInt());
//                input.nextLine();
//
//                do {
//                    System.out.println("Formato: 1 - para Brochura, 2 - para CapaDura");
//                    condicao = input.nextInt();
//                    input.nextLine();
//
//                    if (condicao >= 1 && condicao <= 2) {
//                        livro.setFormato(Formato.values()[condicao - 1]);
//                    } else {
//                        System.err.println(MENSAGEM_DE_ERRO);
//                    }
//                } while (condicao != 1 && condicao != 2);
//
//                do {
//                    System.out.println("Informe o Idioma: 1 - para PORTUGUÊS, 2 - para INGLÊS ou 3 - para ESPANHOL");
//                    condicao = input.nextInt();
//                    input.nextLine();
//                    if (condicao >= 1 && condicao <= 3) {
//                        livro.setIdioma(Idioma.values()[condicao - 1]);
//                    } else {
//                        System.err.println(MENSAGEM_DE_ERRO);
//                    }
//
//                LivroService.adicionarLivro(livro);
//                break;
//            case 2:
//                break;
//            case 3:
//                LivroService.listar();
//                break;
//            case 4:
//                break;
//            case 0:
//                break;
//        }
//
//
//
//    }
//
//
//    public void adicionarLivroNaBaseIteracao() {
//        Integer condicao = 0;
//
//        do {
//            livros.add(cadastroDeLivro());
//
//            do {
//                System.out.println("Digite 1 para adicionar novo livro ou 0 para SAIR");
//                condicao = input.nextInt();
//                input.nextLine();
//                if (condicao != 0 && condicao != 1) {
//                    System.err.println("Opção inválida");
//                }
//            } while (condicao != 0 && condicao != 1);
//
//        } while (condicao != 0);
//
//        System.out.println(livros);
//    }
//
//    public void acidionarLivroNaBase(LivroMain livro) {
//        this.livros.add(livro);
//    }
//
//    public List<LivroMain> buscarLivro() {
//        Integer condicao = 0;
//        List<LivroMain> lista = new ArrayList<>();
//
//        do {
//            System.out.println("Informe o título: ");
//            String nome = input.nextLine();
//            lista.addAll(livros.stream()
//                    .filter(livro -> {
//                        return livro.getTitulo().toLowerCase().contains(nome.toLowerCase());
//                    })
//                    .toList());
//
//            do {
//                System.out.println("Deseja inserir outro título na busca?");
//                System.out.println("Digite 1 para SIM ou 0 para NÃO");
//                condicao = input.nextInt();
//                input.nextLine();
//                if (condicao != 0 && condicao != 1) {
//                    System.out.println("Opção inválida");
//                }
//
//            } while (condicao != 0 && condicao != 1);
//
//
//        } while (condicao != 0);
//
//        return lista;
//    }
//
//    public LivroMain buscarPorId(Integer id) {
//        LivroMain buscado = this.livros.stream()
//                .filter(livro -> livro.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
//        imprimirBuscado(buscado);
//        return buscado;
//    }
//
//    public void alterarLivro() {
//        int condicao = 0;
//        int opcao = 0;
//
//        System.out.println("Para realizar a alteração de dados de um livro realize a busca primeiramente:");
//        buscarLivro();
//
//        System.out.println("Informe o ID do livro para alteração:");
//        Integer idLivro = input.nextInt();
//
//        do {
//
//            do {
//                System.out.println("Informe o número do item que você deseja alterar:");
//                System.out.println("1 - Título");
//                System.out.println("2 - Autor");
//                System.out.println("3 - Editora");
//                System.out.println("4 - Número de Páginas");
//                System.out.println("5 - Formato");
//                System.out.println("6 - Idioma");
//                System.out.println("0 - Sair");
//                opcao = input.nextInt();
//                input.nextLine();
//
//                switch (opcao) {
//                    case 1:
//                        System.out.println("Informe o novo título");
//                        livros.get(idLivro - 1).setTitulo(input.nextLine());
//                        break;
//                    case 2:
//                        System.out.println("Informe o novo autor");
//                        livros.get(idLivro - 1).setAutor(input.nextLine());
//                        break;
//                    case 3:
//                        System.out.println("Informe o novo editora");
//                        livros.get(idLivro - 1).setEditora(input.nextLine());
//                        break;
//                    case 4:
//                        System.out.println("Informe o novo Número de páginas");
//                        livros.get(idLivro - 1).setNumeroDePaginas(input.nextInt());
//                        input.nextLine();
//                        break;
//                    case 5:
//                        do {
//                            System.out.println("Informe o formato: 1 - para Brochura, 2 - para CapaDura");
//                            condicao = input.nextInt();
//                            input.nextLine();
//
//                            if (condicao >= 1 && condicao <= 2) {
//                                livros.get(idLivro - 1).setFormato(Formato.values()[condicao - 1]);
//                            } else {
//                                System.err.println(MENSAGEM_DE_ERRO);
//                            }
//                        } while (condicao != 1 && condicao != 2);
//                        break;
//                    case 6:
//                        do {
//                            System.out.println("Informe o Idioma: 1 - para PORTUGUÊS, 2 - para INGLÊS ou 3 - para ESPANHOL");
//                            condicao = input.nextInt();
//                            input.nextLine();
//                            if (condicao >= 1 && condicao <= 3) {
//                                livros.get(idLivro - 1).setIdioma(Idioma.values()[condicao - 1]);
//                            } else {
//                                System.err.println(MENSAGEM_DE_ERRO);
//                            }
//                        } while (condicao != 1 && condicao != 2 && condicao != 3);
//                        break;
//                    case 0:
//                        break;
//                    default:
//                        System.err.println(MENSAGEM_DE_ERRO);
//                }
//
//            } while (opcao < 0 || opcao > 6);
//
//            System.out.println("Deseja realizar outra alteração? Digite 1 para sim e 0 para não: ");
//            condicao = input.nextInt();
//            input.nextLine();
//
//        } while (condicao != 0);
//
//        System.out.println(livros);
//    }
//
//    public void deletarDaBase() {
//        System.out.println("Informe o ID para exclusão:");
//        Integer idLivro = input.nextInt();
//
//        livros.remove(livros.get(idLivro - 1));
//
//        System.out.println(livros);
//    }
//
//
//}
