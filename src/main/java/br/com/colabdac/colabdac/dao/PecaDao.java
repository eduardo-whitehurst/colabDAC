package br.com.colabdac.colabdac.dao;

import br.com.colabdac.colabdac.conexao.Factory;
import br.com.colabdac.colabdac.entities.Peca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PecaDao {
    private Connection connection;

    public PecaDao() throws ClassNotFoundException {
        this.connection = new Factory().getConnection();
    }

    public void inserirPeca(Peca peca) {
        String sql = "INSERT INTO peca (nome, valor) VALUES (?, ?)";

        try  {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, peca.getNome());
            stmt.setString(2, peca.getValor());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir peça.", e);
        }
    }

    public Peca buscarPorId(Long id) {
        String sql = "SELECT * FROM peca WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Peca peca = new Peca();
                peca.setId(rs.getLong("id"));
                peca.setNome(rs.getString("nome"));
                peca.setValor(rs.getString("valor"));
                return peca;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar peça por ID.", e);
        }
        return null;
    }

    public List<Peca> listarTodos() {
        String sql = "SELECT * FROM peca";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            List<Peca> pecas = new ArrayList<>();

            while (rs.next()) {
                Peca peca = new Peca();
                peca.setId(rs.getLong("id"));
                peca.setNome(rs.getString("nome"));
                peca.setValor(rs.getString("valor"));
                pecas.add(peca);
            }

            return pecas;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todas as peças.", e);
        }
    }

    public void alterar(Peca peca) {
        String sql = "UPDATE peca SET nome=?, valor=? WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, peca.getNome());
            stmt.setString(2, peca.getValor());
            stmt.setLong(3, peca.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar peça.", e);
        }
    }

    public void remover(Long id) {
        String sql = "DELETE FROM peca WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover peça.", e);
        }
    }
}
