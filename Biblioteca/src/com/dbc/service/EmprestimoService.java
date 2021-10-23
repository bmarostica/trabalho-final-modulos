package com.dbc.service;

import com.dbc.model.Emprestimo;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.EmprestimoRepository;

import java.util.List;

public class EmprestimoService {
    private EmprestimoRepository emprestimoRepository;

    public EmprestimoService() {
        emprestimoRepository = new EmprestimoRepository();
    }

    public void adicionarEmprestimoService(Emprestimo emprestimo) {
        try {
            Emprestimo emprestimoAdicionado = emprestimoRepository.adicionarEmprestimo(emprestimo);
            System.out.println("Emprestimo adicionado com sucesso!" + emprestimoAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void removerEmprestimoService (Integer id) {
        try{
            boolean conseguiuRemover = emprestimoRepository.removerEmprestimo(id);
            System.out.println("Emprestimo removido? " + conseguiuRemover + "| com id="+ id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listarEmprestimoService() {
        try {
            List<Emprestimo> listar = emprestimoRepository.listarEmprestimos();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
    public void livroIndisponivelService(Integer idLivro) {
        try {
            boolean trocouStatus = emprestimoRepository.livroIndisponivel(idLivro);
            System.out.println("Status do livro mudou para indisponivel? " + trocouStatus + "| com id=" + idLivro);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void livroDisponivelService(Integer idLivro) {
        try {
            boolean trocouStatus = emprestimoRepository.livroDisponivel(idLivro);
            System.out.println("Status do livro mudou disponivel? " + trocouStatus + "| com id=" + idLivro);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
