package com.dreamhomes.dreamhomes.services;

import com.dreamhomes.dreamhomes.models.User;

import java.sql.*;

import static java.sql.Types.BLOB;
import static java.sql.Types.NULL;

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
                "user_firstname VARCHAR(20) NOT NULL," +
                "user_lastname VARCHAR(20) NOT NULL," +
                "user_email VARCHAR(30) UNIQUE NOT NULL," +
                "user_password VARCHAR(40) NOT NULL," +
                "user_profile_picture LONGBLOB)";
        try {
            System.out.println("Creating Table...");
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("'users' Table created successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void createHomesTable(){
        Connection connection = establishConnection();
        String query = "CREATE TABLE homes (" +
                "home_id INT AUTO_INCREMENT PRIMARY KEY," +
                "address_id INT NOT NULL," +
                "home_price INT NOT NULL," +
                "bed_number INT NOT NULL," +
                "bath_number INT NOT NULL," +
                "home_area INT NOT NULL," +
                "home_about LONGTEXT," +
                "year_built INT NOT NULL," +
                "home_type VARCHAR(100) NOT NULL," +
                "home_utilities MEDIUMTEXT," +
                "home_category VARCHAR(100)," +
                "agent_name VARCHAR(100)," +
                "agent_number VARCHAR(100) NOT NULL ," +
                "main_pic VARCHAR(255) NOT NULL ," +
                "pic_1 VARCHAR(255)," +
                "pic_2 VARCHAR(255)," +
                "pic_3 VARCHAR(255)," +
                "pic_4 VARCHAR(255)," +
                "pic_5 VARCHAR(255)," +
                "pic_6 VARCHAR(255)," +
                "FOREIGN KEY (address_id) REFERENCES address(address_id))";
        try {
            System.out.println("Creating Table...");
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("'Homes' Table created successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void createAddressTable(){
        Connection connection = establishConnection();
        String query = "CREATE TABLE address (" +
                "address_id INT AUTO_INCREMENT PRIMARY KEY," +
                "address_1 VARCHAR(100)," +
                "address_2 VARCHAR(100)," +
                "address_3 VARCHAR(100)," +
                "city VARCHAR(100)," +
                "state VARCHAR(100)," +
                "country VARCHAR(100), " +
                "postal_code INT)";
        try {
            System.out.println("Creating Table...");
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("'address' Table created successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertIntoUsers(User user){
        Connection connection = establishConnection();
        boolean isInserted = false;
        String query = "INSERT INTO users(user_firstname,user_lastname, user_email, user_password, user_profile_picture)" +
                " values(?, ?, ?,?,?)";

        try {
            System.out.println("Adding user...");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUser_firstname());
            preparedStatement.setString(2, user.getUser_lastname());
            preparedStatement.setString(3, user.getUser_email());
            preparedStatement.setString(4, user.getUser_password());
            preparedStatement.setNull(5, BLOB);

            preparedStatement.execute();
            isInserted = true;
            System.out.println("User successfully added.");
            return isInserted;
        } catch (SQLException e) {
            System.out.println("Error adding user. " + e.getMessage());
            return false;
        }


    }
    public void insertIntoAddress(){
        Connection connection = establishConnection();
        boolean isInserted = false;

        String query = "INSERT INTO address(address_1, address_2, address_3, city, state, country, postal_code) values(?, ?, ?,?,?,?,?)";

        try {
            System.out.println("Adding address...");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"3463 Switchgrass St");
            preparedStatement.setNull(2,NULL );
            preparedStatement.setNull(3, NULL);
            preparedStatement.setString(4, "Dacona");
            preparedStatement.setString(5, "CO");
            preparedStatement.setString(6, "US");
            preparedStatement.setString(7, "80514");

            preparedStatement.execute();
            isInserted = true;
            System.out.println("Address successfully added.");
        } catch (SQLException e) {
            System.out.println("Error adding address. " + e.getMessage());
        }
    }
    public void insertIntoHomes(){
        Connection connection = establishConnection();
        boolean isInserted = false;

        String query = "INSERT INTO homes(address_id, home_price, bed_number, bath_number, home_area, home_about, year_built, home_type,home_utilities, home_category, agent_name, agent_number, main_pic,pic_1,pic_2,pic_3,pic_4,pic_5,pic_6 ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            System.out.println("Adding home...");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,3);
            preparedStatement.setInt(2, 33844560);
            preparedStatement.setInt(3, 3);
            preparedStatement.setInt(4, 2);
            preparedStatement.setInt(5, 165);
            preparedStatement.setString(6, "Welcome to your dream ranch home in the quaint Sweetgrass community! This stunning residence offers a blend of comfort, functionality, and timeless design. The open concept floor plan seamlessly combines the living, dining, and kitchen areas, providing an ideal space for both relaxation and entertainment. The living room features luxury vinyl plank and large windows, allowing an abundance of natural light to flood the room, creating a warm and welcoming atmosphere. Adjacent to the living area, you'll find a well-appointed kitchen with granite countertops, a giant island, and double stacked cabinets to provide ample storage for all of your culinary needs. Whether you're preparing a quick breakfast or hosting a dinner party, this kitchen will exceed your expectations. The home also offers three spacious bedrooms, each offering a peaceful sanctuary for rest and relaxation. The master suite features a generous layout, plush carpeting, walk-in closet and an en-suite bathroom. Downstairs, a full unfinished basement provides an area for endless possibilities, whether it be a home gym, extra storage space, or a future finished second floor! Outside, your backyard offers maximum privacy and is the perfect space for enjoying al fresco dining or simply unwinding in the fresh air. For car enthusiasts or those with a growing family, the two-car garage offers tons of space for parking vehicles and toys, storage, or even a workshop. This beautiful ranch home offers a blend of style, comfort, and space and you won't want to miss out! The Listing Team represents builder/seller as a Transaction Broker.");
            preparedStatement.setInt(7, 2023);
            preparedStatement.setString(8, "Single Family");
            preparedStatement.setString(9, "Forced Air Heating and Cooling System\n" +
                    "High Speed Internet\n" +
                    "Cable TV Available\n" +
                    "Natural Gas Connected\n" +
                    "Phone Available");
            preparedStatement.setString(10,"sell" );
            preparedStatement.setString(11,"Team Lassed" );
            preparedStatement.setString(12, "(833) 833-5957");
            preparedStatement.setString(13,"https://images.homes.com/listings/215/7273718153-112445561/3463-switchgrass-st-dacono-co-primaryphoto.jpg" );
            preparedStatement.setString(14,"" );
            preparedStatement.setString(15,"" );
            preparedStatement.setString(16,"" );
            preparedStatement.setString(17,"" );
            preparedStatement.setString(18,"" );
            preparedStatement.setString(19,"" );

            preparedStatement.execute();
            isInserted = true;
            System.out.println("Home successfully added.");
        } catch (SQLException e) {
            System.out.println("Error adding home. " + e.getMessage());
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
    public void updateUser(User user){
        Connection connection = establishConnection();
        String query = "UPDATE users SET user_firstname = ?, user_lastname = ?," +
                "user_email = ?, user_password = ?, user_profile_picture = ?" +
                "WHERE user_email = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUser_firstname());
            preparedStatement.setString(2, user.getUser_lastname());
            preparedStatement.setString(3, user.getUser_email());
            preparedStatement.setString(4, user.getUser_password());
            if(user.getUser_profile_picture() != null){
                preparedStatement.setBlob(5, user.getUser_profile_picture());
            }else{
                preparedStatement.setNull(5, BLOB);
            }
            preparedStatement.setString(6, user.getUser_email());

            preparedStatement.execute();

            System.out.println("User updated successfully.");
        }catch (SQLException e){
            System.out.println("Error updating user.");
            throw new RuntimeException(e.getMessage());

        }



    }
    public ResultSet getHomes(){
        Connection connection = establishConnection();
        String query = "SELECT * FROM homes";
        try {
           Statement statement = connection.prepareStatement(query);
            return statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getHomesWithAddress(){
        Connection connection = establishConnection();
        String query = "SELECT home_price,bed_number,bath_number,main_pic,address_1,state,postal_code,city,home_id FROM homes INNER JOIN dreamhomes.address a on homes.address_id = a.address_id";
        try {
            Statement statement = connection.prepareStatement(query);
            return statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getHomesWithAddress(String prop, String value ){
        Connection connection = establishConnection();
        String query = String.format("SELECT home_price,bed_number,bath_number,main_pic,address_1,state,postal_code,city,home_id FROM homes INNER JOIN" +
                " dreamhomes.address a on homes.address_id = a.address_id WHERE %s='%s'", prop,value);
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getAddress(int addressId){
        Connection connection = establishConnection();
        String query = "SELECT * FROM address where address_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, addressId);

            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getHome(int homeId){
        Connection connection = establishConnection();
        String query = "SELECT * from homes inner join address a on homes.address_id = a.address_id WHERE home_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, homeId);
            return preparedStatement.executeQuery();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    };

    public static void main(String[] args) {
        Database database = new Database();
        database.createUsersTable();
    }


}
