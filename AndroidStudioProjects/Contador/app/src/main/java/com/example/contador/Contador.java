package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Contador extends AppCompatActivity {

    TextView tv_contagem;
    Button btn_aumentar_contagem;
    int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        Intent intentMain = getIntent();
        cont = intentMain.getIntExtra("valor_contador", 0);

        btn_aumentar_contagem = findViewById(R.id.btn_aumentarContagem);
        
        tv_contagem.setText("" + cont);

        btn_aumentar_contagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                tv_contagem.setText("" + cont);
                Toast.makeText(Contador.this, "Aumentado com sucesso", Toast.LENGTH_SHORT).show();
            }
        });
    }
}