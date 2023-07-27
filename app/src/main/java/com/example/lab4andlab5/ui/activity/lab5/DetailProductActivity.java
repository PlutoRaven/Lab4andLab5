package com.example.lab4andlab5.ui.activity.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lab4andlab5.R;
import com.example.lab4andlab5.constant.ApiCallback;
import com.example.lab4andlab5.controller.ApiController;
import com.example.lab4andlab5.databinding.ActivityDetailProdcutBinding;
import com.example.lab4andlab5.model.MessageProduct;
import com.example.lab4andlab5.model.Product;

public class DetailProductActivity extends AppCompatActivity {

    private ActivityDetailProdcutBinding binding;
    private ApiController apiController;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailProdcutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiController = new ApiController();
        product = (Product) getIntent().getSerializableExtra("product");

        binding.description.setText(product.getDescription());
        binding.name.setText(product.getName());
        binding.price.setText(product.getPrice() + "");

        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiController.deleteProduct(product.get_id(), new ApiCallback<MessageProduct>() {
                    @Override
                    public void onSuccess(MessageProduct data) {
                        Toast.makeText(DetailProductActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
                        if (data.getSuccess() == 1) {
                            finish();
                        }
                    }   

                    @Override
                    public void onError(Throwable t) {
                        Toast.makeText(DetailProductActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiController.updateProduct(product.get_id(), new Product(binding.name.getText().toString(), Integer.parseInt(binding.price.getText().toString()), binding.description.getText().toString()), new ApiCallback<MessageProduct>() {
                    @Override
                    public void onSuccess(MessageProduct data) {
                        Toast.makeText(DetailProductActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
                        if (data.getSuccess() == 1) {
                            finish();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Toast.makeText(DetailProductActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}