package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository implements Repositorio<Integer, Livro> {

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "Select seq_livro.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }
        return null;
    }

    @Override
    public Livro adicionar(Livro livro) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            livro.setIdLivro(proximoId);

            String sql = "INSERT INTO LIVRO\n" +
                    "(ID_LIVRO, TITULO, AUTOR, EDITORA, NR_PAGINAS, FORMATO, IDIOMA, STATUS_LIVRO)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, livro.getIdLivro());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getAutor());
            stmt.setString(4, livro.getEditora());
            stmt.setInt(5, livro.getNumeroDePaginas());
            stmt.setInt(6, livro.getFormato().getTipo());
            stmt.setInt(7, livro.getIdioma().getLingua());
            stmt.setInt(8, livro.getStatusLivro().getStatusLivro());

            int res = stmt.executeUpdate();
            System.out.println("Livro adicionado com sucesso!");
            return livro;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM LIVRO WHERE ID_LIVRO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            int res = stmt.executeUpdate();

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean editar(Integer id, Livro livro) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE LIVRO SET ");
            sql.append(" titulo = ?,");
            sql.append(" autor = ?,");
            sql.append(" editora = ?,");
            sql.append(" nr_paginas = ?,");
            sql.append(" formato = ?,");
            sql.append(" idioma = ? ");
            sql.append(" WHERE ID_LIVRO = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setInt(4, livro.getNumeroDePaginas());
            stmt.setInt(5, livro.getFormato().getTipo());
            stmt.setInt(6, livro.getIdioma().getLingua());
            stmt.setInt(7, id);

            int res = stmt.executeUpdate();
            System.out.println("Livro editado com sucesso!" + res);

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Livro> listar() throws BancoDeDadosException {
        List<Livro> livros = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM LIVRO";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Livro livro = new Livro();
                livro.setIdLivro(res.getInt("id_livro"));
                livro.setTitulo(res.getString("titulo"));
                livro.setAutor(res.getString("autor"));
                livro.setEditora(res.getString("editora"));
                livro.setNumeroDePaginas(res.getInt("nr_paginas"));
                livro.setFormato(Formato.ofFormato(res.getInt("formato")));
                livro.setIdioma(Idioma.ofIdioma(res.getInt("idioma")));
                livro.setStatusLivro(StatusLivro.ofStatus(res.getInt("status_livro")));
                livros.add(livro);
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return livros;
    }
}
