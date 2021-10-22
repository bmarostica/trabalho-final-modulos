package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.Emprestimo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoRepository {
    public Integer getProximoId(Connection connection) throws SQLException{
        String sql = "SELECT seq_emprestimo.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }

    public Emprestimo adicionarEmprestimo(Emprestimo emprestimo) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            emprestimo.setIdEmprestimo(proximoId);

            String sql = "INSERT INTO EMPRESTIMO\n" +
                    "(ID_EMPRESTIMO, ID_LIVRO, ID_CLIENTE, ID_FUNCIONARIO)\n" +
                    "VALUES(?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, emprestimo.getIdEmprestimo());
            stmt.setInt(2, emprestimo.getIdLivroEmprestimo());
            stmt.setInt(3, emprestimo.getIdClienteEmprestimo());
            stmt.setInt(4, emprestimo.getIdFuncionarioEmprestimo());

            int res = stmt.executeUpdate();
            System.out.println("adicionarEmprestimo.res=" + res);
            return emprestimo;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public List<Emprestimo> listarEmprestimos() throws BancoDeDadosException {
        List<Emprestimo> emprestimos = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM EMPRESTIMO";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setIdEmprestimo(res.getInt("id_emprestimo"));
                emprestimo.setIdLivroEmprestimo(res.getInt("id_livro"));
                emprestimo.setIdClienteEmprestimo(res.getInt("id_cliente"));
                emprestimo.setIdFuncionarioEmprestimo(res.getInt("id_funcionario"));
                emprestimos.add(emprestimo);
            }
        }  catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emprestimos;
    }

    public boolean removerEmprestimo(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM EMPRESTIMO WHERE ID_EMPRESTIMO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            int res = stmt.executeUpdate();
            System.out.println("removerEmprestimo.res="+ res);

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
