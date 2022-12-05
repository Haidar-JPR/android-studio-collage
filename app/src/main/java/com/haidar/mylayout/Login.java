package com.haidar.mylayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    String name, pass;
    EditText txtNim, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnLogin = findViewById(R.id.btnLogin);
        txtNim = findViewById(R.id.txtNim);
        txtPass = findViewById(R.id.txtPass);

        btnRegister.setOnClickListener(view ->{
            startActivity(new Intent(this, MainActivity.class));
        });

        btnLogin.setOnClickListener(view -> {
//            String nim = txtNim.getText().toString();
//            String pass = txtPass.getText().toString();
//
//            ArrayList<String> data = (ArrayList<String>) getIntent().getSerializableExtra("id");
//
//            String nimExtra = data.get(0);
//            String passExtra = data.get(1);
//            String nameExtra = data.get(2);

//            if(nim.isEmpty() || pass.isEmpty()){
//                Toast.makeText(this, "Nama atau password tidak boleh kosong",
//                        Toast.LENGTH_LONG
//                ).show();
//            }else if(nim.equals(nimExtra) && pass.equals(passExtra)){
//                Toast.makeText(this, "Selamat Datang "+nameExtra,
//                        Toast.LENGTH_SHORT
//                ).show();

                Intent i = new Intent(this, MenuPage.class);
//                i.putExtra("nim", nim);
                startActivity(i);
//
//            }else{
//                Toast.makeText(this, "Nama atau password salah",
//                        Toast.LENGTH_SHORT
//                ).show();
//            }
        });
    }
}