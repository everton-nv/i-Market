package com.example.everton.i_market;

class Cliente {
  private int id;
  private String nome;
  private String endereco;
  private long cpf;
  private int num_telefone;
  private int num_cartao;

  public Cliente(){}

  public Cliente(int id, String nome, String endereco, long cpf, int num_telefone,  int num_cartao){
    this.id = id;
    this.nome = nome;
    this.endereco = endereco;
    this.cpf = cpf;
    this.num_telefone = num_telefone;
    this.num_cartao = num_cartao;
  }

  public int getId(){return id;}

  public void setId(int id){this.id = id;}
  
  public String getNome() {return nome;}

  public void setNome(String nome) {this.nome = nome;}

  public String getEndereco() {return endereco;}

  public void setEndereco(String endereco) {this.endereco = endereco;}

  public long getCpf() {return cpf;}

  public void setCpf(long cpf) {this.cpf = cpf;}

  public int getNum_telefone() {return num_telefone;}

  public void setNum_telefone(int num_telefone) {this.num_telefone = num_telefone;}

  public int getNum_cartao() {return num_cartao;}

  public void setNum_cartao(int num_cartao) {this.num_cartao = num_cartao;}

}