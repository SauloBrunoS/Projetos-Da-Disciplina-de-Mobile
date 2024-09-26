package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_start_music, btn_stop_music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start_music = findViewById(R.id.btn_start_music);
        btn_stop_music = findViewById(R.id.btn_stop_music);

        btn_start_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMusic = new Intent(v.getContext(), MusicBackgroundService.class);
                startService(startMusic);
            }
        });

        btn_stop_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopMusic = new Intent(v.getContext(), MusicBackgroundService.class);
                stopService(stopMusic);
            }
        });

    }
}