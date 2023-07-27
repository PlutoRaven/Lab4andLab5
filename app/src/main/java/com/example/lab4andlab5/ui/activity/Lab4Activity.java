package com.example.lab4andlab5.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab4andlab5.databinding.ActivityLab4Binding;
import com.example.lab4andlab5.ui.activity.lab4.LoginActivity;
import com.example.lab4andlab5.ui.activity.lab4.RegisterActivity;

public class Lab4Activity extends AppCompatActivity {
    private ActivityLab4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLab4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab4Activity.this, LoginActivity.class));
            }
        });

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab4Activity.this, RegisterActivity.class));
            }
        });
    }
}