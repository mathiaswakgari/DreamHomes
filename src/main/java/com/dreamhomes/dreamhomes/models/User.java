package com.dreamhomes.dreamhomes.models;

public class User {
    private final String user_fullname;
    private final String user_email;
    private final String user_password;

    public User(String user_fullname, String user_email, String user_password){
        this.user_email = user_email;
        this.user_fullname = user_fullname;
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public String getUser_password() {
        return user_password;
    }
}
