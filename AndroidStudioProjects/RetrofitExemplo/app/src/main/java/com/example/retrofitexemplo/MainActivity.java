package com.example.retrofitexemplo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swiperefresh);
        ListView listView = findViewById(R.id.lv_itens);
        List<String> itemList = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);

        listView.setAdapter(adapter);

        Runnable updateRunnable = new Runnable() {
            @Override
            public void run() {
                SimpleService simpleService = new SimpleService();
                List<Distrito> distritos = simpleService.doRequest();
                for (Distrito d : distritos) {
                    if (d.municipio.nome.equals("Quixadá")) {
                        itemList.add(d.nome + " - " + d.municipio.nome);
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        };

        new Thread(updateRunnable).start();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(updateRunnable).start();
                swipeRefreshLayout.setRefreshing(false); // Para a animação de refresh
            }
        });
    }
}
