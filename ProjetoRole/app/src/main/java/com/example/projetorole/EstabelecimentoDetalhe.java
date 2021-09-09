package com.example.projetorole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EstabelecimentoDetalhe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estabelecimento_detalhe);

        Intent recebedorInfo = getIntent();

        Bundle param = recebedorInfo.getExtras();

        TextView nomeEstabelecimento = findViewById(R.id.textNome);
        TextView catEstabelicimento = findViewById(R.id.textCategoria);
        TextView statusEstabelecimento = findViewById(R.id.textStatus);
        TextView enderecoEstabelecimento = findViewById(R.id.textEndereco);
        TextView atracaoEstabelecimento = findViewById(R.id.textAtracao);
        TextView promocaoEstabelecimento = findViewById(R.id.textPromo);

        nomeEstabelecimento.setText(param.getString("nome"));
        catEstabelicimento.setText(param.getString("categoria"));
        statusEstabelecimento.setText(param.getString("status"));
        enderecoEstabelecimento.setText(param.getString("endereco"));
        atracaoEstabelecimento.setText(param.getString("atracao"));
        promocaoEstabelecimento.setText(param.getString("promocao"));


    }
}