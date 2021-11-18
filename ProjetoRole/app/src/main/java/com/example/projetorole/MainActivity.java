package com.example.projetorole;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.projetorole.BancoDeDados.ControleBanco;
import com.example.projetorole.model.Estabelecimento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ControleBanco controleBanco = new ControleBanco(this);
    ListView lista_estab;
    List<Estabelecimento> listaEstabelecimentos = new ArrayList<Estabelecimento>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Estabelecimento estabelecimento = new Estabelecimento("Salz", "12.345.678/0001-90", 1, "Rua Itatiaia, 100",
                "Bar", "pagode", "Chopp em dobro");
        estabelecimento = new Estabelecimento("Buteco", "123456789", 0,"Av brasil, 123", "Bar", "Fervo", "Drinks");
        //estabelecimento = new Estabelecimento("Barzin", "789456123", 1, "Rua 1, 123", "Puteiro", "Garotas", "2 por 1");

        controleBanco.insereDadoEstabelecimento(estabelecimento);

        //Intent i = getIntent();
        lista_estab = (ListView) findViewById(R.id.lista);


        listaEstabelecimentos = controleBanco.retornaDados();
        ArrayList<String> lugares = new ArrayList<>();

        for(Estabelecimento estabelecimentoTemp : listaEstabelecimentos){
            lugares.add(estabelecimentoTemp.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, lugares);
        Log.d("adapter", "cheguei adapter");
        lista_estab.setAdapter(adapter);

        lista_estab.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Log.d("posicao", "ChegueiAqui, " + listaEstabelecimentos.get(position).toString());
                Intent intent = new Intent(getApplicationContext(), EstabelecimentoDetalhe.class);
                intent.putExtra("estabelecimento", (Serializable) listaEstabelecimentos.get(position));
                startActivity(intent);
            }
        });
    }

}