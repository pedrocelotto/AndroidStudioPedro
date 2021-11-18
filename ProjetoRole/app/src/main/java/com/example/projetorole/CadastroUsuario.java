package com.example.projetorole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetorole.BancoDeDados.ControleBanco;
import com.example.projetorole.model.Usuario;

public class CadastroUsuario extends AppCompatActivity {

    ControleBanco bancoControle = new ControleBanco(this);

    EditText edtCpf;
    EditText edtNome;
    EditText edtSenha;
    EditText edtData;
    Button botao_cadastra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        botao_cadastra = findViewById(R.id.btnCadastrar);

        botao_cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtCpf = findViewById(R.id.edtCpf);
                edtNome = findViewById(R.id.edtNome);
                edtSenha = findViewById(R.id.edtSenha);
                edtData = findViewById(R.id.edtData);

                edtCpf.getText().toString();
                edtNome.getText().toString();
                edtSenha.getText().toString();
                edtData.getText().toString();

                bancoControle.insereDadoUsuario(new Usuario(edtNome.getText().toString(), edtCpf.getText().toString(),
                        edtSenha.getText().toString(), edtData.getText().toString()));

                Toast toast = Toast.makeText(getApplicationContext(), "Usuário Cadastrado", Toast.LENGTH_LONG);
                toast.show();

                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);

                finish();
            }
        });
    }

}