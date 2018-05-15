package com.example.everton.i_market;

public class Mercado {
    private int id;
    private String nome;
    private String endereco;
    private long cnpj;
    private int num_telefone;
    private double receita = 0.0;
    private double nota = 0.0;

    public Mercado(){

    }

    public Mercado(int id, String nome, String endereco, long cnpj, int num_telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.num_telefone = num_telefone;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public int getNum_telefone() {
        return num_telefone;
    }

    public void setNum_telefone(int num_telefone) {
        this.num_telefone = num_telefone;
    }

    public double getReceita() {
        return receita;
    }

    public void setReceita(double receita) {
        this.receita = receita;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
