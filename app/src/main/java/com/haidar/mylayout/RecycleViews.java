package com.haidar.mylayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.haidar.mylayout.Adapter.AdapterProduct;
import com.haidar.mylayout.Model.ProductModel;

import java.util.ArrayList;

public class RecycleViews extends AppCompatActivity {

    RecyclerView rvItem;
    ArrayList<ProductModel> data;
    AdapterProduct adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        rvItem = findViewById(R.id.rvItem);

        fetchData();
    }

    private void fetchData(){
        data = new ArrayList<>();
        data.add(new ProductModel(
                R.drawable.ic_person,
                "Sepeda",
                4000000
        ));
        data.add(new ProductModel(
                R.drawable.ic_baseline_shopping_cart_24,
                "Keranjang",
                250000
        ));
        data.add(new ProductModel(
                R.drawable.ic_map,
                "Maps",
                300000
        ));


        adp = new AdapterProduct(this, data);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvItem.setLayoutManager(llm);
        rvItem.setAdapter(adp);

    }
}