package com.example.projetosemestral.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetosemestral.R;
import com.example.projetosemestral.model.Balada;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class BaladaAdapter extends RecyclerView.Adapter<BaladaAdapter.MyViewHolder> {
    private List<Balada> listaBaladas;

    public BaladaAdapter(List<Balada> lista){
        listaBaladas = lista;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nome;
        TextView status;
        TextView endereco;

        public MyViewHolder(View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textNome);
            status = itemView.findViewById(R.id.textStatus);
            endereco = itemView.findViewById(R.id.textEndereço);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    // Popula os objetos view com os dados
    @Override
    public void onBindViewHolder(@NonNull BaladaAdapter.MyViewHolder holder, int position) {
        if (listaBaladas != null) {
            holder.nome.setText(listaBaladas.get(position).getNomeBalada());
            if (!listaBaladas.get(position).getStatus()){
                holder.status.setText("Fechado");
            }else{
                holder.status.setText("Aberto");
            }
            holder.endereco.setText(listaBaladas.get(position).getEndereco());
        }
    }

    @Override
    public int getItemCount() {
        return listaBaladas.size();
    }


    /*@NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        Balada balada = lista.get(position);
        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.adapter_lista, null);
        TextView nomeBalada = (TextView) view.findViewById(R.id.textNome);
        nomeBalada.setText(balada.getNomeBalada());
        TextView statusBalada = (TextView) view.findViewById(R.id.textStatus);
        if(balada.getStatus() == false)
            statusBalada.setText("Fechado");
        else
            statusBalada.setText("Aberto");
        TextView enderecoBalada = (TextView) view.findViewById(R.id.textEndereço);
        enderecoBalada.setText(balada.getEndereco());

        return view;
    }*/
}
