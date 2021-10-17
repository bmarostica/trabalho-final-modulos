package com.dbc;

public class Main {
    public static void main(String[] args){
        Livro livro = new Livro();
        livro.adicionarLivroNaBase();
        livro.buscarLivro();
        livro.alterarLivro();
        livro.deletar();


    }
}
