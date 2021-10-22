package com.dbc.model;

public class Livro {
    private Integer idLivro;
    private String titulo;
    private String autor;
    private String editora;
    private Integer numeroDePaginas;
    private Formato formato;
    private Idioma idioma;
    private StatusLivro statusLivro; //definir status disponivel como padrão

    public Livro() {

    }

    public Livro(Integer idLivro, String titulo, String autor, String editora, Integer numeroDePaginas, Formato formato, Idioma idioma, StatusLivro statusLivro) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.numeroDePaginas = numeroDePaginas;
        this.formato = formato;
        this.idioma = idioma;
        this.statusLivro = statusLivro;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
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

    public StatusLivro getStatusLivro() {
        return statusLivro;
    }

    public void setStatusLivro(StatusLivro statusLivro) {
        this.statusLivro = statusLivro;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", numeroDePaginas=" + numeroDePaginas +
                ", formato=" + formato +
                ", idioma=" + idioma +
                ", statusLivro=" + statusLivro +
                '}';
    }
}
