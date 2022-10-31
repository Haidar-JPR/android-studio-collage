package com.haidar.mylayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spProdi;
    EditText txtNim, txtUsername, txtAddress, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);
        txtNim = findViewById(R.id.txtNim);
        txtUsername = findViewById(R.id.txtUsername);
        txtAddress = findViewById(R.id.txtAddress);
        txtPass = findViewById(R.id.txtPass);
        spProdi = findViewById(R.id.spProdi);

        valueOfProdiSpinner();

        btnLogin.setOnClickListener(view ->{
            startActivity(new Intent(this, Login.class));
        });

        btnRegister.setOnClickListener(view ->{
            try {
                String nim = txtNim.getText().toString();
                String name = txtUsername.getText().toString();
                String address = txtAddress.getText().toString();
                String pass = txtPass.getText().toString();
                String prodi = spProdi.getSelectedItem().toString();

                Toast.makeText(this,
                        "NIM: "+nim+"\n"
                                +"Name: "+name+"\n"
                                +"Address: "+address+"\n"
                                +"Password: "+pass+"\n"
                                +"Program Studi: "+prodi+"\n",
                        Toast.LENGTH_LONG
                ).show();

                // Parsing Data
                ArrayList<String> data = new ArrayList<>();
                data.add(nim);
                data.add(pass);

                Intent i = new Intent(this, Login.class);
                i.putExtra("id", data);
                startActivity(i);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    private void valueOfProdiSpinner(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Sistem Informasi");
        list.add("Informatika");
        list.add("Ilmu Komunikasi");
        list.add("Ilmu Komputer");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spProdi.setAdapter(adapter);
    }
}