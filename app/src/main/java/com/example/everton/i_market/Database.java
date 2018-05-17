package com.example.everton.i_market;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



//Classe responsável por criar o banco de dados

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "IMarketdb";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = ClienteDAO.createMyTable();
        db.execSQL(createTable);
        createTable = MercadoDAO.createMyTable();
        db.execSQL(createTable);
        createTable = PedidoDAO.createMyTable();
        db.execSQL(createTable);
        createTable = ProdutoDAO.createMyTable();
        db.execSQL(createTable);
        createTable = UsuarioDAO.createMyTable();
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(ClienteDAO.dropMyTable());
        db.execSQL(MercadoDAO.dropMyTable());
        db.execSQL(ProdutoDAO.dropMyTable());
        db.execSQL(PedidoDAO.dropMyTable());
        db.execSQL(UsuarioDAO.dropMyTable());

        this.onCreate(db);
    }
}