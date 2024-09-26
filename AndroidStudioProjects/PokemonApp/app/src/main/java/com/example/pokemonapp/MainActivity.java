package com.example.pokemonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

        ViewPager2 viewpager;
        MyViewPagerAdapter myAdapter;
        TabLayout tabLayout;
        String[] menu = {"Informações Gerais", "Estatísticas", "Habilidades e Movimentos"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            tabLayout = findViewById(R.id.tablayout);
            myAdapter = new MyViewPagerAdapter(
                    getSupportFragmentManager(),
                    getLifecycle()
            );
            // Adding Fragments to the list in the Adapter Class
            myAdapter.addFragment(new InformacoesGeraisFragment());
            myAdapter.addFragment(new EstatisticasFragment());
            myAdapter.addFragment(new HabilidadesEMovimentosFragment());
            // Set the orientation in ViewPager2
            viewpager = findViewById(R.id.viewPager2);
            viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
            // Connecting the Adapter with ViewPager2
            viewpager.setAdapter(myAdapter);
            // Connecting TabLayout with ViewPager
            new TabLayoutMediator(
                    tabLayout,
                    viewpager,
                    new TabLayoutMediator.TabConfigurationStrategy() {
                        @Override
                        public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                            tab.setText(menu[position]);
                        }
                    }
            ).attach();
            
            Pokemon pokemon = new Pokemon();
            pokemon.loadFromPreferences(this); // Carrega as informações do Pokémon

            if (pokemon.getNome().isEmpty()) {
                pokemon.setImagem(R.drawable.pikachu);
                pokemon.setNome("Pikachu");
                pokemon.setNumeroPokedex(25);
                pokemon.setTipo("Elétrico");
                pokemon.setDescrição("Pikachu, um Pokémon do tipo elétrico, é a forma evoluída de Pichu.");
                pokemon.setHp(35);
                pokemon.setAtaque(55);
                pokemon.setDefesa(40);
                pokemon.setAtaqueEspecial(50);
                pokemon.setDefesaEspecial(50);
                pokemon.setVelocidade(90);
                pokemon.setHabilidades(new String[]{"Estática", "Paratempo"});
                pokemon.setMovimentos(new String[]{"Choque do Trovão", "Cauda de Ferro", "Ataque Rápido", "Investida Trovão"});
                pokemon.saveToPreferences(this);
            }

        }
    }

