package com.dbc;

public class Main {
    public static void main(String[] args){
        Livro livro = new Livro(01, "Harry Potter 1", "J.k. Rowling","Rocco" ,214, Formato.BROCHURA, Idioma.PORTUGUES);
        Livro livro2 = new Livro(02, "Harry Potter 2", "J.k. Rowling","Rocco" ,231, Formato.BROCHURA, Idioma.PORTUGUES);
        Livro livro3 = new Livro(03, "Harry Potter 3", "J.k. Rowling","Rocco" ,328, Formato.BROCHURA, Idioma.PORTUGUES);
        Livro livro4 = new Livro(04, "Harry Potter 4", "J.k. Rowling","Rocco" ,484, Formato.BROCHURA, Idioma.PORTUGUES);
        Livro livro5 = new Livro(05, "Harry Potter 5", "J.k. Rowling","Rocco" ,536, Formato.BROCHURA, Idioma.PORTUGUES);
        Livro livro6 = new Livro(06, "Harry Potter 6", "J.k. Rowling","Rocco" ,457, Formato.BROCHURA, Idioma.PORTUGUES);
        Livro livro7 = new Livro(07, "Harry Potter 7", "J.k. Rowling","Rocco" ,568, Formato.BROCHURA, Idioma.PORTUGUES);

        livro.acidionarLivroNaBase(livro2);
        livro.acidionarLivroNaBase(livro3);
        livro.acidionarLivroNaBase(livro4);
        livro.acidionarLivroNaBase(livro5);
        livro.acidionarLivroNaBase(livro6);
        livro.acidionarLivroNaBase(livro7);
//        livro.buscarPorId(4);
//        livro.listarTodosLivrosCadastrados();
//        ContaClientePremium joao = new ContaClientePremium();
        Funcionario alex = new Funcionario();
        alex.setNomeFuncionario("Alex");
//        joao.setNome("João");

        livro.acidionarLivroNaBase(livro);
//
//        Emprestimo transacao1 = new Emprestimo(livro2, joao, alex);
//        transacao1.efetuarEmprestimo(transacao1);

        ContaClienteComum joana = new ContaClienteComum();
        joana.setNome("Joana Alves");
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.emprestimoClienteComum(livro2, alex, joana);





    }
}
