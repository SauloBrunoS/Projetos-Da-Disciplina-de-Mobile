package com.example.retrofitexemplo;

public class Municipio {
    public final int id;
    public final String nome;

    public Municipio(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
