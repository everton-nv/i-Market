package com.example.everton.i_market;

import android.content.Context;

import com.example.everton.i_market.ProdutoDAO;

import java.util.ArrayList;

public class ServicoProduto {
    private final ProdutoDAO produtoDAO;

    public ServicoProduto (Context context){
        produtoDAO = new ProdutoDAO(context);
    }

    public void cadastrarProduto (String nome, double preco, String categoria, int id_mercado){
        Produto produto = new Produto(nome, preco, categoria, id_mercado);

        produtoDAO.save(produto);
    }

    public void removerProduto (int id, String nome, double preco, String categoria, int id_mercado){
        Produto produto = new Produto(nome, preco, categoria, id_mercado);

        produtoDAO.delete(produto);
    }

    public void atulizarProduto (String nome, double preco, String categoria, int id_mercado){
        Produto produto = new Produto(nome, preco, categoria, id_mercado);

        produtoDAO.save(produto);
    }

}
