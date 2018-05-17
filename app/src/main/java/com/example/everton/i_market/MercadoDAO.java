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


public class MercadoDAO {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + ImarketDataBaseContract.MercadoTable.TABLE_NAME + " (" +
                    ImarketDataBaseContract.MercadoTable._ID + PRIMARY_KEY_AUTO +
                    ImarketDataBaseContract.MercadoTable.TABLE_COLUMN_MERCADO_NOME + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.MercadoTable.TABLE_COLUMN_MERCADO_ENDERECO + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.MercadoTable.TABLE_COLUMN_MERCADO_CNPJ + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.MercadoTable.TABLE_COLUMN_MERCADO_TELEFONE + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.MercadoTable.TABLE_COLUMN_MERCADO_RECEITA + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.MercadoTable.TABLE_COLUMN_MERCADO_NOTA + TEXT_TYPE + " )";
    private final Database dataBase;
    private SQLiteDatabase dbUser;
    
    public MercadoDAO(Context context){
        this.dataBase = new Database(context);
    }

    public static String createMyTable(){
        return SQL_CREATE_ENTRIES;
    }

    public static String dropMyTable() {
        return "DROP TABLE IF EXISTS " + ImarketDataBaseContract.MercadoTable.TABLE_NAME;
    }

    public Boolean save(Mercado mercado){
    int id = mercado.getId();
    dbUser = dataBase.getWritableDatabase();
        try{
        ContentValues values = new ContentValues();
        values.put("Mercado", mercado.getNome());
        values.put("Endereco", mercado.getEndereco());
        values.put("CNPJ", mercado.getCnpj());
        values.put("Telefone", mercado.getNum_telefone());
        values.put("Receita", mercado.getReceita());
        values.put("Nota", mercado.getNota());
        if (id!=0){                                         //se o mercado já tem id então update
            String _id = String.valueOf(id);
            String[] whereArgs = new String[]{_id};
            return dbUser.update(ImarketDataBaseContract.MercadoTable.TABLE_NAME, values,
                    "_id=?", whereArgs)>0;
        }else{                                              //caso contrário inserir no banco;
            Log.w("Banco", "Sucesso");
            return dbUser.insert(ImarketDataBaseContract.MercadoTable.TABLE_NAME,"",values)>0;
        }
    }finally {
        dbUser.close(); 
        }
    }

    public Boolean delete(Mercado mercado){
        dbUser = dataBase.getWritableDatabase();
        try{
            return dbUser.delete(ImarketDataBaseContract.MercadoTable.TABLE_NAME,
                    "_id=?", new String[]{String.valueOf(mercado.getId())})>0;
        }finally {
            dbUser.close();
        }
    }

    public ArrayList findAll(){
        dbUser = dataBase.getReadableDatabase();
        try{
            Cursor cursor = dbUser.query(ImarketDataBaseContract.MercadoTable.TABLE_NAME,
                    null,null,null,null,null,null);
            return toList(cursor);
        }finally {
            dbUser.close();
        }
    }

    private ArrayList toList(Cursor cursor){
        ArrayList<Mercado> mercados = new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                Mercado mercado = new Mercado();
                mercados.add(mercado);
                mercado.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                mercado.setNome(cursor.getString(cursor.getColumnIndex("Mercado")));
                mercado.setEndereco(cursor.getString(cursor.getColumnIndex("Endereço")));
                mercado.setCnpj(cursor.getLong(cursor.getColumnIndex("CNPJ")));
                mercado.setNum_telefone(cursor.getInt(cursor.getColumnIndex("Telefone")));
                mercado.setReceita(cursor.getDouble(cursor.getColumnIndex("Receita")));
                mercado.setNota(cursor.getDouble(cursor.getColumnIndex("Nota")));
            }while(cursor.moveToNext());
        }
        return mercados;
    }
}

