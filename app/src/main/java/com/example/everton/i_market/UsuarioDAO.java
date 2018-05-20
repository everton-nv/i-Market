package com.example.everton.i_market;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static com.example.everton.i_market.ImarketDataBaseContract.TEXT_TYPE;
import static com.example.everton.i_market.ImarketDataBaseContract.COMMA_SEP;
import static com.example.everton.i_market.ImarketDataBaseContract.PRIMARY_KEY;


public class UsuarioDAO {
    
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + ImarketDataBaseContract.UsuarioTable.TABLE_NAME + " (" +
                    ImarketDataBaseContract.UsuarioTable._ID + PRIMARY_KEY +
                    ImarketDataBaseContract.UsuarioTable.TABLE_COLUMN_USUARIO_EMAIL + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.UsuarioTable.TABLE_COLUMN_USUARIO_SENHA + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.UsuarioTable.TABLE_COLUMN_USUARIO_NICK  + TEXT_TYPE + " )";
    private final Database dataBase;
    private SQLiteDatabase dbUser;

    public UsuarioDAO(Context context){
        this.dataBase = new Database(context);
    }

    public static String createMyTable(){
        return SQL_CREATE_ENTRIES;
    }

    public static String dropMyTable() {
        return "DROP TABLE IF EXISTS " + ImarketDataBaseContract.UsuarioTable.TABLE_NAME;
    }

    public Boolean save(){
        return true;
    }

    public Boolean delete(){
        return true;
    }

    public ArrayList findAll(){
        ArrayList retorna = null;
        return retorna ;
    }

    private ArrayList toList(Cursor cursor){
        ArrayList retorno = new ArrayList();
        return retorno;
    }

}
