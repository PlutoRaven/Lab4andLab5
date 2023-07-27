package com.example.lab4andlab5.ui.activity.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lab4andlab5.R;
import com.example.lab4andlab5.constant.ApiCallback;
import com.example.lab4andlab5.controller.ApiController;
import com.example.lab4andlab5.databinding.ActivityLoginBinding;
import com.example.lab4andlab5.model.ResponseUser;
import com.example.lab4andlab5.model.User;
import com.example.lab4andlab5.model.UserClient;
import com.example.lab4andlab5.model.request.BodyRequestUser;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private ApiController apiController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.email.setText("vunhat.1999@gmail.com");
        binding.password.setText("hachi");

        apiController = new ApiController();
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiController.functionUser(new BodyRequestUser("login", new User(binding.email.getText().toString(), binding.password.getText().toString())), new ApiCallback<ResponseUser>() {
                    @Override
                    public void onSuccess(ResponseUser data) {
                        Toast.makeText(LoginActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
                        if (data.getResult().equals("success")) {
                            UserClient userClient = UserClient.getInstance();
                            userClient.setEmail(data.getUser().getEmail());
                            userClient.setName(data.getUser().getName());
                            userClient.setUnique_id(data.getUser().getUnique_id());
                            startActivity(new Intent(LoginActivity.this, ChangePassActivity.class));
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}