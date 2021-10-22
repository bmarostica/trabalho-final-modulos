package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoRepository implements Repositorio<Integer, Emprestimo>{
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "Select seq_emprestimo.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }
        return null;
    }

    @Override
    public Emprestimo adicionar(Emprestimo emprestimo) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            emprestimo.setIdEmprestimo(proximoId);

            String sql = "INSERT INTO EMPRESTIMO\n" +
                    "(ID_EMPRESTIMO, ID_LIVRO, ID_CLIENTE, ID_FUNCIONARIO, STATUS_LIVRO)\n" +
                    "VALUES(?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, emprestimo.getIdEmprestimo());
            stmt.setInt(2, emprestimo.getLivro().getIdLivro());
            stmt.setInt(3, emprestimo.getCliente().getIdCliente());
            stmt.setInt(4, emprestimo.getFuncionario().getIdFuncionario());
            stmt.setInt(8, emprestimo.getLivro().getStatusLivro().getStatusLivro());

            int res = stmt.executeUpdate();
            System.out.println("adicionarEmprestimo.res" + res);
            return emprestimo;
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

            String sql = "DELETE FROM EMPRESTIMO WHERE ID_EMPRESTIMO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            int res = stmt.executeUpdate();
            System.out.println("removerEmprestimoPorId.res=" + res);

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
    public boolean editar(Integer id, Emprestimo emprestimo) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            StringBuilder sql = new StringBuilder();
            PreparedStatement stmt = con.prepareStatement(sql.toString());

            int cont = 1;
            if (emprestimo != null) {
                if (emprestimo.getIdEmprestimo() != null) {
                    stmt.setInt(cont++, emprestimo.getIdEmprestimo());
                }
            }
            if (emprestimo.getLivro() != null) {
                stmt.setString(cont++, emprestimo.getLivro().getTitulo());
            }
            if (emprestimo.getCliente() != null) {
                stmt.setString(cont++, emprestimo.getCliente().getNome());
            }
            if (emprestimo.getFuncionario() != null) {
                stmt.setString(cont++, emprestimo.getFuncionario().getNomeFuncionario());
            }

            stmt.setInt(cont++, id);

            int res = stmt.executeUpdate();
            System.out.println("editarEmprestimo.res=" + res);

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
    public List<Emprestimo> listar() throws BancoDeDadosException {
        List<Emprestimo> emprestimos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM EMPRESTIMO";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setIdEmprestimo(res.getInt("ID_EMPRESTIMO"));
                emprestimo.setLivro(res.getString("ID_LIVRO"));
                emprestimo.setCliente(res.getString("ID_CLIENTE"));
                emprestimo.setFuncionario(res.getString("ID_CLIENTE"));
                emprestimo.getLivro().setStatusLivro(StatusLivro.ofStatus(res.getInt("STATUS_LIVRO")));
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
        return emprestimos;
    }
}
