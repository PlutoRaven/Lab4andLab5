package com.example.lab4andlab5.model;

public class User {
    private String unique_id;
    private String name;
    private String email;
    private String password;

    private String new_password;
    private String old_password;

    public User(String email) {
        this.email = email;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public User(String email, String password, String new_password, String old_password) {
        this.email = email;
        this.password = password;
        this.new_password = new_password;
        this.old_password = old_password;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
