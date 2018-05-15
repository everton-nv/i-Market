package com.example.everton.i_market;

import android.content.Context;

import com.example.everton.i_market.MercadoDAO;

public class ServicoMercado {
    private final MercadoDAO mercadoDAO;

    public ServicoMercado (Context context){
        mercadoDAO = new MercadoDAO(context);
    }

    public void cadastrarMercado (int id, String nome, String endereco, long cnpj, int num_telefone){
        Mercado mercado = new Mercado(id, nome, endereco, cnpj, num_telefone);

        mercadoDAO.save(mercado);
    }

    public void removerMercado (int id, String nome, String endereco, long cnpj, int num_telefone){
        Mercado mercado = new Mercado(id, nome, endereco, cnpj, num_telefone);

        mercadoDAO.delete(mercado);
    }

    public void atulizarMercado (int id, String nome, String endereco, long cnpj, int num_telefone){
        Mercado mercado = new Mercado(id, nome, endereco, cnpj, num_telefone);

        mercadoDAO.save(mercado);
    }
}