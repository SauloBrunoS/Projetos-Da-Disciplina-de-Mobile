package com.example.roomdatabaseexemplo.RecyclerView;

public class Item {
    private String nome;
    private String curso;
    private int idade;

    public Item(String nome, String curso, int idade) {
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
}
