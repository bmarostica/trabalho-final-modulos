package com.dbc;

public class Main {
    public static void main(String[] args){
        Livro livro = new Livro(01, "Harry Potter 1");
        Livro livro2 = new Livro(02, "Harry Potter 2");
        Livro livro3 = new Livro(03, "Harry Potter 3");
        Livro livro4 = new Livro(04, "Harry Potter 4");
        Livro livro5 = new Livro(05, "Harry Potter 5");
        Livro livro6 = new Livro(06, "Harry Potter 6");
        Livro livro7 = new Livro(07, "Harry Potter 7");


//        livro.cadastrar(livro2);
//        livro.cadastrar(livro3);
//        livro.cadastrar(livro4);
//        livro.cadastrar(livro5);
//        livro.cadastrar(livro6);
//        livro.cadastrar(livro7);
//        livro.buscarPorId(4);
//        livro.listarTodosLivrosCadastrados();
        ContaClientePremium joao = new ContaClientePremium();
        Funcionario alex = new Funcionario();
        alex.setNomeFuncionario("Alex");
        joao.setNome("João");

        livro.cadastrar(livro);

        Emprestimo transacao1 = new Emprestimo(livro2, joao, alex);
        transacao1.efetuarEmprestimo(transacao1);




    }
}
