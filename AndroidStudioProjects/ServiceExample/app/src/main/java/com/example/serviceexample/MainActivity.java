package com.example.serviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_start_music, btn_stop_music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start_music = findViewById(R.id.btn_start_music);
        btn_stop_music = findViewById(R.id.btn_stop_music);

        btn_start_music.setOnClickListener(this);
        btn_stop_music.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btn_start_music) {
            Log.d("sidartha", "start music button pressed");
            Intent startMusicIntent = new Intent(this, MusicInBackgroundService.class);
            startService(startMusicIntent);
        } else if(v == btn_stop_music){
            Log.d("sidartha", "stop music button pressed");
            Intent stopMusicIntent = new Intent(this, MusicInBackgroundService.class);
            stopService(stopMusicIntent);
        }
    }
}