package br.ufc.quixada.listviewexampletodelete;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    ListView lv_comidas_ceara;
    String[] comidas = {"Baiao", "Pamonha", "Feijoada", "Buchada", "Panelada", "Sopa"};
    String[] imagensComidas = {"Baiao", "Pamonha", "Feijoada", "Buchada", "Panelada", "Sopa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_comidas_ceara = findViewById(R.id.lv_comidas);

        ListViewCustomAdapter customAdapter = new ListViewCustomAdapter(this, comidas);

        lv_comidas_ceara.setAdapter(customAdapter);


    }
}