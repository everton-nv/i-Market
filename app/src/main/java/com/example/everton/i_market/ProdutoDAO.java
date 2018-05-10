package com.example.everton.i_market;

import android.database.Cursor;

import java.util.ArrayList;

import static com.example.everton.i_market.ImarketDataBaseContract.COMMA_SEP;
import static com.example.everton.i_market.ImarketDataBaseContract.PRIMARY_KEY_AUTO;
import static com.example.everton.i_market.ImarketDataBaseContract.TEXT_TYPE;


public class ProdutoDAO {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ImarketDataBaseContract.ProdutoTable.TABLE_NAME + " (" +
                    ImarketDataBaseContract.ProdutoTable._ID + PRIMARY_KEY_AUTO +
                    ImarketDataBaseContract.ProdutoTable.TABLE_COLUMN_PRODUTO_NOME + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.ProdutoTable.TABLE_COLUMN_PRODUTO_PRECO + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.ProdutoTable.TABLE_COLUMN_PRODUTO_CATEGORIA  + TEXT_TYPE + " )";

    public static String createMyTable(){
        return SQL_CREATE_ENTRIES;
    }

    public static String dropMyTable() {
        return "DROP TABLE IF EXISTS " + ImarketDataBaseContract.ProdutoTable.TABLE_NAME;
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
