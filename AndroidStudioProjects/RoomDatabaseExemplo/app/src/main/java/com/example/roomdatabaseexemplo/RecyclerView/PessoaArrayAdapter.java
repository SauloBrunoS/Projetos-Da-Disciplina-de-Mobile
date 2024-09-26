package com.example.roomdatabaseexemplo.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabaseexemplo.R;

import java.util.ArrayList;

public class PessoaArrayAdapter extends RecyclerView.Adapter<PessoaArrayAdapter.ViewHolder> {

    private int itemLayout;
    private ArrayList<Item> itemList;

    public PessoaArrayAdapter(int layoutId, ArrayList<Item> itemList){
        this.itemLayout = layoutId;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView tv_nome = holder.tv_nome;
        TextView tv_curso = holder.tv_curso;
        TextView tv_idade = holder.tv_idade;
        tv_nome.setText(itemList.get(position).getNome());
        tv_curso.setText(itemList.get(position).getCurso());
        tv_idade.setText(String.valueOf(itemList.get(position).getIdade()));
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_nome;
        public TextView tv_curso;
        public TextView tv_idade;

        public ViewHolder (View pessoaView){
            super(pessoaView);
            tv_nome = pessoaView.findViewById(R.id.tv_nome);
            tv_curso = pessoaView.findViewById(R.id.tv_curso);
            tv_idade = pessoaView.findViewById(R.id.tv_idade);
        }
    }
}
