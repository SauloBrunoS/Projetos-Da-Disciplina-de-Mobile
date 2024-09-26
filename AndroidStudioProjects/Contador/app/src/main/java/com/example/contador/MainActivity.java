package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int valorInicialContador;
    Button btn_contador, btn_calculadora;

    EditText et_valor_inicial_contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_contador = findViewById(R.id.btn_contador);
        btn_calculadora = findViewById(R.id.btn_calculadora);
        et_valor_inicial_contador = findViewById(R.id.et_valor_inicial_contador);

        btn_contador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentContador = new Intent(MainActivity.this, Contador.class);
                intentContador.putExtra("valor_contador", Integer.parseInt(et_valor_inicial_contador.getText().toString()));
                startActivity(intentContador);
            }
        });

        btn_calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCalculadora = new Intent(MainActivity.this, Calculadora.class);
                startActivity(intentCalculadora);
                startActivity(intentCalculadora);
            }
        });
    }
}