package com.example.firebasauthenticationteste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrarActivity extends AppCompatActivity {

    Button btn_registrar;
    private FirebaseAuth mAuth;

    EditText et_email_cadastro, et_senha_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        btn_registrar = findViewById(R.id.btn_registrar);
        mAuth = FirebaseAuth.getInstance();

        et_email_cadastro = findViewById(R.id.et_email_cadastro);
        et_senha_cadastro = findViewById(R.id.et_senha_cadastro);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUsuario(et_email_cadastro.getText().toString(), et_senha_cadastro.getText().toString());
            }
        });
    }

    public void addUsuario(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                    Intent intentLogado = new Intent(RegistrarActivity.this, LoginActivity.class);
                    startActivity(intentLogado);
                } else {
                    Toast.makeText(RegistrarActivity.this, "Autenticação falhou", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}