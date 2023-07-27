package com.example.lab4andlab5.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lab4andlab5.R;
import com.example.lab4andlab5.databinding.ActivityLab5Binding;
import com.example.lab4andlab5.ui.activity.lab5.AddProductActivity;
import com.example.lab4andlab5.ui.activity.lab5.AllListProductActivity;

public class Lab5Activity extends AppCompatActivity {

    private ActivityLab5Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLab5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab5Activity.this, AddProductActivity.class));
            }
        });

        binding.allList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab5Activity.this, AllListProductActivity.class));
            }
        });
    }
}