package com.example.everton.i_market;

import android.content.Intent;
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
        //String nick = edtNick.getText().toString();
        //String senha = edtSenha.getText().toString();
        //String email = edtEmail.getText().toString();
        String strcnpj = edtCNPJ.getText().toString();
        long cnpj = Long.parseLong(strcnpj);
        String strtelefone = edtTelefone.getText().toString();
        int telefone = Integer.parseInt(strtelefone);
        String endereco = edtEndereco.getText().toString();
        String mercado = edtMercado.getText().toString();

        ServicoMercado servicoMercado = new ServicoMercado(getApplicationContext());
        servicoMercado.cadastrarMercado(0, mercado,endereco, cnpj, telefone);
        Intent it = new Intent(CadMercadoActivity.this, MainActivity.class);
        startActivity(it);
        finish();


    }

    public void cancelarCadastro(View view){
        finish();
    }


}
