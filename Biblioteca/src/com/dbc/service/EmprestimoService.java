package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Emprestimo;
import com.dbc.model.StatusLivro;
import com.dbc.repository.EmprestimoRepository;

import java.util.List;

public class EmprestimoService {
    private EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public void efetuarEmprestimo(Emprestimo emprestimo) {
        try {
            Emprestimo efetuarEmprestimo = emprestimoRepository.adicionar(emprestimo);
            System.out.println(efetuarEmprestimo);
            efetuarEmprestimo.getCliente().setPontosFidelidade(efetuarEmprestimo.getCliente().getPontosFidelidade() + 1);
            efetuarEmprestimo.getLivro().setStatusLivro(StatusLivro.INDISPONIVEL);

            System.out.println("Funcionário: " + efetuarEmprestimo.getFuncionario() + "alugou o livro "
                    + efetuarEmprestimo.getLivro() + "para o cliente: " + efetuarEmprestimo.getCliente());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removerEmprestimo(Emprestimo emprestimo) {
        try{
            boolean conseguiuRemoverEmprestimo = emprestimoRepository.remover(emprestimo.getIdEmprestimo());
            System.out.println("Livro excluido com sucesso? " + conseguiuRemoverEmprestimo + "identificação: = " + emprestimo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void listarEmprestimos() {
        try{
            List<Emprestimo> emprestimos = emprestimoRepository.listar();
            emprestimos.forEach(System.out::println);
        }catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

}
