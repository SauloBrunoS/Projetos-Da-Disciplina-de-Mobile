package com.example.pokemonapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class InformacoesGeraisFragment extends Fragment {

    public InformacoesGeraisFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informacoes_gerais, container, false);
        TextView tv_nome_pokemon = view.findViewById(R.id.tv_nome_pokemon);
        TextView tv_tipo_pokemon = view.findViewById(R.id.tv_tipo_pokemon);
        TextView tv_descricao_pokemon = view.findViewById(R.id.tv_descricao_pokemon);
        ImageView iv_pokemon = view.findViewById(R.id.iv_pokemon);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.pokemon_preferences_arquivo), Context.MODE_PRIVATE);
        String nome = sharedPreferences.getString("nome", "Nome não encontrado");
        String tipo = sharedPreferences.getString("tipo", "Tipo não encontrado");
        String descricao = sharedPreferences.getString("descricao", "Descrição não encontrada");
        int imagem = sharedPreferences.getInt("imagem", 0);

        tv_nome_pokemon.setText("Nome: " + nome);
        tv_tipo_pokemon.setText("Tipo: " + tipo);
        tv_descricao_pokemon.setText("Descrição: " + descricao);
        iv_pokemon.setBackgroundResource(imagem);

        return view;
    }
}