package br.com.colabdac.colabdac.dao;

import br.com.colabdac.colabdac.conexao.Factory;
import br.com.colabdac.colabdac.entities.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    private Connection connection;

    public ClienteDao() throws ClassNotFoundException {
        this.connection = new Factory().getConnection();
    }

    public void inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, cpf) VALUES (?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente byId(Long id) {
        String sql = "SELECT * FROM cliente WHERE id=?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            Cliente cliente = new Cliente();

            while(rs.next()) {
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
            }

            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> all() {
        String sql = "SELECT * FROM cliente";

        try {
            List<Cliente> clientes = new ArrayList<Cliente>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));

                clientes.add(cliente);
            }

            rs.close();
            stmt.close();

            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void altera(Cliente cliente) {
        String sql = "UPDATE cliente SET nome=?, cpf=? WHERE id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setLong(3, cliente.getId());
            stmt.execute();
            stmt.close();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Long id) {
        String sql = "DELETE FROM cliente WHERE id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






}
