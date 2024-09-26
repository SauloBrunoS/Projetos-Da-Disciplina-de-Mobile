package com.example.listviewcustomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewCustomAdapter extends BaseAdapter {

    String[] comidas;

    int[] imagensComidas;
    Context context;

    ListViewCustomAdapter(Context context, String[] comidas, int[] imagensComidas){
        this.context = context;
        this.comidas = comidas;
        this.imagensComidas = imagensComidas;
    }

    @Override
    public int getCount() {
        return comidas.length;
    }

    @Override
    public Object getItem(int position) {
        return comidas[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_item_listview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvNomeComida = convertView.findViewById(R.id.tv_nome_item);
            viewHolder.ivComida = convertView.findViewById(R.id.iv_foto_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvNomeComida.setText(comidas[position]);
        viewHolder.ivComida.setBackgroundResource(imagensComidas[position]);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int posicao = position;
                String nomeComida = comidas[posicao];
                Toast.makeText(context, "Posição: " + posicao + ", Nome: " + nomeComida, Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }

    static class ViewHolder {
        TextView tvNomeComida;
        ImageView ivComida;
    }

}


