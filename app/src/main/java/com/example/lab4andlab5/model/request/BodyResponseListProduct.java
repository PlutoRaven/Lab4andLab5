package com.example.lab4andlab5.model.request;

import com.example.lab4andlab5.model.Product;

import java.util.List;

public class BodyResponseListProduct {
    private List<Product> products;
    private int success;

    public List<Product> getProducts() {
        return products;
    }

    public int getSuccess() {
        return success;
    }
}
