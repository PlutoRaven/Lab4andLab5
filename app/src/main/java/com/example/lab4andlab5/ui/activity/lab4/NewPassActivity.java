package com.example.lab4andlab5.ui.activity.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lab4andlab5.R;
import com.example.lab4andlab5.constant.ApiCallback;
import com.example.lab4andlab5.controller.ApiController;
import com.example.lab4andlab5.databinding.ActivityNewPassBinding;
import com.example.lab4andlab5.model.ResponseUser;
import com.example.lab4andlab5.model.User;
import com.example.lab4andlab5.model.UserClient;
import com.example.lab4andlab5.model.request.BodyRequestUser;

public class NewPassActivity extends AppCompatActivity {

    private ActivityNewPassBinding binding;
    private ApiController apiController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewPassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        apiController = new ApiController();

        binding.email.setText(UserClient.getInstance().getEmail());

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiController.functionUser(new BodyRequestUser("chgPass", new User(UserClient.getInstance().getEmail(), "", binding.oldPassword.getText().toString(), binding.newPassword.getText().toString())), new ApiCallback<ResponseUser>() {
                    @Override
                    public void onSuccess(ResponseUser data) {
                        Toast.makeText(NewPassActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
                        if (data.getResult().equals("success")) {
                            finish();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Toast.makeText(NewPassActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}