package com.example.retrofitexemplo;

public class Distrito {
    public final int id;
    public final String nome;
    public final Municipio municipio;

    public Distrito(int id, String nome, Municipio municipio) {
        this.id = id;
        this.nome = nome;
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Distrito{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", municipio=" + municipio +
                '}';
    }
}
