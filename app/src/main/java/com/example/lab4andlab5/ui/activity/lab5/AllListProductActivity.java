package com.example.lab4andlab5.ui.activity.lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.lab4andlab5.R;
import com.example.lab4andlab5.constant.ApiCallback;
import com.example.lab4andlab5.controller.ApiController;
import com.example.lab4andlab5.databinding.ActivityAllListProductBinding;
import com.example.lab4andlab5.model.Product;
import com.example.lab4andlab5.model.request.BodyResponseListProduct;
import com.example.lab4andlab5.ui.adapter.ProductAdapter;

public class AllListProductActivity extends AppCompatActivity {
    private ActivityAllListProductBinding binding;
    private ApiController apiController;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllListProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiController = new ApiController();
        binding.listProduct.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void onResume() {
        super.onResume();
        apiController.getAllListProduct(new ApiCallback<BodyResponseListProduct>() {
            @Override
            public void onSuccess(BodyResponseListProduct data) {
                if (data.getSuccess() == 1) {
                    productAdapter = new ProductAdapter(data.getProducts(), new ProductAdapter.Callback() {
                        @Override
                        public void onClick(Product product) {
                            Intent intent = new Intent(AllListProductActivity.this, DetailProductActivity.class);
                            intent.putExtra("product", product);
                            startActivity(intent);
                        }
                    });
                    binding.listProduct.setAdapter(productAdapter);
                }
            }

            @Override
            public void onError(Throwable t) {

            }
        });
    }
}