package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMostrarNotificacao = findViewById(R.id.btn_mostrarNotificacao);

        TextView tv_titulo = findViewById(R.id.tv_titulo);
        tv_titulo.setText("Novo Texto");

        btnMostrarNotificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Enviado com Sucesso", Toast.LENGTH_SHORT).show();
            }
        });
    }
}