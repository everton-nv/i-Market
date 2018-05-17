package com.example.everton.i_market;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import static com.example.everton.i_market.EnumCategoriaProduto.enumCategoriaProdutoLista;

public class CadProdutoActivity extends AppCompatActivity {
    private EditText edtProduto, edtPreco;
    private Spinner spinner;
    private String[] listaCategoria = enumCategoriaProdutoLista();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_produto);

        edtProduto = (EditText)findViewById(R.id.edtProduto);
        edtPreco = (EditText)findViewById(R.id.edtPreco);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaCategoria);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner = (Spinner)findViewById(R.id.spinnerCategoria);
        spinner.setAdapter(adapter);

        //Metodo para quando um elemento do Spinner Ã© selecionado()
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void cadastrarProduto(View view){
        String produto     = edtProduto.getText().toString();
        String strpreco    = edtPreco.getText().toString();
        Double preco = Double.parseDouble(strpreco);
        String categoria = (String) spinner.getSelectedItem();

        ServicoProduto servicoProduto = new ServicoProduto(getApplicationContext());
        servicoProduto.cadastrarProduto(produto, preco, categoria, 1);
        Intent it = new Intent(CadProdutoActivity.this, MainActivity.class);
        startActivity(it);
        finish();

    }

    public void cancelarCadastro(View view){
        finish();
    }


}
