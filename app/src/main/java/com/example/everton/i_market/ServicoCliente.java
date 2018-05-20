package com.example.everton.i_market;

import android.content.Context;

public class ServicoCliente {
  private final ClienteDAO clienteDAO;

  public ServicoCliente (Context context){
    clienteDAO = new ClienteDAO(context);
    }

  public void cadastrarCliente (int id, String nome, String endereco, long cpf, int num_telefone,  int num_cartao){
    Cliente cliente = new Cliente(id, nome, endereco, cpf, num_telefone, num_cartao);
    clienteDAO.save(cliente);
  }

  public void removerCliente (int id, String nome, String endereco, long cpf, int num_telefone,  int num_cartao){
    Cliente cliente = new Cliente(id, nome, endereco, cpf, num_telefone, num_cartao);
    clienteDAO.delete(cliente);

  }

  public void atulizarCliente (int id, String nome, String endereco, long cnpj, int num_telefone, int num_cartao){
    Cliente cliente = new Cliente(id, nome, endereco, cnpj, num_telefone, num_cartao);
    clienteDAO.save(cliente);
  }

}