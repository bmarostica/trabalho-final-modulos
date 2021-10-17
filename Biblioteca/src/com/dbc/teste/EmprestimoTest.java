package com.dbc.teste;

import com.dbc.*;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class EmprestimoTest {

    @Test
    public void deveTestarODiaDeDevolucaoDoLivroDoClienteComumComSucesso(){
        //Arrange
        Livro livro = new Livro();
        ContaCliente contas = new ContaCliente();
        ContaClienteComum joao = new ContaClienteComum(5, "jaaaaaa", "5555", "555", StatusCliente.OK);

        joao.adicionarContaComum(joao);

        System.out.println(joao.getNome());
        System.out.println(joao);
        System.out.println("lista" + joao.listarContasComum());

        Emprestimo emprestimo = new Emprestimo();

        //Act
        LocalDate devolucao = emprestimo.devolucaoLivro(LocalDate.now(), joao);

        //Assert
        assertEquals(devolucao, LocalDate.of(2021, 10, 24));
    }
}
