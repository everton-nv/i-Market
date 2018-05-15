package com.example.everton.i_market;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String categoria;
    private int id_mercado;

    public Produto() {
        //implementaÃ§Ã£o de construtor padrÃ£o. O objeto pode ser inicializado na classe de negÃ³cios??
    }

    //Precisa mesmo de um construtor dedicado???
    public Produto(String nome, double preco, String categoria, int id_mercado) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.id_mercado = id_mercado;       //CAMPO NÃƒO MODELADO NO BANCO!!
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId_mercado() {
        return id_mercado;
    }

    public void setId_mercado(int id_mercado) {
        this.id_mercado = id_mercado;
    }
}
