package com.example.listviewcustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv_comidas_ceara;
    String[] comidas = {"Baiao", "Pamonha", "Feijoada", "Buchada", "Panelada", "Sopa"};

    int[] imagensComidas = {R.drawable.baiao, R.drawable.pamonha, R.drawable.feijoada, R.drawable.buchada, R.drawable.panelada, R.drawable.sopa};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_comidas_ceara = findViewById(R.id.lv_comidas_ceara);

        ListViewCustomAdapter customAdapter = new ListViewCustomAdapter(this, comidas, imagensComidas);

        lv_comidas_ceara.setAdapter(customAdapter);

    }
}