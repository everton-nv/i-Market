package com.example.everton.i_market;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



//Classe responsável por criar o banco de dados

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db";

    // TABELA USUÁRIO
    public static final String TABELA_USUARIO = "Usuario";
    public static final String ID = "_id";
    public static final String USUARIO_EMAIL = "email";
    public static final String USUARIO_SENHA = "senha";
    public static final String USUARIO_NICK = "nick";


    //TABELA MERCADO
    public static final String TABELA_MERCADO = "Mercado";
    public static final String MERCADO_NOME = "m_nome";
    public static final String MERCADO_ENDERECO = "m_endereco";
    public static final String CNPJ = "cnpj";
    public static final String MERCADO_TELEFONE = "m_telefone";
    public static final String RECEITA = "receita";
    public static final String NOTA = "nota";

    //TABELA CLIENTE
    public static final String TABELA_CLIENTE = "Cliente";
    public static final String CLIENTE_NOME = "c_nome";
    public static final String CLIENTE_ENDERECO = "c_endereco";
    public static final String CPF = "cpf";
    public static final String CLIENTE_TELEFONE = "c_telefone";
    public static final String CLIENTE_CARTAO = "c_cartao";

    //TABELA PRODUTO
    public static final String TABELA_PRODUTO = "Produto";
    public static final String PRODUTO_NOME = "p_nome";
    public static final String PRECO = "preco";
    public static final String CATEGORIA = "categoria";

    //TABELA PEDIDO
    public static final String TABELA_PEDIDO = "Cliente";
    public static final String ID_CLIENTE = "id_cliente";
    public static final String ID_MERCADO = "id_mercado";
    public static final String IDS_PRODUTOS = "ids_produtos";
    public static final String DATA_HORA = "datahora";
    public static final String VALOR = "valor";
    public static final String STATUS = "status";



    private Context context;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABELA_USUARIO + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USUARIO_EMAIL + " TEXT NOT NULL, " +
                USUARIO_SENHA + " TEXT NOT NULL, " +
                USUARIO_NICK + " TEXT NOT NULL);");

        db.execSQL("CREATE TABLE " + TABELA_MERCADO + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MERCADO_NOME + " TEXT NOT NULL, " +
                MERCADO_ENDERECO + " TEXT NOT NULL, " +
                CNPJ + " TEXT NOT NULL, " +
                MERCADO_TELEFONE + " TEXT NOT NULL, " +
                RECEITA + " TEXT NOT NULL, " +
                NOTA + " TEXT NO NULL);");

        db.execSQL("CREATE TABLE " + TABELA_CLIENTE + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CLIENTE_NOME + " TEXT NOT NULL, " +
                CLIENTE_ENDERECO + " TEXT NOT NULL, " +
                CPF + " TEXT NOT NULL, " +
                CLIENTE_TELEFONE + " TEXT NOT NULL, " +
                CLIENTE_CARTAO + " TEXT NO NULL);");

        db.execSQL("CREATE TABLE " + TABELA_PRODUTO + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PRODUTO_NOME + " TEXT NOT NULL, " +
                PRECO + " TEXT NOT NULL, " +
                CATEGORIA + " TEXT NO NULL);");

        db.execSQL("CREATE TABLE " + TABELA_PEDIDO + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ID_MERCADO + " TEXT NOT NULL, " +
                ID_CLIENTE + " TEXT NOT NULL, " +
                IDS_PRODUTOS + " TEXT NOT NULL, " +
                DATA_HORA + " TEXT NOT NULL, " +
                VALOR + " TEXT NOT NULL, " +
                STATUS + " TEXT NO NULL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query1 = "DROP TABLE IF EXISTS " + TABELA_USUARIO;
        db.execSQL(query1);

        String query2 = "DROP TABLE IF EXISTS " + TABELA_MERCADO;
        db.execSQL(query2);

        String query3 = "DROP TABLE IF EXISTS " + TABELA_CLIENTE;
        db.execSQL(query3);

        String query4 = "DROP TABLE IF EXISTS " + TABELA_PRODUTO;
        db.execSQL(query4);

        String query5 = "DROP TABLE IF EXISTS " + TABELA_PEDIDO;
        db.execSQL(query5);

        this.onCreate(db);
    }
}