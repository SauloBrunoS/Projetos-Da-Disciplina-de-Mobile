package br.ufc.quixada.listviewexampletodelete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewCustomAdapter extends BaseAdapter {

    String[] comidas;
    Context context;

    ListViewCustomAdapter(Context context, String[] comidas){
        this.context = context;
        this.comidas = comidas;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_item_listview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvNomeComida = convertView.findViewById(R.id.tv_nome_item);
            viewHolder.ivComida = convertView.findViewById(R.id.iv_foto_item);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvNomeComida.setText(comidas[position]);
        viewHolder.ivComida.setBackgroundResource(R.drawable.buchada);

        return convertView;
    }

    static class ViewHolder{
        TextView tvNomeComida;
        ImageView ivComida;
    }

}


