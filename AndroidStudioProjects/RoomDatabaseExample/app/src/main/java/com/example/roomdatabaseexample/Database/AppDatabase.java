package com.example.roomdatabaseexample.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomdatabaseexample.Dao.PessoaDao;
import com.example.roomdatabaseexample.model.Pessoa;

@Database(entities = {Pessoa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PessoaDao pessoaDao();
}