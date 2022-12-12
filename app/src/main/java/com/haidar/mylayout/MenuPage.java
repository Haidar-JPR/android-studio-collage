package com.haidar.mylayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MenuPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        Button btn1, btn2, btn3, btn4;

        btn1 = findViewById(R.id.imgRV);
        btn2 = findViewById(R.id.imgCamera);
        btn3 = findViewById(R.id.imgWebView);
        btn4 = findViewById(R.id.imgMaps);

        btn1.setOnClickListener(view -> {
            startActivity(new Intent(this, RecycleViews.class));
        });

        btn2.setOnClickListener(view -> {
            startActivity(new Intent(this, ImagePicker.class));
        });

        btn3.setOnClickListener(view -> {
            startActivity(new Intent(this, WebViews.class));
        });

        btn4.setOnClickListener(view -> {
            startActivity(new Intent(this, Mapss.class));
        });
    }
}