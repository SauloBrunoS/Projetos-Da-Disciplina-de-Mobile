package com.example.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class SimpleWorker extends Worker {
    public SimpleWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        for(int i = 0; i < 10000;i++){
            Log.d("sid-tag", "O valor atual é: "+i);
        }
        return Result.success();
    }
}
