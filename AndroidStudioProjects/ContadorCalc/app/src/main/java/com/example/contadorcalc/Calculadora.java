package com.example.contadorcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        Intent main_activity_intent = getIntent();
        int valorCompartilhado = main_activity_intent.getIntExtra("ultimo_valor_contador", 0);
        Log.d("log-sid-valor-compartilhado", String.valueOf(valorCompartilhado));

        TextView tv_shared_data = findViewById(R.id.tv_shared_data);
        tv_shared_data.setText("" + valorCompartilhado);

    }
}