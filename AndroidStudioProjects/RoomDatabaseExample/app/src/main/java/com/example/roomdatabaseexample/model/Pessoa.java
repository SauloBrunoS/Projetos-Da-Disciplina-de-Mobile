package com.example.roomdatabaseexample.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pessoa")
public class Pessoa {
        @PrimaryKey(autoGenerate = true)
        public int id;
        @ColumnInfo(name = "nome")
        public String nome;
        @ColumnInfo(name = "curso")
        public String curso;
        @ColumnInfo(name = "idade")
        public int idade;

        public Pessoa (String nome, String curso, int idade){
           this.nome = nome;
           this.curso = curso;
           this.idade = idade;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getCurso() {
                return curso;
        }

        public void setCurso(String curso) {
                this.curso = curso;
        }

        public int getIdade() {
                return idade;
        }

        public void setIdade(int idade) {
                this.idade = idade;
        }

        @NonNull
        @Override
        public String toString() {
                return this.getNome() + "|" + this.getCurso() + "|" + this.getIdade();
        }
}
