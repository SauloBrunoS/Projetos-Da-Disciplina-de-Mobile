package com.example.pokemonapp;

import android.content.Context;
import android.content.SharedPreferences;

public class Pokemon {
    private static final int PREFERENCES_FILE = R.string.pokemon_preferences_arquivo;
    private int imagem;
    private String nome;
    private int numeroPokedex;
    private String tipo;
    private String descrição;
    private int hp;
    private int ataque;
    private int defesa;
    private int ataqueEspecial;
    private int defesaEspecial;
    private int velocidade;
    private String[] habilidades;
    private String[] movimentos;

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroPokedex() {
        return numeroPokedex;
    }

    public void setNumeroPokedex(int numeroPokedex) {
        this.numeroPokedex = numeroPokedex;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getDefesaEspecial() {
        return defesaEspecial;
    }

    public void setDefesaEspecial(int defesaEspecial) {
        this.defesaEspecial = defesaEspecial;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    public String[] getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(String[] movimentos) {
        this.movimentos = movimentos;
    }

    public void saveToPreferences(Context context) {
        String PreferencesFileString = context.getString(PREFERENCES_FILE);
        SharedPreferences sharedPreferences = context.getSharedPreferences(PreferencesFileString, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("imagem", imagem);
        editor.putString("nome", nome);
        editor.putInt("numeroPokedex", numeroPokedex);
        editor.putString("tipo", tipo);
        editor.putString("descricao", descrição);
        editor.putInt("hp", hp);
        editor.putInt("ataque", ataque);
        editor.putInt("defesa", defesa);
        editor.putInt("ataqueEspecial", ataqueEspecial);
        editor.putInt("defesaEspecial", defesaEspecial);
        editor.putInt("velocidade", velocidade);
        editor.putString("habilidades", String.join(",\n", habilidades));
        editor.putString("movimentos", String.join(",\n", movimentos));

        editor.apply();
    }


    public void loadFromPreferences(Context context) {
        String PreferencesFileString = context.getString(PREFERENCES_FILE);
        SharedPreferences sharedPreferences = context.getSharedPreferences(PreferencesFileString, Context.MODE_PRIVATE);
        imagem = sharedPreferences.getInt("imagem", 0);
        nome = sharedPreferences.getString("nome", "");
        numeroPokedex = sharedPreferences.getInt("numeroPokedex", 0);
        tipo = sharedPreferences.getString("tipo", "");
        descrição = sharedPreferences.getString("descricao", "");
        hp = sharedPreferences.getInt("hp", 0);
        ataque = sharedPreferences.getInt("ataque", 0);
        defesa = sharedPreferences.getInt("defesa", 0);
        ataqueEspecial = sharedPreferences.getInt("ataqueEspecial", 0);
        defesaEspecial = sharedPreferences.getInt("defesaEspecial", 0);
        velocidade = sharedPreferences.getInt("velocidade", 0);
        habilidades = sharedPreferences.getString("habilidades", "").split(",");
        movimentos = sharedPreferences.getString("movimentos", "").split(",");
    }
}
