package com.example.pokemonapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HabilidadesEMovimentosFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_habilidades_e_movimentos, container, false);
        TextView tv_habilidades = view.findViewById(R.id.tv_habilidades);
        TextView tv_movimentos = view.findViewById(R.id.tv_movimentos);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.pokemon_preferences_arquivo), Context.MODE_PRIVATE);
        String habilidades = sharedPreferences.getString("habilidades", "Habilidades não encontradas");
        String movimentos = sharedPreferences.getString("movimentos", "Movimentos não encontrados");

        tv_habilidades.setText("Habilidades: " + habilidades);
        tv_movimentos.setText("Movimentos: " + movimentos);

        return view;
    }
}