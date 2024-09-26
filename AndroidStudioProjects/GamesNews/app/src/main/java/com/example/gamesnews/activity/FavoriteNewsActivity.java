package com.example.gamesnews.activity;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gamesnews.R;
import com.example.gamesnews.adapter.NewsAdapter;
import com.example.gamesnews.firestore.FetchDataCallback;
import com.example.gamesnews.firestore.NewsManager;
import com.example.gamesnews.model.NewsResult;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class FavoriteNewsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private ArrayList<NewsResult> favoriteNewsList;
    private FirebaseFirestore firestore;
    private FirebaseUser currentUser;
    private DrawerLayout drawerLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_news);

        recyclerView = findViewById(R.id.rv_favorite_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        favoriteNewsList = new ArrayList<NewsResult>();
        newsAdapter = new NewsAdapter(favoriteNewsList, this);
        recyclerView.setAdapter(newsAdapter);

        progressBar = findViewById(R.id.pb_favorite_news);

        firestore = FirebaseFirestore.getInstance();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        drawerLayout = findViewById(R.id.drawer_layout_favorite_news);
        NavigationView navigationView = findViewById(R.id.nav_view_favorite_news);
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

        if (currentUser != null) {
            NewsManager newsManager = new NewsManager(FavoriteNewsActivity.this);
            fetchFavoritesFromAllCollections(newsManager);
        } else {
            Toast.makeText(this, "Usuário não autenticado.", Toast.LENGTH_SHORT).show();
        }
    }
    private void fetchFavoritesFromAllCollections(NewsManager newsManager) {
        // Limpa a lista antes de buscar novos dados
        favoriteNewsList.clear();

        progressBar.setVisibility(View.VISIBLE);

        // Busca os favoritos normais
        newsManager.fetchSavedNews(currentUser, favoriteNewsList, newsAdapter, new FetchDataCallback() {
            @Override
            public void onComplete() {
                // Quando terminar de buscar da coleção favorites
                // Busca os destaques (highlights)
                newsManager.fetchSavedHighlights(currentUser, favoriteNewsList, newsAdapter, new FetchDataCallback() {
                    @Override
                    public void onComplete() {
                        // Quando terminar de buscar os highlights
                        // Busca os stories
                        newsManager.fetchSavedStories(currentUser, favoriteNewsList, newsAdapter, new FetchDataCallback() {
                            @Override
                            public void onComplete() {
                                // Quando todos os dados estiverem carregados
                                progressBar.setVisibility(View.GONE);
                                newsAdapter.setOnFavoriteClickListener((position) -> {
                                    favoriteNewsList.remove(position);
                                    newsAdapter.notifyItemRemoved(position);
                                    newsAdapter.notifyItemRangeChanged(position, favoriteNewsList.size());
                                });
                                newsAdapter.setStoryOnFavoriteClickListener();
                            }
                        });
                    }
                });
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            Intent intentMain = new Intent(this, MainActivity.class);
            startActivity(intentMain);
        }
        if(item.getItemId() == R.id.nav_populares){
            Intent intentGamePager = new Intent(FavoriteNewsActivity.this, GamePagerActivity.class);
            startActivity(intentGamePager);
        }
        if (item.getItemId() == R.id.nav_logout) {
            // Realiza o logout do Firebase
            FirebaseAuth.getInstance().signOut();

            Intent intentLogin = new Intent(FavoriteNewsActivity.this, LoginActivity.class);
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

}