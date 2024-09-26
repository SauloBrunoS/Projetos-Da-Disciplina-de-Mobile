package com.example.meucontador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_contagem;

    Button btn_aumentar_contagem;

    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_contagem = findViewById(R.id.tv_contagem);
        btn_aumentar_contagem = findViewById(R.id.btn_aumentar_contagem);

        btn_aumentar_contagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                tv_contagem.setText("" + contador);
                Toast.makeText(MainActivity.this, "Aumentado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}