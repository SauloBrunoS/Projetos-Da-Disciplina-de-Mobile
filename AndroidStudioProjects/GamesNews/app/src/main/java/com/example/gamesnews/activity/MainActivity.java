package com.example.gamesnews.activity;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.gamesnews.adapter.NewsAdapter;
import com.example.gamesnews.retrofit.NewsCallback;
import com.example.gamesnews.retrofit.NewsFetcher;
import com.example.gamesnews.model.NewsResult;
import com.example.gamesnews.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private List<NewsResult> newsResults;
    private DrawerLayout drawerLayout;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar DrawerLayout e NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Configurar o botão de hambúrguer (toggle)
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Substituir o comportamento do botão "voltar" usando OnBackPressedDispatcher
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    setEnabled(false);  // Desabilita o callback atual para permitir o comportamento padrão
                }
            }
        };

        // Adicionar o callback no OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);

        recyclerView = findViewById(R.id.rv_main_news);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout_main_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar = findViewById(R.id.pb_main_news);

        progressBar.setVisibility(View.VISIBLE);

        fetchNews();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchNews();
                // Usar Handler para definir o refresh como falso após 2 segundos (2000 milissegundos)
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });

    }

    private void fetchNews() {
        NewsFetcher newsFetcher = new NewsFetcher();
        String apiKey = "f38f24b84b5e00e51e9daf3ff7efe3812676d0940d06f83630f94abca914b083";

        String topicToken = "CAAqJQgKIh9DQkFTRVFvSUwyMHZNREZ0ZHpFU0JYQjBMVUpTS0FBUAE";
        String publicationToken = null;
        String sectionToken = null;
        String storyToken = null;

        newsFetcher.fetchNews(null, null, apiKey, topicToken, publicationToken, sectionToken, storyToken, new NewsCallback() {
            @Override
            public void onSuccess(List<NewsResult> newsResults) {
                progressBar.setVisibility(View.GONE);
                newsAdapter = new NewsAdapter(newsResults, MainActivity.this);
                recyclerView.setAdapter(newsAdapter);
            }

            @Override
            public void onError(Throwable exception) {
                progressBar.setVisibility(View.GONE);
                Log.e("MainActivity", "Erro ao realizar requisição à API do Google: ", exception);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.nav_populares){
            Intent intent = new Intent(MainActivity.this, GamePagerActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.nav_favoritos){
            Intent intentFavoritos = new Intent(MainActivity.this, FavoriteNewsActivity.class);
            startActivity(intentFavoritos);
        }
        if (item.getItemId() == R.id.nav_logout) {
            // Realiza o logout do Firebase
            FirebaseAuth.getInstance().signOut();

            Intent intentLogin = new Intent(MainActivity.this, LoginActivity.class);
            intentLogin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intentLogin);
            finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);  // Fecha o Drawer se estiver aberto
            } else {
                drawerLayout.openDrawer(GravityCompat.START);  // Abre o Drawer se estiver fechado
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Recarregar as notícias ou atualizar os favoritos aqui
        fetchNews();
    }

}