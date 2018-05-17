package com.example.everton.i_market;

import android.provider.BaseColumns;

public final class ImarketDataBaseContract {

    public static final String TEXT_TYPE = " TEXT NOT NULL";
    public static final String TEXT_TYPE_NULL = " TEXT";
    public static final String COMMA_SEP = ",";
    public static final String PRIMARY_KEY = " INTEGER PRIMARY KEY,";
    public static final String PRIMARY_KEY_AUTO = " INTEGER PRIMARY KEY AUTOINCREMENT,";

    private ImarketDataBaseContract(){} //classe não deve ser instanciada
    
    public static class UsuarioTable implements BaseColumns{
        
        public static final String TABLE_NAME = "Usuario";
        public static final String TABLE_COLUMN_USUARIO_EMAIL = "Email";
        public static final String TABLE_COLUMN_USUARIO_SENHA = "Senha";
        public static final String TABLE_COLUMN_USUARIO_NICK = "Nick";
    }
    
    public static class MercadoTable implements BaseColumns{
        public static final String TABLE_NAME = "Mercado";
        public static final String TABLE_COLUMN_MERCADO_NOME = "Nome";
        public static final String TABLE_COLUMN_MERCADO_ENDERECO = "Endereco";
        public static final String TABLE_COLUMN_MERCADO_CNPJ = "CNPJ";
        public static final String TABLE_COLUMN_MERCADO_TELEFONE = "Telefone";
        public static final String TABLE_COLUMN_MERCADO_RECEITA = "Receita";
        public static final String TABLE_COLUMN_MERCADO_NOTA = "Nota";
    }
    
    public static class ClienteTable implements BaseColumns{
        
        public static final String TABLE_NAME = "Cliente";
        public static final String TABLE_COLUMN_CLIENTE_NOME = "Nome";
        public static final String TABLE_COLUMN_CLIENTE_ENDERECO = "Endereco";
        public static final String TABLE_COLUMN_CLIENTE_CPF = "CPF";
        public static final String TABLE_COLUMN_CLIENTE_TELEFONE = "Telefone";
        public static final String TABLE_COLUMN_CLIENTE_CARTAO = "Cartao";
    }
    
    public static class ProdutoTable implements BaseColumns{
        
        public static final String TABLE_NAME = "Produto";
        public static final String TABLE_COLUMN_PRODUTO_NOME = "Nome";
        public static final String TABLE_COLUMN_PRODUTO_PRECO = "Preco";
        public static final String TABLE_COLUMN_PRODUTO_CATEGORIA = "Categoria";
    }
    
    public static class PedidoTable implements BaseColumns{
        
        public static final String TABLE_NAME = "Pedido";
        public static final String TABLE_COLUMN_ID_CLIENTE = "ID_cliente";
        public static final String TABLE_COLUMN_ID_MERCADO = "ID_mercado";
        public static final String TABLE_COLUMN_IDS_PRODUTOS = "IDs_produtos";
        public static final String TABLE_COLUMN_DATA = "Data";
        public static final String TABLE_COLUMN_HORA = "Hora";
        public static final String TABLE_COLUMN_VALOR = "Valor";
        public static final String TABLE_COLUMN_STATUS = "Status";
    }
    


}
