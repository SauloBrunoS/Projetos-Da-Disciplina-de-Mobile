package com.example.movieapp;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>{

    private List<FilmeModel> filmeList;

    public FilmeAdapter(List<FilmeModel> filmeList){
        this.filmeList = filmeList;
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout, parent, false);
        return new FilmeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        FilmeModel filme = filmeList.get(position);
        holder.tv_nome_filme_item.setText(filme.getTituloFilme());
        holder.tv_descricao_filme_item.setText(filme.getDescricaoFilme());
        holder.card_layout.setBackgroundResource(filme.getBackgroundImageFilme());
    }

    @Override
    public int getItemCount() {
        return filmeList != null ? filmeList.size() : 0;
    }

    public static class FilmeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_nome_filme_item, tv_descricao_filme_item;
        ConstraintLayout card_layout;

        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_nome_filme_item = itemView.findViewById(R.id.tv_nome_filme_item);
            tv_descricao_filme_item = itemView.findViewById(R.id.tv_descricao_filme_item);
            card_layout = itemView.findViewById(R.id.card_layout);

            tv_nome_filme_item.setOnClickListener(this);
            tv_descricao_filme_item.setOnClickListener(this);
            card_layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Você clicou no filme: " + tv_nome_filme_item.getText(), Toast.LENGTH_SHORT).show();
        }
    }

}