package br.com.colabdac.colabdac.dao;

import br.com.colabdac.colabdac.conexao.Factory;
import br.com.colabdac.colabdac.entities.ItemVenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemVendaDao {
    private Connection connection;

    public ItemVendaDao() throws ClassNotFoundException {
        this.connection = new Factory().getConnection();
    }

    public void inserirItemVenda(ItemVenda itemVenda) {
        String sql = "INSERT INTO item_venda (idvenda, idpeca, quantidade) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, itemVenda.getIdVenda());
            stmt.setLong(2, itemVenda.getIdPeca());
            stmt.setInt(3, itemVenda.getQuantidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir item de venda.", e);
        }
    }

    public List<ItemVenda> buscarPorIdVenda(Long idVenda) {
        String sql = "SELECT * FROM item_venda WHERE idvenda=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, idVenda);
            ResultSet rs = stmt.executeQuery();

            List<ItemVenda> itensVenda = new ArrayList<>();

            while (rs.next()) {
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setId(rs.getLong("id"));
                itemVenda.setIdVenda(rs.getLong("idvenda"));
                itemVenda.setIdPeca(rs.getLong("idpeca"));
                itemVenda.setQuantidade(rs.getInt("quantidade"));
                itensVenda.add(itemVenda);
            }

            return itensVenda;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar itens de venda por ID de venda.", e);
        }
    }

    public void removerItemVenda(Long id) {
        String sql = "DELETE FROM item_venda WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover item de venda.", e);
        }
    }
}

