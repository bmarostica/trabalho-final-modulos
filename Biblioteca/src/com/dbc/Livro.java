package com.dbc;

import java.util.*;

public class Livro {
    Scanner input = new Scanner(System.in);

    private static final String MENSAGEM_DE_ERRO = "Opção inválida!";

    private Integer id;
    private String titulo;
    private String autor;
    private String editora;
    private Integer numeroDePaginas;
    private Formato formato;
    private Idioma idioma;
    private List<Livro> livros = new ArrayList<>();

    //COLOQUEI ABAIXO OS MÉTODOS QUE USEI    ///////////////////////////////////////////////////
    private List<Livro> cadastrados = new ArrayList<>();

    public Livro(Integer id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public void cadastrar(Livro livro) {
        this.cadastrados.add(livro);
    }

    public void imprimir() {
        System.out.println("Id: " + this.getId());
        System.out.println("Titulo" + this.getTitulo());
    }

    public void imprimirBuscado(Livro buscado) {
        System.out.println(buscado.getTitulo());
    }

    public Livro buscarPorId(Integer id) {
                Livro buscado = this.cadastrados.stream()
                .filter(livro -> livro.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
                imprimirBuscado(buscado);
                return buscado;
    }

    public void listarTodosLivrosCadastrados() {
        for(Livro livro : this.cadastrados) {
            livro.imprimir();
        }
    }



    //////////////////////////////////////////////////////////////////

    public Livro() {

    }

    public Livro(Integer id, String titulo, String autor, String editora, Integer numeroDePaginas, Formato formato, Idioma idioma) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.numeroDePaginas = numeroDePaginas;
        this.formato = formato;
        this.idioma = idioma;
    }

    public Livro cadastroDeLivro() {
        Integer condicao = 0;

        System.out.println("Para cadastrar um novo livro preencha os dados a seguir:");

        setId(livros.size() + 1);
        System.out.println("Título");
        setTitulo(input.nextLine());
        System.out.println("Autor");
        setAutor(input.nextLine());
        System.out.println("Editora");
        setEditora(input.nextLine());
        System.out.println("Número de Páginas");
        setNumeroDePaginas(input.nextInt());
        input.nextLine();

        do {
            System.out.println("Informe o formato: 1 - para Brochura, 2 - para CapaDura");
            condicao = input.nextInt();
            input.nextLine();

            if (condicao >= 1 && condicao <= 2) {
                setFormato(Formato.values()[condicao - 1]);
            } else {
                System.err.println(MENSAGEM_DE_ERRO);
            }
        } while (condicao != 1 && condicao != 2);

        do {
            System.out.println("Informe o Idioma: 1 - para PORTUGUÊS, 2 - para INGLÊS ou 3 - para ESPANHOL");
            condicao = input.nextInt();
            input.nextLine();
            if (condicao >= 1 && condicao <= 3) {
                setIdioma(Idioma.values()[condicao - 1]);
            } else {
                System.err.println(MENSAGEM_DE_ERRO);
            }
        } while (condicao != 1 && condicao != 2 && condicao != 3);

        return new Livro(getId(), getTitulo(), getAutor(), getEditora(), getNumeroDePaginas(), getFormato(), getIdioma());
    }

    public void adicionarLivroNaBase() {
        Integer condicao = 0;

        do {
            livros.add(cadastroDeLivro());

            do {
                System.out.println("Digite 1 para adicionar novo livro ou 0 para SAIR");
                condicao = input.nextInt();
                input.nextLine();
                if (condicao != 0 && condicao != 1) {
                    System.err.println("Opção inválida");
                }
            } while (condicao != 0 && condicao != 1);

        } while (condicao != 0);

        System.out.println(livros);
    }

    public List<Livro> buscarLivro() {
        Integer condicao = 0;
        List<Livro> lista = new ArrayList<>();

        do {
            System.out.println("Informe o título: ");
            String nome = input.nextLine();
            lista.addAll(livros.stream()
                    .filter(livro -> {
                        return livro.getTitulo().toLowerCase().contains(nome.toLowerCase());
                    })
                    .toList());

            do {
                System.out.println("Deseja inserir outro título na busca?");
                System.out.println("Digite 1 para SIM ou 0 para NÃO");
                condicao = input.nextInt();
                input.nextLine();
                if (condicao != 0 && condicao != 1) {
                    System.out.println("Opção inválida");
                }

            } while (condicao != 0 && condicao != 1);


        } while (condicao != 0);

        return lista;
    }

    public void alterarLivro() {
        int condicao = 0;
        int opcao = 0;

        System.out.println("Para realizar a alteração de dados de um livro realize a busca primeiramente:");
        buscarLivro();

        System.out.println("Informe o ID do livro para alteração:");
        Integer idLivro = input.nextInt();

        do {

            do {
                System.out.println("Informe o número do item que você deseja alterar:");
                System.out.println("1 - Título");
                System.out.println("2 - Autor");
                System.out.println("3 - Editora");
                System.out.println("4 - Número de Páginas");
                System.out.println("5 - Formato");
                System.out.println("6 - Idioma");
                System.out.println("0 - Sair");
                opcao = input.nextInt();
                input.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("Informe o novo título");
                        livros.get(idLivro - 1).setTitulo(input.nextLine());
                        break;
                    case 2:
                        System.out.println("Informe o novo autor");
                        livros.get(idLivro - 1).setAutor(input.nextLine());
                        break;
                    case 3:
                        System.out.println("Informe o novo editora");
                        livros.get(idLivro - 1).setEditora(input.nextLine());
                        break;
                    case 4:
                        System.out.println("Informe o novo Número de páginas");
                        livros.get(idLivro - 1).setNumeroDePaginas(input.nextInt());
                        input.nextLine();
                        break;
                    case 5:
                        do {
                            System.out.println("Informe o formato: 1 - para Brochura, 2 - para CapaDura");
                            condicao = input.nextInt();
                            input.nextLine();

                            if (condicao >= 1 && condicao <= 2) {
                                livros.get(idLivro - 1).setFormato(Formato.values()[condicao - 1]);
                            } else {
                                System.err.println(MENSAGEM_DE_ERRO);
                            }
                        } while (condicao != 1 && condicao != 2);
                        break;
                    case 6:
                        do {
                            System.out.println("Informe o Idioma: 1 - para PORTUGUÊS, 2 - para INGLÊS ou 3 - para ESPANHOL");
                            condicao = input.nextInt();
                            input.nextLine();
                            if (condicao >= 1 && condicao <= 3) {
                                livros.get(idLivro - 1).setIdioma(Idioma.values()[condicao - 1]);
                            } else {
                                System.err.println(MENSAGEM_DE_ERRO);
                            }
                        } while (condicao != 1 && condicao != 2 && condicao != 3);
                        break;
                    case 0:
                        break;
                    default:
                        System.err.println(MENSAGEM_DE_ERRO);
                }

            } while (opcao < 0 || opcao > 6);

            System.out.println("Deseja realizar outra alteração? Digite 1 para sim e 0 para não: ");
            condicao = input.nextInt();
            input.nextLine();

        } while (condicao != 0);

        System.out.println(livros);
    }

    public void deletar() {
        System.out.println("Para realizar a exclusão de um livro da base realize a busca primeiramente:");
        buscarLivro();

        System.out.println("Informe o ID para exclusão:");
        Integer idLivro = input.nextInt();

        livros.remove(livros.get(idLivro - 1));

        System.out.println(livros);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", numeroDePaginas=" + numeroDePaginas +
                ", formato=" + formato +
                ", idioma=" + idioma +
                '}';
    }
}
