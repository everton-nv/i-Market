package com.example.everton.i_market;

import android.content.Context;


public class ServicoUsuario {
  private final UsuarioDAO usuarioDAO;


  public ServicoUsuario (Context context){

    usuarioDAO = new UsuarioDAO(context);
  }

  public void cadastrarUsuario (int id, String email, String senha, String nick){
    Usuario usuario = new Usuario(id, email, senha, nick);
    //usuarioDAO.save(usuario);
  }

  public void removerUsuario (int id, String email, String senha, String nick){
    Usuario usuario = new Usuario(id, email, senha, nick);
    //usuarioDAO.delete(usuario);
  }

  public void atulizarUsuario (int id, String email, String senha, String nick){
    Usuario usuario = new Usuario(id, email, senha, nick);
    //usuarioDAO.save(usuario);
  }
}