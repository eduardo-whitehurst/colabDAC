package br.com.colabdac.colabdac.dao;

import br.com.colabdac.colabdac.conexao.Factory;
import br.com.colabdac.colabdac.entities.ServicoVenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoVendaDao {
    private Connection connection;

    public ServicoVendaDao() throws ClassNotFoundException {
        this.connection = new Factory().getConnection();
    }

    public void inserirServicoVenda(ServicoVenda servicoVenda) {
        String sql = "INSERT INTO servico_venda (idvenda, idservico, idveiculo) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, servicoVenda.getIdVenda());
            stmt.setLong(2, servicoVenda.getIdServico());
            stmt.setLong(3, servicoVenda.getIdVeiculo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir serviço na venda.", e);
        }
    }

    public List<ServicoVenda> buscarPorIdVenda(Long idVenda) {
        String sql = "SELECT * FROM servico_venda WHERE idvenda=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, idVenda);
            ResultSet rs = stmt.executeQuery();

            List<ServicoVenda> servicosVenda = new ArrayList<>();

            while (rs.next()) {
                ServicoVenda servicoVenda = new ServicoVenda();
                servicoVenda.setId(rs.getLong("id"));
                servicoVenda.setIdVenda(rs.getLong("idvenda"));
                servicoVenda.setIdServico(rs.getLong("idservico"));
                servicoVenda.setIdVeiculo(rs.getLong("idveiculo"));
                servicosVenda.add(servicoVenda);
            }

            return servicosVenda;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar serviços da venda por ID de venda.", e);
        }
    }

    // Outros métodos podem incluir buscar por ID, listar todos, alterar e remover serviços da venda
}
