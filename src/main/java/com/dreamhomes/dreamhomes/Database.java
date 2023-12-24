package com.dreamhomes.dreamhomes;

import com.dreamhomes.dreamhomes.models.User;

import javax.xml.crypto.Data;
import java.sql.*;

public class Database {
    private final String dbName = "dreamHomes";
    private final String dbUrl = "jdbc:mysql://localhost:3306/";
    private final String dbUser = "mathias";
    private final String dbPassword = "LenovoLegion5";

    public Connection establishConnection(){
        System.out.println("Establishing Connection...");
        try {
            return DriverManager.getConnection(dbUrl + dbName, dbUser, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };
    public void createDatabase(){
            try {
                Connection connection = establishConnection();
                Statement statement = connection.createStatement();
                System.out.println("Creating Database...");
                statement.execute("CREATE DATABASE " + dbName);
                System.out.println("Database created successfully.");
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
    public void createUsersTable(){
        Connection connection = establishConnection();
        String query = "CREATE TABLE users (" +
                "user_id INT AUTO_INCREMENT PRIMARY KEY," +
                "user_fullname VARCHAR(100) NOT NULL," +
                "user_email VARCHAR(100) UNIQUE NOT NULL," +
                "user_password VARCHAR(100) NOT NULL)";
        try {
            System.out.println("Creating Table...");
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("'users' Table created successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean insertIntoUsers(User user){
        Connection connection = establishConnection();
        boolean isInserted = false;
        String query = "INSERT INTO users(user_fullname, user_email, user_password) values(?, ?, ?)";

        try {
            System.out.println("Adding user...");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUser_fullname());
            preparedStatement.setString(2, user.getUser_email());
            preparedStatement.setString(3, user.getUser_password());

            preparedStatement.execute();
            isInserted = true;
            System.out.println("User successfully added.");
            return isInserted;
        } catch (SQLException e) {
            System.out.println("Error adding user. " + e.getMessage());
            return false;
        }


    }
    public ResultSet getUser(String email){
        Connection connection = establishConnection();
        String query = "SELECT * FROM users where user_email=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
