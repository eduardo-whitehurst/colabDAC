package br.com.colabdac.colabdac.entities;

public class Usuario {
    final private String email;
    final private String senha;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
