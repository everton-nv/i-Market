package com.example.everton.i_market;

import android.database.Cursor;

import java.util.ArrayList;

import static com.example.everton.i_market.ImarketDataBaseContract.COMMA_SEP;
import static com.example.everton.i_market.ImarketDataBaseContract.PRIMARY_KEY_AUTO;
import static com.example.everton.i_market.ImarketDataBaseContract.TEXT_TYPE;


public class MercadoDAO {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ImarketDataBaseContract.MercadoTable.TABLE_NAME + " (" +
                    ImarketDataBaseContract.MercadoTable._ID + PRIMARY_KEY_AUTO +
                    ImarketDataBaseContract.MercadoTable.TABLE_COLUMN_MERCADO_NOME + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.MercadoTable.TABLE_COLUMN_MERCADO_ENDERECO + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.MercadoTable.TABLE_COLUMN_MERCADO_CNPJ + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.MercadoTable.TABLE_COLUMN_MERCADO_TELEFONE + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.MercadoTable.TABLE_COLUMN_MERCADO_RECEITA + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.MercadoTable.TABLE_COLUMN_MERCADO_NOTA + TEXT_TYPE + " )";

    public static String createMyTable(){
        return SQL_CREATE_ENTRIES;
    }

    public static String dropMyTable() {
        return "DROP TABLE IF EXISTS " + ImarketDataBaseContract.MercadoTable.TABLE_NAME;
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
