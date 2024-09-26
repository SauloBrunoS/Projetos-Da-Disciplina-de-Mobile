package com.example.gamesnews.retrofit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gamesnews.model.NewsResponse;
import com.example.gamesnews.retrofit.GoogleNewsApiService;
import com.example.gamesnews.retrofit.NewsCallback;
import com.example.gamesnews.utils.ZonedDateTimeDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.ZonedDateTime;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NewsFetcher {

    private static final String BASE_URL = "https://serpapi.com";

    @NonNull
    private GoogleNewsApiService createNewsService() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(GoogleNewsApiService.class);
    }

    public void fetchNews(String query, @Nullable Integer sorting_method, String apiKey, String topicToken, String publicationToken, String sectionToken, String storyToken, NewsCallback callback) {
        GoogleNewsApiService service = createNewsService();

        // Chamada de API com parâmetros
        Call<NewsResponse> call = service.getNews(
                "google_news",   // engine
                query,         // query
                "pt-br",            // language
                "br",            // country
                sorting_method,  // sort by date or relevance
                apiKey,          // API key
                topicToken,      // Token de tópico (opcional)
                publicationToken, // Token de publicação (opcional)
                sectionToken,    // Token de seção (opcional)
                storyToken       // Token de história (opcional)
        );

        // Executa a chamada
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    NewsResponse newsResponse = response.body();
                    callback.onSuccess(newsResponse.getNewsResults());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}