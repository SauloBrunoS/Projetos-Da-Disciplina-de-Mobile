package com.example.canivetequixadaense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity {

    EditText et_valor1, et_valor2;

    TextView tv_resultado;

    Button btn_somar, btn_subtrair, btn_multiplicar, btn_dividir;

    float valor1, valor2, resultado_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        et_valor1 = findViewById(R.id.et_valor1);
        et_valor2 = findViewById(R.id.et_valor2);

        btn_somar = findViewById(R.id.btn_somar);
        btn_subtrair = findViewById(R.id.btn_subtrair);
        btn_multiplicar = findViewById(R.id.btn_multiplicar);
        btn_dividir = findViewById(R.id.btn_dividir);

        tv_resultado = findViewById(R.id.tv_resultado);

        btn_somar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculadora('+');
            }
        });

        btn_subtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculadora('-');
            }
        });

        btn_multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculadora('*');
            }
        });

        btn_dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculadora('/');
            }
        });
    }

    public void calculadora(char operador) {
        try {
            valor1 = Float.parseFloat(String.valueOf(et_valor1.getText()));
            valor2 = Float.parseFloat(String.valueOf(et_valor2.getText()));

            switch (operador) {
                case '+':
                    resultado_final = valor1 + valor2;
                    break;
                case '-':
                    resultado_final = valor1 - valor2;
                    break;
                case '*':
                    resultado_final = valor1 * valor2;
                    break;
                case '/':
                    if(valor2 != 0) resultado_final = valor1 / valor2;
                    else
                        Toast.makeText(Calculadora.this, "Não é Possível Dividir por 0", Toast.LENGTH_SHORT).show();
                    break;
            }
            if(operador != '/' || valor2 != 0) tv_resultado.setText(String.valueOf(resultado_final));
        } catch (Exception e) {
            Toast.makeText(Calculadora.this, "Insira Dois Valores", Toast.LENGTH_SHORT).show();
        }
    }
}