package com.example.lab4andlab5.ui.activity.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lab4andlab5.R;
import com.example.lab4andlab5.constant.ApiCallback;
import com.example.lab4andlab5.controller.ApiController;
import com.example.lab4andlab5.databinding.ActivityAddProductBinding;
import com.example.lab4andlab5.model.MessageProduct;
import com.example.lab4andlab5.model.Product;
import com.example.lab4andlab5.ui.activity.lab4.LoginActivity;

public class AddProductActivity extends AppCompatActivity {
    private ActivityAddProductBinding binding;
    private ApiController apiController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiController = new ApiController();

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiController.addProduct(new Product(binding.name.getText().toString(), Integer.parseInt(binding.price.getText().toString()), binding.description.getText().toString()), new ApiCallback<MessageProduct>() {
                    @Override
                    public void onSuccess(MessageProduct data) {
                        Toast.makeText(AddProductActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
                        if (data.getSuccess() == 1) {
                            finish();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Toast.makeText(AddProductActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}