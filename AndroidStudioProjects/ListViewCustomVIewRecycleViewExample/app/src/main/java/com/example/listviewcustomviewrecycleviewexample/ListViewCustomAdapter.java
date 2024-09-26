package com.example.listviewcustomviewrecycleviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewCustomAdapter extends BaseAdapter {

    String[] comidas;
    Context context;

    ListViewCustomAdapter(Context context, String[] comidas) {
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
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_item_listview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv_nome_comida = convertView.findViewById(R.id.tv_nome_item);
            viewHolder.iv_comida = convertView.findViewById(R.id.iv_foto_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ViewHolder.tv_nome_comida.setText();
        ViewHolder.iv_comida.set
    }

    static Class ViewHolder {
        TextView tv_nome_comida;
        ImageView iv_comida;
    }
}

