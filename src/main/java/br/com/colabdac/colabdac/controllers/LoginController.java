package br.com.colabdac.colabdac.controllers;

import br.com.colabdac.colabdac.dao.UsuarioDao;

public class LoginController {
        public boolean login(String email, String senha) throws ClassNotFoundException {
            UsuarioDao usuarioDao = new UsuarioDao();
            return usuarioDao.verificarUsuario(email, senha);
        }
}
