package br.com.colabdac.colabdac.dao;

import br.com.colabdac.colabdac.conexao.Factory;

import java.sql.Connection;

public class ClienteDao {
    private Connection connection;

    public ClienteDao() throws ClassNotFoundException {
        this.connection = new Factory().getConnection();
    }




}
