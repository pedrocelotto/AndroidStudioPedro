package com.example.projetorole;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projetorole.adapter.AdapterEstabelecimento;
import com.example.projetorole.listener.RecyclerItemClickListener;
import com.example.projetorole.model.Estabelecimento;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Estabelecimento> listaEstabelecimentos = new ArrayList<Estabelecimento>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Listagem de filmes (pode vir de arquivos, banco de dados etc.
        this.criarEstabelecimento();

        // Configurar o AdapterFilme
        AdapterEstabelecimento EstAdapterEst = new AdapterEstabelecimento(this.listaEstabelecimentos);

        // Configurar RecyclerView layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(EstAdapterEst);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView,
               new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getApplicationContext(), EstabelecimentoDetalhe.class);
                        Bundle param = new Bundle();

                        param.putString("nome", listaEstabelecimentos.get(position).getNome());
                        param.putString("categoria", listaEstabelecimentos.get(position).getCategoria());
                        if(!listaEstabelecimentos.get(position).getStatus()) {
                            param.putString("status", "Fechado");
                        }else{
                            param.putString("status", "Aberto");
                        }
                        param.putString("endereco", listaEstabelecimentos.get(position).getEndereco());
                        param.putString("atracao", listaEstabelecimentos.get(position).getAtracao());
                        param.putString("promocao", listaEstabelecimentos.get(position).getPromocoes());


                        intent.putExtras(param);
                        startActivity(intent);
                    }
                    @Override
                    public void onLongItemClick(View view, int position) {
                       Toast.makeText(getApplicationContext(),listaEstabelecimentos.get(position).toString(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
        }));
    }

    public void criarEstabelecimento() {
        Estabelecimento novoEstab = new Estabelecimento("TATU BOLA", "Av. Itatiaia, 123", false, "Bar", "Dupla Sertaneja / PGrupo de Pagode", "OPEN de Chopp até as 22:00hrs");
        listaEstabelecimentos.add(novoEstab);
        novoEstab = new Estabelecimento("SALZ", "Av. Itatiaia, 321", true, "Bar","Dupla Sertaneja / PGrupo de Pagode", "OPEN de Chopp até as 22:00hrs");
        listaEstabelecimentos.add(novoEstab);
        novoEstab = new Estabelecimento("ZANUTIS", "Av. Itatiaia, 321", true, "Bar","Dupla Sertaneja / PGrupo de Pagode", "OPEN de Chopp até as 22:00hrs");
        listaEstabelecimentos.add(novoEstab);
    }
}