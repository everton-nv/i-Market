package com.example.everton.i_market;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadMercadoActivity extends AppCompatActivity {
    private EditText edtNick, edtEmail, edtSenha, edtMercado, edtTelefone, edtCNPJ, edtEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_mercado);

        edtNick = (EditText)findViewById(R.id.edtNick);
        edtSenha = (EditText)findViewById(R.id.edtSenha);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtCNPJ = (EditText)findViewById(R.id.edtCnpj);
        edtTelefone = (EditText)findViewById(R.id.edtTelefone);
        edtEndereco = (EditText)findViewById(R.id.edtEndereco);
        edtMercado = (EditText)findViewById(R.id.edtMercado);
    }

    public void cadastrarMercado(View view){

    }

    public void cancelarCadastro(View view){
        finish();
    }


}
