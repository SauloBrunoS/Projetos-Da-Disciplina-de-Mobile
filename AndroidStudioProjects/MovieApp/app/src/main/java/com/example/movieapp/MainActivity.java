package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_filmes;
    private ArrayList<FilmeModel> filmeList = new ArrayList<FilmeModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_filmes = findViewById(R.id.rv_filmes);

        filmeList.add(new FilmeModel("Titanic", "Uma história épica de romance e tragédia centrada no famoso naufrágio do RMS Titanic.", R.drawable.titanic));
        filmeList.add(new FilmeModel("O Senhor dos Anéis: A Sociedade do Anel", "Baseado na obra de J.R.R. Tolkien, este filme narra a jornada de um grupo de personagens em busca de destruir um poderoso anel, enfrentando perigos e desafios épicos ao longo do caminho.", R.drawable.senhor_dos_aneis));
        filmeList.add(new FilmeModel("O Poderoso Chefão", "Um épico do cinema dirigido por Francis Ford Coppola, que narra a saga de uma família mafiosa italiana na América, liderada pelo patriarca Vito Corleone.", R.drawable.poderoso_chefao));
        filmeList.add(new FilmeModel("Matrix", "Um filme de ficção científica revolucionário que explora a ideia de realidade virtual, onde a humanidade é controlada por máquinas inteligentes e um hacker chamado Neo descobre a verdadeira natureza de sua existência.", R.drawable.matrix));
        filmeList.add(new FilmeModel("Forrest Gump: O Contador de Histórias", "A história de um homem simples com um coração puro que vive uma vida extraordinária, testemunhando e participando de eventos importantes na história dos Estados Unidos.", R.drawable.forrest_gump));
        filmeList.add(new FilmeModel("A Origem", "Dirigido por Christopher Nolan, este filme de ficção científica explora o mundo dos sonhos e da manipulação da mente, enquanto um grupo de ladrões especializados tenta implantar uma ideia na mente de um CEO poderoso.", R.drawable.a_origem));
        filmeList.add(new FilmeModel("Interestelar", "Uma aventura épica no espaço que segue um grupo de exploradores que viajam através de um buraco de minhoca em busca de um novo lar para a humanidade, enquanto enfrentam dilemas científicos e emocionais.", R.drawable.interestelar));

        FilmeAdapter filmeAdapter = new FilmeAdapter(filmeList);
        rv_filmes.setLayoutManager(new LinearLayoutManager(this));
        rv_filmes.setAdapter(filmeAdapter);

    }
}