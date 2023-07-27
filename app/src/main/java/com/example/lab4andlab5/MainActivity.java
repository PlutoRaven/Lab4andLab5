package com.example.lab4andlab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.lab4andlab5.databinding.ActivityMainBinding;
import com.example.lab4andlab5.ui.activity.Lab4Activity;
import com.example.lab4andlab5.ui.activity.Lab5Activity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.lab4.setOnClickListener(v->{
            startActivity(new Intent(this , Lab4Activity.class));
        });

        binding.lab5.setOnClickListener(v->{
            startActivity(new Intent(this , Lab5Activity.class));
        });
    }
}