package br.com.colabdac.colabdac.dao;

import br.com.colabdac.colabdac.conexao.Factory;
import br.com.colabdac.colabdac.entities.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoDao {
    private Connection connection;

    public ServicoDao() throws ClassNotFoundException {
        this.connection = new Factory().getConnection();
    }

    public void inserirServico(Servico servico) {
        String sql = "INSERT INTO servico (nome, descricao, valor, idfuncionario) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, servico.getNome());
            stmt.setString(2, servico.getDescricao());
            stmt.setDouble(3, servico.getValor());
            stmt.setLong(4, servico.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir serviço.", e);
        }
    }

    public Servico buscarPorId(Long id) {
        String sql = "SELECT * FROM servico WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Servico servico = new Servico();
                servico.setId(rs.getLong("id"));
                servico.setNome(rs.getString("nome"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setValor(rs.getDouble("valor"));
                servico.setIdFuncionario(rs.getLong("idfuncionario"));
                return servico;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar serviço por ID.", e);
        }
        return null;
    }

    public List<Servico> listarTodos() {
        String sql = "SELECT * FROM servico";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            List<Servico> servicos = new ArrayList<>();

            while (rs.next()) {
                Servico servico = new Servico();
                servico.setId(rs.getLong("id"));
                servico.setNome(rs.getString("nome"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setValor(rs.getDouble("valor"));
                servico.setIdFuncionario(rs.getLong("idfuncionario"));
                servicos.add(servico);
            }

            return servicos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os serviços.", e);
        }
    }

    public void alterar(Servico servico) {
        String sql = "UPDATE servico SET nome=?, descricao=?, valor=?, idfuncionario=? WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, servico.getNome());
            stmt.setString(2, servico.getDescricao());
            stmt.setDouble(3, servico.getValor());
            stmt.setLong(4, servico.getIdFuncionario());
            stmt.setLong(5, servico.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar serviço.", e);
        }
    }

    public void remover(Long id) {
        String sql = "DELETE FROM servico WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover serviço.", e);
        }
    }
}
