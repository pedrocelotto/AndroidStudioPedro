package com.example.projetosemestral;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.projetosemestral.Adapters.BaladaAdapter;
import com.example.projetosemestral.Adapters.MyFragmentPagerAdapter;
import com.example.projetosemestral.model.Balada;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private RecyclerView recyclerView;
    private List<Balada> listaBaladas = new ArrayList<Balada>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_balada);

        mTabLayout =(TabLayout) findViewById(R.id.tab_layout);
        mViewPager =(ViewPager) findViewById(R.id.view_pager);

        mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), getResources().getStringArray(R.array.titles_tab)));

        mTabLayout.setupWithViewPager(mViewPager);

        //Listagem de Baladas
        this.criarBalada();

        // Configurar o AdapterFilme
        BaladaAdapter baladaAdapterBalada = new BaladaAdapter(this.listaBaladas);

        // Configurar RecyclerView layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(baladaAdapterBalada);
    }

    public void criarBalada(){
        Balada novaBalada = new Balada("CHESS PUB", true, "Av. Itatiaia, 123");
        listaBaladas.add(novaBalada);
        novaBalada = new Balada("SALZ BAR", false, "Av. Itatiaia, 456");
        listaBaladas.add(novaBalada);
    }

}