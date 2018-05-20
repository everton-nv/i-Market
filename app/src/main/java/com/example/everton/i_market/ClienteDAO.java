package com.example.everton.i_market;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
    private final Database dataBase;
    private SQLiteDatabase dbUser;

    public ClienteDAO(Context context){
        this.dataBase = new Database(context);
    }

    public static String createMyTable(){
        return SQL_CREATE_ENTRIES;
    }

    public static String dropMyTable() {
        return "DROP TABLE IF EXISTS " + ImarketDataBaseContract.ClienteTable.TABLE_NAME;
    }

    public Boolean save(Cliente cliente){
        int id = cliente.getId();
        dbUser = dataBase.getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put("Cliente", cliente.getNome());
            values.put("Endereco", cliente.getEndereco());
            values.put("CPF", cliente.getCpf());
            values.put("Telefone", cliente.getNum_telefone());
            values.put("Cartao", cliente.getNum_cartao());
            if (id!=0){                                         //se o mercado já tem id então update
                String _id = String.valueOf(id);
                String[] whereArgs = new String[]{_id};
                return dbUser.update(ImarketDataBaseContract.ClienteTable.TABLE_NAME, values,
                        "_id=?", whereArgs)>0;
            }else{                                              //caso contrário inserir no banco;
                Log.w("Banco", "Sucesso");
                return dbUser.insert(ImarketDataBaseContract.ClienteTable.TABLE_NAME,"",values)>0;
            }
        }finally {
            dbUser.close();
        }
    }

    public Boolean delete(Cliente cliente){
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
