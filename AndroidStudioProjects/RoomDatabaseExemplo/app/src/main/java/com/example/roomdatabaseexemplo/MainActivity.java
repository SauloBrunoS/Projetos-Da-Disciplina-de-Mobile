package com.example.roomdatabaseexemplo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatabaseexemplo.RecyclerView.PessoaArrayAdapter;
import com.example.roomdatabaseexemplo.Dao.PessoaDao;
import com.example.roomdatabaseexemplo.Database.AppDatabase;
import com.example.roomdatabaseexemplo.RecyclerView.Item;
import com.example.roomdatabaseexemplo.model.Pessoa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RecyclerView rv_pessoas;

    FloatingActionButton fab_add;

    PessoaArrayAdapter pessoaArrayAdapter;

    PessoaDao pessoaDao;

    List<Pessoa> pessoaList;

    ArrayList<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_add = findViewById(R.id.fab_add);
        fab_add.setOnClickListener(this);

        pessoaDao = initiateDatabase();
        populateFromDatabase();
        recyclerViewStuff();
        swipeToDelete();

    }

    @NonNull
    private PessoaDao initiateDatabase() {
        AppDatabase appDatabase = Room.databaseBuilder(this,
                        AppDatabase.class,
                        "db_pessoas_2")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        return appDatabase.pessoaDao();
    }

    private void populateFromDatabase() {
        pessoaList = pessoaDao.getAllPessoas();
        itemList = new ArrayList<>();

        for (Pessoa p: pessoaList) {
            Item item = new Item(p.getNome(), p.getCurso(), p.getIdade());
            itemList.add(item);
        }
    }

    private void recyclerViewStuff() {
        rv_pessoas = findViewById(R.id.rv_pessoas);

        pessoaArrayAdapter = new PessoaArrayAdapter(R.layout.item_layout, itemList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rv_pessoas.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                ((LinearLayoutManager) layoutManager).getOrientation());

        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.custom_divider);
        if (dividerDrawable != null) {
            dividerItemDecoration.setDrawable(dividerDrawable);
        }

        rv_pessoas.addItemDecoration(dividerItemDecoration);

        rv_pessoas.setAdapter(pessoaArrayAdapter);

    }

    private void swipeToDelete() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                try {
                    int position = viewHolder.getAdapterPosition();
                    Pessoa pessoaToDelete = pessoaList.get(position);
                    pessoaDao.delete(pessoaToDelete);
                    pessoaList.remove(position);
                    itemList.remove(position);
                    pessoaArrayAdapter.notifyItemRemoved(position);
                    pessoaArrayAdapter.notifyItemRangeChanged(position, itemList.size());
                    Toast.makeText(MainActivity.this, pessoaToDelete.getNome() +" removida com sucesso!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Ocorreu um erro ao remover a pessoa!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        itemTouchHelper.attachToRecyclerView(rv_pessoas);
    }

    @Override
    public void onClick(View v) {
        if(v == fab_add) {
            try {
                EditText et_nome, et_curso, et_idade;

                et_nome = findViewById(R.id.et_nome);
                et_curso = findViewById(R.id.et_curso);
                et_idade = findViewById(R.id.et_idade);

                String nome = et_nome.getText().toString();
                String curso = et_curso.getText().toString();

                if (et_idade.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Insira idade!", Toast.LENGTH_SHORT).show();
                    return;
                }
                int idade = Integer.parseInt(et_idade.getText().toString());

                if (nome.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Insira nome!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (curso.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Insira curso!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Pessoa novaPessoa = new Pessoa(nome, curso, idade);

                pessoaDao.insertAll(novaPessoa);

                pessoaList.add(novaPessoa);

                Item novoItem = new Item(novaPessoa.getNome(), novaPessoa.getCurso(), novaPessoa.getIdade());

                itemList.add(novoItem);

                pessoaArrayAdapter.notifyItemInserted(itemList.size());

                Toast.makeText(MainActivity.this, novaPessoa.getNome() + " Adicionado!", Toast.LENGTH_SHORT).show();

                et_nome.setText("");
                et_curso.setText("");
                et_idade.setText("");
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Idade inválida! Por favor, insira um número.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Ocorreu um erro ao adicionar a pessoa!", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }
}