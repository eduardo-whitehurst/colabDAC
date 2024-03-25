package br.com.colabdac.colabdac.dao;

import br.com.colabdac.colabdac.conexao.Factory;
import br.com.colabdac.colabdac.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    final private Connection connection;

    public UsuarioDao() throws ClassNotFoundException {
        this.connection = new Factory().getConnection();
    }

    public Boolean criarUsuario(Usuario usuario) {
        String sql = "insert into usuarios(email, senha) values (?,?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            System.out.println(e);
            return false;
        }

        return true;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(
                    "select * from usuarios"
            );
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                Usuario usuario = new Usuario(email, senha);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return usuarios;
    }

    public Boolean deletarUsuario(String email) {
        String sql = "delete from usuarios where email = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            System.out.println(e);
            return false;
        }

        return true;
    }

    public Boolean atualizarUsuario(Usuario usuario) {
        String sql = "update usuarios set senha = ? where email = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, usuario.getSenha());
            stmt.setString(2, usuario.getEmail());
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            System.out.println(e);
            return false;
        }

        return true;
    }

    public Usuario buscarUsuario(String email) {
        Usuario usuario = null;
        try{
            PreparedStatement stmt = this.connection.prepareStatement(
                    "select * from usuarios where email = ?"
            );
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String senha = rs.getString("senha");
                usuario = new Usuario(email, senha);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return usuario;
    }
}
