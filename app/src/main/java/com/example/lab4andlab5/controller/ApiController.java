package com.example.lab4andlab5.controller;

import com.example.lab4andlab5.api.ApiService;
import com.example.lab4andlab5.constant.ApiCallback;
import com.example.lab4andlab5.constant.RetrofitRequest;
import com.example.lab4andlab5.model.MessageProduct;
import com.example.lab4andlab5.model.Otp;
import com.example.lab4andlab5.model.Product;
import com.example.lab4andlab5.model.ResponseUser;
import com.example.lab4andlab5.model.User;
import com.example.lab4andlab5.model.request.BodyRequestUser;
import com.example.lab4andlab5.model.request.BodyResponseListProduct;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiController {
    private ApiService apiService;

    public ApiController() {
        apiService = RetrofitRequest.getRetrofitInstance().create(ApiService.class);
    }

    public void functionUser(BodyRequestUser bodyRequestUser, final ApiCallback<ResponseUser> callback) {
        apiService.functionUser(bodyRequestUser).enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(new Exception("Failed to fetch data"));
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void verifyOTP(Otp to, final ApiCallback<ResponseUser> callback) {
        apiService.verifyOTP(to).enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(new Exception("Failed to fetch data"));
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void changePass(User user, final ApiCallback<ResponseUser> callback) {
        apiService.changePass(user).enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(new Exception("Failed to fetch data"));
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void addProduct(Product product, final ApiCallback<MessageProduct> callback) {
        apiService.addProduct(product).enqueue(new Callback<MessageProduct>() {
            @Override
            public void onResponse(Call<MessageProduct> call, Response<MessageProduct> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(new Exception("Failed to fetch data"));
                }
            }

            @Override
            public void onFailure(Call<MessageProduct> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void deleteProduct(String id, final ApiCallback<MessageProduct> callback) {
        apiService.deleteProduct(id).enqueue(new Callback<MessageProduct>() {
            @Override
            public void onResponse(Call<MessageProduct> call, Response<MessageProduct> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(new Exception("Failed to fetch data"));
                }
            }

            @Override
            public void onFailure(Call<MessageProduct> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void updateProduct(String id, Product product, final ApiCallback<MessageProduct> callback) {
        apiService.updateProduct(id, product).enqueue(new Callback<MessageProduct>() {
            @Override
            public void onResponse(Call<MessageProduct> call, Response<MessageProduct> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(new Exception("Failed to fetch data"));
                }
            }

            @Override
            public void onFailure(Call<MessageProduct> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void getAllListProduct(final ApiCallback<BodyResponseListProduct> callback) {
        apiService.getAllListProduct().enqueue(new Callback<BodyResponseListProduct>() {
            @Override
            public void onResponse(Call<BodyResponseListProduct> call, Response<BodyResponseListProduct> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(new Exception("Failed to fetch data"));
                }
            }

            @Override
            public void onFailure(Call<BodyResponseListProduct> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
