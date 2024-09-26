package com.example.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdatabaseexample.Database.AppDatabase
import com.example.roomdatabaseexample.model.Pessoa

class MainActivity : AppCompatActivity() {

    Pessoa pessoa = new Pessoa("Sidartha", "Sistemas de Informação", 34);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}