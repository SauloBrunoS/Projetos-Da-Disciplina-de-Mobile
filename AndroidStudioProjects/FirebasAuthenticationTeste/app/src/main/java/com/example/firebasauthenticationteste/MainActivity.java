package com.example.firebasauthenticationteste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    EditText et_email, et_senha;

    Button btn_ir_para_registro, btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ir_para_registro = findViewById(R.id.btn_ir_para_registro);
        btn_login = findViewById(R.id.btn_login);

        et_email = findViewById(R.id.et_email);
        et_senha = findViewById(R.id.et_senha);

        mAuth = FirebaseAuth.getInstance();

        btn_ir_para_registro.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    public void signInUsuario(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                    Intent intentLogin = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intentLogin);
                } else {
                    Toast.makeText(MainActivity.this, "Usuário ou senha inválida", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == btn_login) {
            signInUsuario(et_email.getText().toString(), et_senha.getText().toString());
        }
        if(v == btn_ir_para_registro) {
            Log.d("sid-tag", "aqui --------");
            Intent intentCadastro = new Intent(MainActivity.this, RegistrarActivity.class);
            startActivity(intentCadastro);
        }
    }
}