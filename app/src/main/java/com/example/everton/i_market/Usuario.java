package com.example.everton.i_market;

class Usuario {
  private int id;
  private String email;
  private String senha;//podemos mudar para int se a senha for apenas numerica
  private String nick;

  public Usuario(){}

  public Usuario(int id, String email, String senha, String nick){
    this.id = id;
    this.email = email;
    this.senha = senha;
    this.nick = nick;
  }
  
  private int getId(){return id;}

  public void setId(int id){this.id = id;}

  private String getEmail(){return email;}

  public void setEmail(String email){this.email = email;}

  private String getSenha(){return senha;}

  public void setSenha(String senha){this.senha = senha;}

  private String getNick(){return nick;}

  public void setNick(String nick){this.nick = nick;}
}