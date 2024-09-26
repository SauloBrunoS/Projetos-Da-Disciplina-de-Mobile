package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity {

    EditText et_valor1, et_valor2;
    float valor1, valor2;

    float resultado;

    TextView tv_resultado;

    Button btn_adicionar, btn_subtrair, btn_multiplicar, btn_dividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        et_valor1 = findViewById(R.id.et_valor1);
        et_valor2 = findViewById(R.id.et_valor2);
        tv_resultado = findViewById(R.id.tv_resultado);

        btn_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    valor1 = Float.parseFloat(et_valor1.getText().toString());
                    valor2 = Float.parseFloat(et_valor2.getText().toString());
                    resultado = valor1 + valor2;
                    tv_resultado.setText("" + resultado);
                    Toast.makeText(Calculadora.this, "Adicionado com sucesso", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(Calculadora.this, "Informe dois valores", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_subtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    valor1 = Float.parseFloat(et_valor1.getText().toString());
                    valor2 = Float.parseFloat(et_valor2.getText().toString());
                    resultado = valor1 - valor2;
                    tv_resultado.setText("" + resultado);
                    Toast.makeText(Calculadora.this, "Subtraído com sucesso", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(Calculadora.this, "Informe dois valores", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    valor1 = Float.parseFloat(et_valor1.getText().toString());
                    valor2 = Float.parseFloat(et_valor2.getText().toString());
                    resultado = valor1 * valor2;
                    tv_resultado.setText("" + resultado);
                    Toast.makeText(Calculadora.this, "Multiplicado com sucesso", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(Calculadora.this, "Informe dois valores", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    valor1 = Float.parseFloat(et_valor1.getText().toString());
                    valor2 = Float.parseFloat(et_valor2.getText().toString());
                    if(valor2 != 0) {
                        resultado = valor1 / valor2;
                        tv_resultado.setText("" + resultado);
                        Toast.makeText(Calculadora.this, "Dividido com sucesso", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Calculadora.this, "Não é possível dividir por 0", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(Calculadora.this, "Informe dois valores", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}