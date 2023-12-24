package com.dreamhomes.dreamhomes;

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

    public void insertIntoUsers(String fullName, String email, String password){
        Connection connection = establishConnection();
        String query = "INSERT INTO users(user_fullname, user_email, user_password) values(?, ?, ?)";

        try {
            System.out.println("Adding user...");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            preparedStatement.execute();
            System.out.println("User successfully added.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
