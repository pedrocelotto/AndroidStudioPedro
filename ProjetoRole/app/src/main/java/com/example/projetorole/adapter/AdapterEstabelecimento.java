package com.example.projetorole.adapter;

import android.text.NoCopySpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetorole.R;
import com.example.projetorole.model.Estabelecimento;

import java.util.List;

public class AdapterEstabelecimento extends RecyclerView.Adapter<AdapterEstabelecimento.MyViewHolder>{
    private List<Estabelecimento> listaEstabelecimentos;

    public AdapterEstabelecimento(List<Estabelecimento> lista){
        listaEstabelecimentos = lista;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        TextView endereco;
        TextView status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textNome);
            endereco = itemView.findViewById(R.id.textEndereco);
            status = itemView.findViewById(R.id.textStatus);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista,parent,false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (listaEstabelecimentos != null) {
            holder.nome.setText(listaEstabelecimentos.get(position).getNome());
            holder.endereco.setText(listaEstabelecimentos.get(position).getEndereco());
            if (listaEstabelecimentos.get(position).getStatus() == false){
                holder.status.setText("Fechado");
            }else {
                holder.status.setText("Aberto");
            }
        }
    }

    @Override
    public int getItemCount() {
        return listaEstabelecimentos.size();
    }
}
