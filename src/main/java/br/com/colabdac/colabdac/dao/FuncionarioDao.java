package br.com.colabdac.colabdac.dao;

import br.com.colabdac.colabdac.conexao.Factory;
import br.com.colabdac.colabdac.entities.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    private Connection connection;

    public FuncionarioDao() throws ClassNotFoundException {
        this.connection = new Factory().getConnection();
    }

    public void inserirFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, funcao, cpf) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getFuncao());
            stmt.setString(3, funcionario.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir funcionário.", e);
        }
    }

    public Funcionario buscarPorId(Long id) {
        String sql = "SELECT * FROM funcionario WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setCpf(rs.getString("cpf"));
                return funcionario;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar funcionário por ID.", e);
        }
        return null;
    }

    public List<Funcionario> listarTodos() {
        String sql = "SELECT * FROM funcionario";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            List<Funcionario> funcionarios = new ArrayList<>();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionarios.add(funcionario);
            }

            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os funcionários.", e);
        }
    }

    public void alterar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome=?, funcao=?, cpf=? WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getFuncao());
            stmt.setString(3, funcionario.getCpf());
            stmt.setLong(4, funcionario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar funcionário.", e);
        }
    }

    public void remover(Long id) {
        String sql = "DELETE FROM funcionario WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover funcionário.", e);
        }
    }
}
