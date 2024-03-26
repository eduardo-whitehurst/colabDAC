package br.com.colabdac.colabdac.entities;

public class Venda {
    private Long id;
    private String data;
    private Long idCliente;

    // Construtor
    public Venda() {
        // Neste ponto, a data pode ser inicializada conforme necessário
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}

