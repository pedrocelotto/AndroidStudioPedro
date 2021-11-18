package com.example.projetorole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projetorole.model.Estabelecimento;

public class EstabelecimentoDetalhe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estabelecimento_detalhe);

        Intent recebedorInfo = getIntent();
        Estabelecimento estabelecimento = (Estabelecimento) recebedorInfo.getSerializableExtra("estabelecimento");

        TextView nomeEstabelecimento = findViewById(R.id.textNome);
        TextView catEstabelicimento = findViewById(R.id.textCategoria);
        TextView statusEstabelecimento = findViewById(R.id.textStatus);
        TextView enderecoEstabelecimento = findViewById(R.id.textEndereco);
        TextView atracaoEstabelecimento = findViewById(R.id.textAtracao);
        TextView promocaoEstabelecimento = findViewById(R.id.textPromo);

        nomeEstabelecimento.setText(estabelecimento.getNome());
        catEstabelicimento.setText(estabelecimento.getCategoria());
        if (estabelecimento.getStatus() == 1){
            statusEstabelecimento.setText("Aberto");
        }else{
            statusEstabelecimento.setText("Fechado");
        }
        enderecoEstabelecimento.setText(estabelecimento.getEndereco());
        atracaoEstabelecimento.setText(estabelecimento.getAtracao());
        promocaoEstabelecimento.setText(estabelecimento.getPromocoes());


    }
}