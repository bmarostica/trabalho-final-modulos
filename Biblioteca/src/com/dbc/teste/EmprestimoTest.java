package com.dbc.teste;

import com.dbc.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmprestimoTest {

    @Test
    public void deveTestarODiaDeDevolucaoDoLivroDoClienteComumComSucesso(){
        //Arrange
        Livro livro = new Livro();


        ContaClienteComum aa = new ContaClienteComum(5, "joao", "5555", "555", StatusCliente.OK);

        aa.adicionarContaComum(aa);

        System.out.println(aa.getNome());
        System.out.println(aa);
        System.out.println("lista" + aa.listarContasComum());

        Emprestimo emprestimo = new Emprestimo();

        //Act
        LocalDate devolucao = emprestimo.devolucaoLivro(LocalDate.now(), aa);

        //Assert
        assertEquals(devolucao, LocalDate.of(2021, 10, 24));
    }
}
