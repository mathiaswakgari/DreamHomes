package com.dreamhomes.dreamhomes.models;

import java.io.InputStream;
import java.sql.Blob;

public class User {
    private int user_id;
    private final String user_firstname;
    private final String user_lastname;
    private final String user_email;
    private final String user_password;
    private final String user_profile_picture;

    private boolean user_isAdmin;

    public User(int user_id,String user_firstname,String user_lastname, String user_email, String user_password, String user_profile_picture, boolean user_isAdmin){
        this.user_id = user_id;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_profile_picture = user_profile_picture;
        this.user_isAdmin = user_isAdmin;
    }

    public User(String user_firstname,String user_lastname, String user_email, String user_password,String user_profile_picture){
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_profile_picture = user_profile_picture;

    }


    public int getUser_id() {
        return user_id;
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

    public String getUser_profile_picture() {
        return user_profile_picture;
    }

    public boolean getUser_isAdmin() {
        return user_isAdmin;
    }
}
