package com.example.lab4andlab5.ui.activity.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lab4andlab5.R;
import com.example.lab4andlab5.constant.ApiCallback;
import com.example.lab4andlab5.controller.ApiController;
import com.example.lab4andlab5.databinding.ActivityRegisterBinding;
import com.example.lab4andlab5.model.ResponseUser;
import com.example.lab4andlab5.model.User;
import com.example.lab4andlab5.model.UserClient;
import com.example.lab4andlab5.model.request.BodyRequestUser;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private ApiController apiController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        apiController = new ApiController();

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiController.functionUser(new BodyRequestUser("register", new User(binding.name.getText().toString(), binding.email.getText().toString(), binding.password.getText().toString())), new ApiCallback<ResponseUser>() {
                    @Override
                    public void onSuccess(ResponseUser data) {
                        Toast.makeText(RegisterActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
                        if (data.getResult().equals("success")) {
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }
}