package com.example.retrofitexemplo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Github {

    @GET("api/v1/localidades/distritos")
    Call<List<Distrito>> distritos();
}
