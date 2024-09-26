package com.example.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Constraints constraints = new Constraints.Builder().setRequiresBatteryNotLow(true).build();
        WorkRequest simpleWorkRequest = new OneTimeWorkRequest.Builder(SimpleWorker.class).setConstraints(constraints).build();
        WorkManager.getInstance(this).enqueue(simpleWorkRequest);
    }
}