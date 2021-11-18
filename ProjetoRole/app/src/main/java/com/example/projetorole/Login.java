package com.example.projetorole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.Control;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projetorole.BancoDeDados.ControleBanco;
import com.example.projetorole.model.Usuario;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    ControleBanco bancoControle = new ControleBanco(this);
    
    EditText cpf_login;
    EditText senha_login;
    Button botao_entrar;
    TextView botao_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        botao_cadastrar = findViewById(R.id.txtCadastrar);
        botao_entrar = findViewById(R.id.btnLogin);

        botao_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cpf_login = findViewById(R.id.edtCpf);
                senha_login = findViewById(R.id.edtSenha);

                cpf_login.getText().toString();
                senha_login.getText().toString();

                bancoControle.autenticaUsuario(cpf_login.getText().toString(), senha_login.getText().toString());

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

                finish();
            }
        });
    }

    public void telaCadastro(View view){
        Intent i = new Intent(this, CadastroUsuario.class);
        startActivity(i);
    }
}