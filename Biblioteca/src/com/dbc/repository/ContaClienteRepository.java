package com.dbc.repository;

import com.dbc.exceptions.BancoDeDadosException;
import com.dbc.model.ContaCliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaClienteRepository implements Repositorio<Integer, ContaCliente> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT seq_cliente.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public ContaCliente adicionar(ContaCliente conta) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            Integer proximoId = this.getProximoId(con);
            conta.setIdCliente(proximoId);

            String sql = "INSERT INTO CONTA\n" +
                    "(ID_CLIENTE, NOME, TELEFONE, EMAIL)\n" +
                    "VALUES(?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, conta.getIdCliente());
            stmt.setString(2, conta.getNome());
            stmt.setString(3, conta.getTelefone());
            stmt.setString(4, conta.getEmail());

            int res = stmt.executeUpdate();
            System.out.println("adicionarConta.res=" + res);
            return conta;
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

            String sql = "DELETE FROM CONTA WHERE id_cliente = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);


            int res = stmt.executeUpdate();
            System.out.println("removerContaPorIdCliente.res=" + res);

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
    public boolean editar(Integer id, ContaCliente conta) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE CONTA SET ");
            sql.append(" email = ?,");
            sql.append(" nome = ?,");
            sql.append(" telefone = ? ");
            sql.append(" WHERE id_cliente = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, conta.getEmail());
            stmt.setString(2, conta.getNome());
            stmt.setString(3, conta.getTelefone());
            stmt.setInt(4, id);


            int res = stmt.executeUpdate();
            System.out.println("editarConta.res=" + res);

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
    public List<ContaCliente> listar() throws BancoDeDadosException {
        List<ContaCliente> contas = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM CONTA";


            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                ContaCliente conta = new ContaCliente();
                conta.setIdCliente(res.getInt("id_cliente"));
                conta.setNome(res.getString("nome"));
                conta.setTelefone(res.getString("telefone"));
                conta.setEmail(res.getString("email"));
                contas.add(conta);
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
        return contas;
    }
}