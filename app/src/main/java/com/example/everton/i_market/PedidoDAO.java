package com.example.everton.i_market;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

import static com.example.everton.i_market.ImarketDataBaseContract.COMMA_SEP;
import static com.example.everton.i_market.ImarketDataBaseContract.PRIMARY_KEY_AUTO;
import static com.example.everton.i_market.ImarketDataBaseContract.TEXT_TYPE;


public class PedidoDAO {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + ImarketDataBaseContract.PedidoTable.TABLE_NAME + " (" +
                    ImarketDataBaseContract.PedidoTable._ID + PRIMARY_KEY_AUTO +
                    ImarketDataBaseContract.PedidoTable.TABLE_COLUMN_ID_MERCADO + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.PedidoTable.TABLE_COLUMN_ID_CLIENTE + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.PedidoTable.TABLE_COLUMN_IDS_PRODUTOS + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.PedidoTable.TABLE_COLUMN_DATA + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.PedidoTable.TABLE_COLUMN_HORA + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.PedidoTable.TABLE_COLUMN_VALOR + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.PedidoTable.TABLE_COLUMN_STATUS + TEXT_TYPE + " )";
    private SQLiteDatabase dbWriter;
    private SQLiteDatabase dbReader;

    public PedidoDAO(Context context){
        Database database = new Database(context);
    }

    public static String createMyTable(){
        return SQL_CREATE_ENTRIES;
    }

    public static String dropMyTable(){ return "DROP TABLE IF EXISTS " + ImarketDataBaseContract.PedidoTable.TABLE_NAME;}

    public Boolean save(){
        return true;
    }

    public Boolean delete(){
        return true;
    }

    public ArrayList findAll(){
        return null;
    }

    private ArrayList toList(Cursor cursor){
        return new ArrayList();
    }
}
