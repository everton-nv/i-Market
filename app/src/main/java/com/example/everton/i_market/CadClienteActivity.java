package com.example.everton.i_market;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadClienteActivity extends AppCompatActivity {
    private EditText edtNick, edtEmail, edtSenha, edtNome, edtTelefone, edtCPF, edtEndereco, edtCartao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_cliente);

        edtNick = (EditText)findViewById(R.id.edtNick);
        edtSenha = (EditText)findViewById(R.id.edtSenha);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtCPF = (EditText)findViewById(R.id.edtCpf);
        edtTelefone = (EditText)findViewById(R.id.edtTelefone);
        edtEndereco = (EditText)findViewById(R.id.edtEndereco);
        edtNome = (EditText)findViewById(R.id.edtNome);
        edtCartao = (EditText)findViewById(R.id.edtCartao);

    }

    public void cadastrarCliente(View view) {
        //String nick = edtNick.getText().toString();
        //String senha = edtSenha.getText().toString();
        //String email = edtEmail.getText().toString();
        String strcpf = edtCPF.getText().toString();
        long cpf = Long.parseLong(strcpf);
        String strtelefone = edtTelefone.getText().toString();
        int telefone = Integer.parseInt(strtelefone);
        String endereco = edtEndereco.getText().toString();
        String nome = edtNome.getText().toString();
        String strncartao = edtCartao.getText().toString();
        int ncartao = Integer.parseInt(strncartao);

        ServicoCliente servicoCliente = new ServicoCliente(getApplicationContext());
        servicoCliente.cadastrarCliente(0, nome, endereco, cpf, telefone, ncartao);
        Intent it = new Intent(CadClienteActivity.this, MainActivity.class);
        startActivity(it);
        finish();
    }

    public void cancelarCadastro(View view){
        finish();
    }
}
