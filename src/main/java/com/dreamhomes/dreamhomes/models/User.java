package com.dreamhomes.dreamhomes.models;

import java.io.InputStream;

public class User {
    private final String user_firstname;
    private final String user_lastname;
    private final String user_email;
    private final String user_password;
    private InputStream user_profile_picture;

    public User(String user_firstname,String user_lastname, String user_email, String user_password, InputStream user_profile_picture){
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_profile_picture = user_profile_picture;
    }

    public User(String user_firstname,String user_lastname, String user_email, String user_password){
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public InputStream getUser_profile_picture() {
        return user_profile_picture;
    }


}
