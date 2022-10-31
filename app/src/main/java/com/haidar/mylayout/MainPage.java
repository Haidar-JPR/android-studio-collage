package com.haidar.mylayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        txtLogin = findViewById(R.id.txtLogin);

        String nim2 = (String) getIntent().getSerializableExtra("nim");

        txtLogin.setText(nim2);
    }
}