package br.com.colabdac.colabdac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.colabdac.colabdac.conexao.Factory;
import br.com.colabdac.colabdac.entities.Veiculo;

public class VeiculoDao {
    private Connection connection;

    public VeiculoDao() throws ClassNotFoundException {
        this.connection = new Factory().getConnection();
    }

    public void inserirVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (modelo, marca, ano) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getMarca());
            stmt.setInt(3, veiculo.getAno());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir veículo.", e);
        }
    }

    public Veiculo buscarPorId(Long id) {
        String sql = "SELECT * FROM veiculo WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getLong("id"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setAno(rs.getInt("ano"));
                return veiculo;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar veículo por ID.", e);
        }
        return null;
    }

    public List<Veiculo> listarTodos() {
        String sql = "SELECT * FROM veiculo";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            List<Veiculo> veiculos = new ArrayList<>();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getLong("id"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setAno(rs.getInt("ano"));
                veiculos.add(veiculo);
            }

            return veiculos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os veículos.", e);
        }
    }

    public void alterar(Veiculo veiculo) {
        String sql = "UPDATE veiculo SET modelo=?, marca=?, ano=? WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getMarca());
            stmt.setInt(3, veiculo.getAno());
            stmt.setLong(4, veiculo.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar veículo.", e);
        }
    }

    public void remover(Long id) {
        String sql = "DELETE FROM veiculo WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover veículo.", e);
        }
    }
}

