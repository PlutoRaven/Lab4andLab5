package com.example.lab4andlab5.model;

public class UserClient {
    private String unique_id;
    private String name;
    private String email;
    private String password;
    private static UserClient instance = null;

    protected UserClient() {
    }

    public static UserClient getInstance() {
        if (instance == null) {
            instance = new UserClient();
        }
        return instance;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
