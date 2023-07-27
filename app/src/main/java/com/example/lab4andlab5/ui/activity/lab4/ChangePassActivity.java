package com.example.lab4andlab5.ui.activity.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lab4andlab5.R;
import com.example.lab4andlab5.databinding.ActivityChangePassBinding;
import com.example.lab4andlab5.model.UserClient;

public class ChangePassActivity extends AppCompatActivity {
    private ActivityChangePassBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangePassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UserClient userClient = UserClient.getInstance();
        binding.name.setText("Welcome " + userClient.getName());
        binding.mail.setText(userClient.getEmail());

        binding.changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChangePassActivity.this, NewPassActivity.class));
            }
        });

        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChangePassActivity.this, LoginActivity.class));
            }
        });

        binding.resetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChangePassActivity.this, SendMailActivity.class));
            }
        });
    }
}