package com.example.mediaplayerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_tocar_som;
    ImageButton btn_miar, btn_latir, btn_zurrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_tocar_som = findViewById(R.id.btn_tocar_som);
        btn_miar = findViewById(R.id.btn_miar);
        btn_latir = findViewById(R.id.btn_latir);
        btn_zurrar = findViewById(R.id.btn_zurrar);

        btn_tocar_som.setOnClickListener(this);
        btn_miar.setOnClickListener(this);
        btn_latir.setOnClickListener(this);
        btn_zurrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("debug-mediaplayer", "botão foi clicado");
        Toast.makeText(this, "Botão Clicado", Toast.LENGTH_SHORT).show();
        MediaPlayer mediaPlayer;
        if (v == btn_tocar_som) {
            // Deve invocar o MediaPlayer
            mediaPlayer = MediaPlayer.create(this, R.raw.mp3_example);
            mediaPlayer.start();
        } else if (v == btn_miar) {
            mediaPlayer = MediaPlayer.create(this, R.raw.cat);
            mediaPlayer.start();
        } else if (v == btn_latir) {
            mediaPlayer = MediaPlayer.create(this, R.raw.dog);
            mediaPlayer.start();
        } else if (v == btn_zurrar) {
            mediaPlayer = MediaPlayer.create(this, R.raw.donkey);
            mediaPlayer.start();
        }
    }
}