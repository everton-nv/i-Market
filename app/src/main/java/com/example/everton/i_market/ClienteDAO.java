package com.example.everton.i_market;

import android.database.Cursor;

import java.util.ArrayList;

import static com.example.everton.i_market.ImarketDataBaseContract.COMMA_SEP;
import static com.example.everton.i_market.ImarketDataBaseContract.PRIMARY_KEY_AUTO;
import static com.example.everton.i_market.ImarketDataBaseContract.TEXT_TYPE;


public class ClienteDAO {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + ImarketDataBaseContract.ClienteTable.TABLE_NAME + " (" +
                    ImarketDataBaseContract.ClienteTable._ID + PRIMARY_KEY_AUTO +
                    ImarketDataBaseContract.ClienteTable.TABLE_COLUMN_CLIENTE_NOME + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.ClienteTable.TABLE_COLUMN_CLIENTE_ENDERECO + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.ClienteTable.TABLE_COLUMN_CLIENTE_CPF + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.ClienteTable.TABLE_COLUMN_CLIENTE_TELEFONE + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.ClienteTable.TABLE_COLUMN_CLIENTE_CARTAO + TEXT_TYPE + " )";

    public static String createMyTable(){
        return SQL_CREATE_ENTRIES;
    }

    public static String dropMyTable() {
        return "DROP TABLE IF EXISTS " + ImarketDataBaseContract.ClienteTable.TABLE_NAME;
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
