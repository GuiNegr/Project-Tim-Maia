package Model;

import java.sql.Date;

public class Produto {
    private String id;
    private String nome_produto;
    private java.sql.Date validade_produto;
    private String tipo_produto;
    private String qtd_produto;


    public Produto(String id, String nome_produto, Date validade_produto, String tipo_produto, String qtd_produto) {
        this.id = id;
        this.nome_produto = nome_produto;
        this.validade_produto = validade_produto;
        this.tipo_produto = tipo_produto;
        this.qtd_produto = qtd_produto;
    }

    public Produto(String nome_produto, java.sql.Date validade_produto, String tipo_produto, String qtd_produto) {
        this.nome_produto = nome_produto;
        this.validade_produto = validade_produto;
        this.tipo_produto = tipo_produto;
        this.qtd_produto = qtd_produto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public java.sql.Date getValidade_produto() {
        return validade_produto;
    }

    public void setValidade_produto(java.sql.Date validade_produto) {
        this.validade_produto = validade_produto;
    }

    public String getTipo_produto() {
        return tipo_produto;
    }

    public void setTipo_produto(String tipo_produto) {
        this.tipo_produto = tipo_produto;
    }

    public String getQtd_produto() {
        return qtd_produto;
    }

    public void setQtd_produto(String qtd_produto) {
        this.qtd_produto = qtd_produto;
    }

    @Override
    public String toString() {
        return "Produto: " +
                "id: " + 1 + '\'' +
                "NOME DO PRODUTO: " + nome_produto + '\'' +
                "VALIDADE DO PRODUTO: " + validade_produto +
                "TIPO DO PRODUTO: " + tipo_produto + '\'' +
                "QTD DO PRODUTO: " + qtd_produto + '\'';
    }
}
