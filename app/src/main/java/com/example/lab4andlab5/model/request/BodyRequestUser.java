package com.example.lab4andlab5.model.request;

import com.example.lab4andlab5.model.User;

public class BodyRequestUser {
    private String operation;
    private User user;

    public BodyRequestUser(String operation, User user) {
        this.operation = operation;
        this.user = user;
    }
}
