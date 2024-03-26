package br.com.colabdac.colabdac.controllers;

import br.com.colabdac.colabdac.dao.UsuarioDao;
import br.com.colabdac.colabdac.entities.Usuario;

public class UsuarioController {
    public boolean criarUsuario(String email, String senha, String confirmarSenha) {
        boolean isPasswordConfirmed = senha.equals(confirmarSenha);
        if (!isPasswordConfirmed) {
            return false;
        }
        Usuario usuario = new Usuario(email, senha);
        try {
            UsuarioDao dao = new UsuarioDao();
            dao.criarUsuario(usuario);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean atualizarUsuario(String email, String senha) {
        Usuario usuario = new Usuario(email, senha);
        try {
            UsuarioDao dao = new UsuarioDao();
            Usuario usuarioAtual = dao.buscarUsuario(email);
            dao.atualizarUsuario(usuarioAtual, senha);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
