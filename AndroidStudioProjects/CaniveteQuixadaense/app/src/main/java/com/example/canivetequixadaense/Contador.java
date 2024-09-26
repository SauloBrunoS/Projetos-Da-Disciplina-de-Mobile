package com.example.canivetequixadaense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Contador extends AppCompatActivity {

    TextView tv_contagem;

    Button btn_aumentar_contagem;

    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        Intent intentMain = getIntent();
        contador = intentMain.getIntExtra("valor_inicial_contador", 0);

        tv_contagem = findViewById(R.id.tv_contagem);
        btn_aumentar_contagem = findViewById(R.id.btn_aumentar_contagem);

        tv_contagem.setText("" + contador);

        btn_aumentar_contagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                tv_contagem.setText("" + contador);
                Toast.makeText(Contador.this, "Aumentado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}