package br.com.colabdac.colabdac.dao;

import br.com.colabdac.colabdac.conexao.Factory;
import br.com.colabdac.colabdac.entities.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDao {
    private Connection connection;

    public VendaDao() throws ClassNotFoundException {
        this.connection = new Factory().getConnection();
    }

    public void inserirVenda(Venda venda) {
        String sql = "INSERT INTO venda (data, idcliente) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, venda.getData()); // Alterado para setString
            stmt.setLong(2, venda.getIdCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir venda.", e);
        }
    }

    public Venda buscarPorId(Long id) {
        String sql = "SELECT * FROM venda WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getLong("id"));
                venda.setData(rs.getString("data")); // Alterado para getString
                venda.setIdCliente(rs.getLong("idcliente"));
                return venda;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar venda por ID.", e);
        }
        return null;
    }

    public List<Venda> listarTodas() {
        String sql = "SELECT * FROM venda";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            List<Venda> vendas = new ArrayList<>();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getLong("id"));
                venda.setData(rs.getString("data")); // Alterado para getString
                venda.setIdCliente(rs.getLong("idcliente"));
                vendas.add(venda);
            }

            return vendas;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todas as vendas.", e);
        }
    }

    public void alterar(Venda venda) {
        String sql = "UPDATE venda SET data=?, idcliente=? WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, venda.getData()); // Alterado para setString
            stmt.setLong(2, venda.getIdCliente());
            stmt.setLong(3, venda.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar venda.", e);
        }
    }

    public void remover(Long id) {
        String sql = "DELETE FROM venda WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover venda.", e);
        }
    }
}

