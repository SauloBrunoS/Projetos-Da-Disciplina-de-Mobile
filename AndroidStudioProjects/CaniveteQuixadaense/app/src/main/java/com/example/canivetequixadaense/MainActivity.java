package com.example.canivetequixadaense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_contador, btn_calculadora;
    EditText et_valor_inicial_contador;

    Intent intentContador, intentCalculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentContador = new Intent(MainActivity.this, Contador.class);
        intentCalculadora = new Intent(MainActivity.this, Calculadora.class);

        et_valor_inicial_contador = findViewById(R.id.et_valor_inicial_contador);
        btn_contador = findViewById(R.id.btn_contador);
        btn_calculadora = findViewById(R.id.btn_calculadora);

        btn_contador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToContador();
            }
        });

        btn_calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCalculadora);
            }
        });
    }

    public void goToContador() {
        try {
            intentContador.putExtra("valor_inicial_contador", Integer.parseInt(String.valueOf(et_valor_inicial_contador.getText())));
            startActivity(intentContador);
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Insira um Valor Inicial", Toast.LENGTH_SHORT).show();
        }
    }
}