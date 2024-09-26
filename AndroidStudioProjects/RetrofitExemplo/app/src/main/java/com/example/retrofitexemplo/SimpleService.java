package com.example.retrofitexemplo;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SimpleService {
    public static final String API_URL = "https://servicodados.ibge.gov.br/";

    public List<Distrito> doRequest(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Github github = retrofit.create(Github.class);
        Call<List<Distrito>> call = github.distritos();
        try {
            List<Distrito> distritos = call.execute().body();
            return distritos;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
