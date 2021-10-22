package com.dbc.service;

import com.dbc.model.Funcionario;
import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.repository.FuncionarioRepository;

import java.util.List;

public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService() {
        funcionarioRepository = new FuncionarioRepository();
    }
    public void adicionarFuncionario(Funcionario funcionario) {
        try {
            Funcionario funcionarioAdicionado = funcionarioRepository.adicionar(funcionario);
            System.out.println("Funcionário adicionado com sucesso! " + funcionarioAdicionado);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void removerFuncionario(Integer id) {
        try {
            boolean conseguiuRemover = funcionarioRepository.remover(id);
            System.out.println("Funcionário removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void editarFuncionario(Integer id, Funcionario funcionario) {
        try {
            boolean conseguiuEditar = funcionarioRepository.editar(id, funcionario);
            System.out.println("Funcionário editado? " + conseguiuEditar + "| com id= " + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void listarFuncionarios() {
        try {
            List<Funcionario> listar = funcionarioRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }
}
