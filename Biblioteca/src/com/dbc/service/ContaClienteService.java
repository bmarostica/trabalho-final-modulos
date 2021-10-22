package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.ContaCliente;
import com.dbc.model.StatusCliente;
import com.dbc.repository.ContaClienteRepository;

import java.util.ArrayList;
import java.util.List;

public class ContaClienteService {
    private List<ContaCliente> listaClientes = new ArrayList<>();
    private ContaClienteRepository contaClienteRepository;

    public ContaClienteService() {
        contaClienteRepository = new ContaClienteRepository();
    }

    public boolean podeAlugar(StatusCliente status) {
        return status.equals(StatusCliente.OK);
    }

    public void cobrarMensalidade(double valor) {
    }

    public void adicionarConta(ContaCliente conta) {
        try {
            ContaCliente contaAdicionada = contaClienteRepository.adicionar(conta);
            System.out.println("conta adicinada com sucesso! " + contaAdicionada);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void removerConta(Integer id) {
        try {
            boolean conseguiuRemover = contaClienteRepository.remover(id);
            System.out.println("conta removida? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    public void editarConta(Integer id, ContaCliente conta) {
        try {
            boolean conseguiuEditar = contaClienteRepository.editar(id, conta);
            System.out.println("conta editada? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listarContas() {
        try {
            List<ContaCliente> listar = contaClienteRepository.listar();
            listar.forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }


}
