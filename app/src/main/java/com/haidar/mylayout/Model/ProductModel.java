package com.haidar.mylayout.Model;

public class ProductModel {
    int img;
    String name;
    int price;

    public ProductModel(int img, String name, int price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
