package com.haidar.mylayout.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haidar.mylayout.Model.ProductModel;
import com.haidar.mylayout.R;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ProductViewHolder> {

    private final Context ctx;
    private final ArrayList<ProductModel> dataProduct;

    public AdapterProduct(Context ctx, ArrayList<ProductModel> dataBarang) {
        this.ctx = ctx;
        this.dataProduct = dataBarang;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.list_barang, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductModel pm =dataProduct.get(position);

        holder.nameProduct.setText(pm.getName());
        holder.imgProduct.setImageResource(pm.getImg());
        holder.priceProduct.setText(String.valueOf(pm.getPrice()));
        holder.imgCart.setImageResource(R.drawable.ic_baseline_shopping_cart_24);
    }

    @Override
    public int getItemCount() {
        return dataProduct.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView imgProduct;
        ImageView imgCart;
        TextView nameProduct;
        TextView priceProduct;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.imgBarang);
            imgCart = itemView.findViewById(R.id.imgKeranjang);
            nameProduct = itemView.findViewById(R.id.nameProduct);
            priceProduct = itemView.findViewById(R.id.priceProduct);
        }
    }

}

