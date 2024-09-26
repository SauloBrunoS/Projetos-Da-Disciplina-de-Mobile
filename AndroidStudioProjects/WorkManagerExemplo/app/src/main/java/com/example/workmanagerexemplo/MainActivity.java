package com.example.workmanagerexemplo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WorkRequest simpleWorkRequest = new OneTimeWorkRequest.Builder(SimpleWorker.class).build();
        WorkManager.getInstance(this).enqueue(simpleWorkRequest);
    }
}