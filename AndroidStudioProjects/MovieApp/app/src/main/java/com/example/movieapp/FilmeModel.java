package com.example.movieapp;

public class FilmeModel {
    private String tituloFilme;
    private String descricaoFilme;
    private int backgroundImageFilme;

    public FilmeModel(String tituloFilme, String descricaoFilme, int backgroundImageFilme) {
        this.tituloFilme = tituloFilme;
        this.descricaoFilme = descricaoFilme;
        this.backgroundImageFilme = backgroundImageFilme;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public String getDescricaoFilme() {
        return descricaoFilme;
    }

    public void setDescricaoFilme(String descricaoFilme) {
        this.descricaoFilme = descricaoFilme;
    }

    public int getBackgroundImageFilme() {
        return backgroundImageFilme;
    }

    public void setBackgroundImageFilme(int backgroundImageFilme) {
        this.backgroundImageFilme = backgroundImageFilme;
    }
}
