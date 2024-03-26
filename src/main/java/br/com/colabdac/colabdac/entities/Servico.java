package br.com.colabdac.colabdac.entities;

import java.sql.SQLException;

public class Servico {
    private Long id;
    private String nome;
    private String descricao;
    private String valor;
    private Long id_funcionario; // Chave estrangeira referenciando o funcionário associado a este serviço

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getIdFuncionario() {
        return id_funcionario;
    }

    public void setIdFuncionario(Long id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
}

