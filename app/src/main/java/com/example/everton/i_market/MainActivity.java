package com.example.everton.i_market;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadMercado(View view){
        Intent it = new Intent(MainActivity.this, CadMercadoActivity.class);
        startActivity(it);
        finish();
    }

    public void cadProduto(View view){
        Intent it = new Intent(MainActivity.this, CadProdutoActivity.class);
        startActivity(it);
        finish();
    }

    public void cadCliente(View view){
        Intent it = new Intent(MainActivity.this, CadClienteActivity.class);
        startActivity(it);
        finish();
    }
}
