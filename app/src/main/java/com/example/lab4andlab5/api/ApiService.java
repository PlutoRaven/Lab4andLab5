package com.example.lab4andlab5.api;

import com.example.lab4andlab5.model.MessageProduct;
import com.example.lab4andlab5.model.Otp;
import com.example.lab4andlab5.model.Product;
import com.example.lab4andlab5.model.ResponseUser;
import com.example.lab4andlab5.model.User;
import com.example.lab4andlab5.model.request.BodyRequestUser;
import com.example.lab4andlab5.model.request.BodyResponseListProduct;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @POST("auth")
    Call<ResponseUser> functionUser(@Body BodyRequestUser bodyRequestUser);

    @POST("auth/verifyOTP")
    Call<ResponseUser> verifyOTP(@Body Otp otp);

    @PATCH("auth/updatePass")
    Call<ResponseUser> changePass(@Body User otp);

    @POST("product")
    Call<MessageProduct> addProduct(@Body Product product);

    @GET("product")
    Call<BodyResponseListProduct> getAllListProduct();

    @DELETE("product/{id}")
    Call<MessageProduct> deleteProduct(@Path("id") String id);

    @PATCH("product/{id}")
    Call<MessageProduct> updateProduct(@Path("id") String id, @Body Product product);


}
