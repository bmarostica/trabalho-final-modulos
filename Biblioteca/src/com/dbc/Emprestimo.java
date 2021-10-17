package com.dbc;

import java.time.LocalDate;

public class Emprestimo {
    private static final Integer EMPRESTIMO_CLIENTE_COMUM = 7;
    private static final Integer EMPRESTIMO_CLIENTE_PREMIUM = 30;

    private Livro livro;
    private ContaClienteComum clienteComum;
    private ContaClientePremium clientePremium;

    public Emprestimo() {
    }

    //deve retornar o dia de devolução
    public LocalDate devolucaoLivro(LocalDate emprestimo, ContaCliente cliente) {
        LocalDate devolucao = LocalDate.MIN;

        if (cliente.equals(clienteComum)){
            devolucao = emprestimo.plusDays(EMPRESTIMO_CLIENTE_COMUM);
        } else if (cliente.equals(clientePremium)){
            devolucao = emprestimo.plusDays(EMPRESTIMO_CLIENTE_PREMIUM);
        }
        System.out.println(devolucao);
        return devolucao;
    }

    //deve retornar se o livro esta atrasado ou não
    public Boolean estaAtrasado(LocalDate diaDevolucao, LocalDate emprestimo, ContaClienteComum cliente) {
        if (diaDevolucao.isAfter(devolucaoLivro(emprestimo, cliente))) {
            System.out.println("Devolução atrasada!");
            return true;
        } else {
            System.out.println("Entrega em dia.");
            return false;
        }
    }

}
