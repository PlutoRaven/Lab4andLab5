package com.example.lab4andlab5.constant;

public interface ApiCallback<T> {
    void onSuccess(T data);

    void onError(Throwable t);
}