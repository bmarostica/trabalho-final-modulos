package com.dbc.service;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Livro;
import com.dbc.repository.LivroRepository;

import java.util.List;

public class LivroService {
    private LivroRepository livroRepository;

    public LivroService() {
        livroRepository = new LivroRepository();
    }

    //criação de objeto
    public void adicionar(Livro livro){
        try{
            Livro adicionarLivro = livroRepository.adicionar(livro);
            System.out.println(adicionarLivro);
        } catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

    //atualização de objeto
    public void editar(Integer id, Livro livro){
        try{
            boolean conseguiuEditarLivro = livroRepository.editar(id, livro);
            System.out.println("Livro editado com sucesso? " + conseguiuEditarLivro + "id = " + id);
        }catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

    //leitura de objeto
    public void listar(){
        try{
            List<Livro> livros = livroRepository.listar();
            livros.forEach(System.out::println);
        }catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }

    //exclusão de objeto
    public void remover(Integer id){
        try{
            boolean conseguiuDeletarLivro = livroRepository.remover(id);
            System.out.println("Livro excluido com sucesso? " + conseguiuDeletarLivro + "id = " + id);
        }catch (BancoDeDadosException e){
            e.printStackTrace();
        }
    }
}
