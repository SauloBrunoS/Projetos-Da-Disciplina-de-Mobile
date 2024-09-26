package com.example.pokemonapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EstatisticasFragment extends Fragment {

    public EstatisticasFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_estatisticas, container, false);
        TextView tv_hp = view.findViewById(R.id.tv_hp);
        TextView tv_ataque = view.findViewById(R.id.tv_ataque);
        TextView tv_defesa = view.findViewById(R.id.tv_defesa);
        TextView tv_ataque_especial = view.findViewById(R.id.tv_ataque_especial);
        TextView tv_defesa_especial = view.findViewById(R.id.tv_defesa_especial);
        TextView tv_velocidade = view.findViewById(R.id.tv_velocidade);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.pokemon_preferences_arquivo), Context.MODE_PRIVATE);
        int hp = sharedPreferences.getInt("hp", 0);
        int ataque = sharedPreferences.getInt("ataque", 0);
        int defesa = sharedPreferences.getInt("defesa", 0);
        int ataqueEspecial = sharedPreferences.getInt("ataqueEspecial", 0);
        int defesaEspecial = sharedPreferences.getInt("defesaEspecial", 0);
        int velocidade = sharedPreferences.getInt("velocidade", 0);

        tv_hp.setText("HP: " + hp);
        tv_ataque.setText("Ataque: " + ataque);
        tv_defesa.setText("Defesa: " + defesa);
        tv_ataque_especial.setText("Ataque Especial: " + ataqueEspecial);
        tv_defesa_especial.setText("Defesa Especial: " + defesaEspecial);
        tv_velocidade.setText("Velocidade: " + velocidade);

        return view;
    }
}