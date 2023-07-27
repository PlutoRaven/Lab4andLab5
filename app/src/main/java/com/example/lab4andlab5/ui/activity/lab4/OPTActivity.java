package com.example.lab4andlab5.ui.activity.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lab4andlab5.R;
import com.example.lab4andlab5.constant.ApiCallback;
import com.example.lab4andlab5.controller.ApiController;
import com.example.lab4andlab5.databinding.ActivityLab4Binding;
import com.example.lab4andlab5.databinding.ActivityOptactivityBinding;
import com.example.lab4andlab5.model.Otp;
import com.example.lab4andlab5.model.ResponseUser;
import com.example.lab4andlab5.model.User;
import com.example.lab4andlab5.model.UserClient;

public class OPTActivity extends AppCompatActivity {
    private ActivityOptactivityBinding binding;
    private ApiController apiController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOptactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiController = new ApiController();
        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiController.verifyOTP(new Otp(UserClient.getInstance().getEmail(), binding.otp.getText().toString()), new ApiCallback<ResponseUser>() {
                    @Override
                    public void onSuccess(ResponseUser data) {
                        Toast.makeText(OPTActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
                        if (data.getResult().equals("success")) {
                            startActivity(new Intent(OPTActivity.this, ResetPassActivity.class));
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Toast.makeText(OPTActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}