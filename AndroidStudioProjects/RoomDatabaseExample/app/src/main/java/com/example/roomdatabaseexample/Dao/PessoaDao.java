package com.example.roomdatabaseexample.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabaseexample.model.Pessoa;

import java.util.List;

@Dao
public interface PessoaDao {
    @Query("SELECT * FROM pessoa")
    List<Pessoa> getAll();

    @Insert
    void insertAll(Pessoa... pessoas);

    @Delete
    void delete(Pessoa pessoa);
}