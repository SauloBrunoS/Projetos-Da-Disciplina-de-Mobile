package com.example.contadorcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_aumenta_contador, btn_chama_calculadora;

    TextView tv_contador;

    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_contador = findViewById(R.id.tv_contador);
        btn_aumenta_contador = findViewById(R.id.btn_aumenta_contador);
        btn_chama_calculadora = findViewById(R.id.btn_calculadora);

        btn_aumenta_contador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                tv_contador.setText("" + contador);
                Toast.makeText(MainActivity.this, "Aumentado com sucesso", Toast.LENGTH_SHORT).show();
            }
        });

        btn_chama_calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });
    }

    public void goToSecondActivity() {
        Intent chamaCalculadora = new Intent(MainActivity.this, Calculadora.class);
        chamaCalculadora.putExtra("ultimo_valor_contador", contador);
        startActivity(chamaCalculadora);
    }
}