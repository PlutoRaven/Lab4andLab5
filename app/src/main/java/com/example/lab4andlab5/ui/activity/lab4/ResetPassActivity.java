package com.example.lab4andlab5.ui.activity.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lab4andlab5.R;
import com.example.lab4andlab5.constant.ApiCallback;
import com.example.lab4andlab5.controller.ApiController;
import com.example.lab4andlab5.databinding.ActivityResetPassBinding;
import com.example.lab4andlab5.model.ResponseUser;
import com.example.lab4andlab5.model.User;
import com.example.lab4andlab5.model.UserClient;

public class ResetPassActivity extends AppCompatActivity {
    private ActivityResetPassBinding binding;
    private ApiController apiController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResetPassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiController = new ApiController();
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiController.changePass(new User(UserClient.getInstance().getEmail(), binding.newPass.getText().toString()), new ApiCallback<ResponseUser>() {
                    @Override
                    public void onSuccess(ResponseUser data) {
                        Toast.makeText(ResetPassActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
                        if (data.getResult().equals("success")) {
                            startActivity(new Intent(ResetPassActivity.this, ChangePassActivity.class));
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Toast.makeText(ResetPassActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}