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


public class ProdutoDAO {

    private final Database dataBase;
    private SQLiteDatabase dbUser;    //acessa a instancia do bando de dados;
    
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + ImarketDataBaseContract.ProdutoTable.TABLE_NAME + " (" +
                    ImarketDataBaseContract.ProdutoTable._ID + PRIMARY_KEY_AUTO +
                    ImarketDataBaseContract.ProdutoTable.TABLE_COLUMN_PRODUTO_NOME + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.ProdutoTable.TABLE_COLUMN_PRODUTO_PRECO + TEXT_TYPE + COMMA_SEP +
                    ImarketDataBaseContract.ProdutoTable.TABLE_COLUMN_PRODUTO_CATEGORIA  + TEXT_TYPE + " )";

    public ProdutoDAO(Context context){
        this.dataBase = new Database(context);
    }

    public static String createMyTable(){
        return SQL_CREATE_ENTRIES;
    }

    public static String dropMyTable() {
        return "DROP TABLE IF EXISTS " + ImarketDataBaseContract.ProdutoTable.TABLE_NAME;
    }

    /**
     *  Metodo Save:
     *  Salva ou atualiza entidade no banco. Se um produto já tem id(primarykey autoincrementada é pq
     *  ele já está no banco e precisa ser atualizado. Caso contrário será inserido
     *  @params: objeto a ser salvo
     *  @return: Boolean - True se sucesso.
     */
    public Boolean save(Produto produto){
        int id = produto.getId();
        dbUser = dataBase.getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put("Produto", produto.getNome());
            values.put("Preço", produto.getPreco());
            values.put("Categoria", produto.getCategoria());
            if (id!=0){                                         //se o produto já tem id então update
                String _id = String.valueOf(id);
                String[] whereArgs = new String[]{_id};
                return dbUser.update(ImarketDataBaseContract.ProdutoTable.TABLE_NAME, values,
                        "_id=?", whereArgs)>0;
            }else{                                              //caso contrário inserir no banco;
                Log.w("Banco", "Sucesso");
                return dbUser.insert(ImarketDataBaseContract.ProdutoTable.TABLE_NAME,"",values)>0;
            }
        }finally {
            dbUser.close();
        }
    }

    /**
     * Metodo delete remove um produto do banco de dados.
     * Após informado um produto ele é removido do banco com base no seu id.
     * @param produto - Produto a ser removido do banco
     * @return Boolean - True se removido com sucesso.
     */
    public Boolean delete(Produto produto){
        dbUser = dataBase.getWritableDatabase();
        try{
            return dbUser.delete(ImarketDataBaseContract.ProdutoTable.TABLE_NAME,
                    "_id=?", new String[]{String.valueOf(produto.getId())})>0;
        }finally {
            dbUser.close();
        }
    }

    /**
     * Método findAll retorna todas as ocorrencias de uma tabela
     * Após execução é retornada uma lista com todas a ocorrencias de uma tabela. O método findAll
     * gera um cursor com o resultado do select * então invoca o método tolist para converter o cur-
     * sor em um ArrayList
     * @return ArrayList coontendo todas as ocorrencias da tabela
     */
    public ArrayList findAll(){
        dbUser = dataBase.getReadableDatabase();
        try{
            Cursor cursor = dbUser.query(ImarketDataBaseContract.ProdutoTable.TABLE_NAME,
                    null,null,null,null,null,null);
            return toList(cursor);
        }finally {
            dbUser.close();
        }
    }

    /**
     * Retorna um ArrayList a partir de um cursor.
     * O metodo toList convert o cursor com o resultado de um select para um ArrayList que pode ser
     * passado para um arrayAdapter por exemplo.
     * @param cursor - contém o resultado de um select
     * @return ArrayList - contendo os dados do cursor.
     */
    private ArrayList toList(Cursor cursor){
        ArrayList<Produto> produtos = new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                Produto produto = new Produto();
                produtos.add(produto);
                produto.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                produto.setNome(cursor.getString(cursor.getColumnIndex("Produto")));
                produto.setPreco(cursor.getDouble(cursor.getColumnIndex("Preço")));
                produto.setCategoria(cursor.getString(cursor.getColumnIndex("Categoria")));
            }while(cursor.moveToNext());
        }
        return produtos;
    }
}
