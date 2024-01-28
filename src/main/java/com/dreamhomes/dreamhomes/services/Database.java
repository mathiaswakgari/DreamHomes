package com.dreamhomes.dreamhomes.services;

import com.dreamhomes.dreamhomes.models.Address;
import com.dreamhomes.dreamhomes.models.Home;
import com.dreamhomes.dreamhomes.models.User;

import java.sql.*;
import java.util.ArrayList;

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
                "user_profile_picture VARCHAR(255)," +
                "user_isAdmin BOOLEAN)";
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
        String query = "INSERT INTO users(user_firstname,user_lastname, user_email, user_password, user_profile_picture,user_isAdmin)" +
                " values(?, ?, ?,?,?,false)";

        try {
            System.out.println("Adding user...");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUser_firstname());
            preparedStatement.setString(2, user.getUser_lastname());
            preparedStatement.setString(3, user.getUser_email());
            preparedStatement.setString(4, user.getUser_password());
            preparedStatement.setString(5, user.getUser_profile_picture());

            preparedStatement.execute();
            isInserted = true;
            System.out.println("User successfully added.");
            return isInserted;
        } catch (SQLException e) {
            System.out.println("Error adding user. " + e.getMessage());
            return false;
        }


    }
    public int insertIntoAddress(Address address){
        Connection connection = establishConnection();
        boolean isInserted = false;

        int id = -1;

        String query = "INSERT INTO address(address_1, address_2, address_3, city, state, country, postal_code) values(?, ?, ?,?,?,?,?)";

        try {
            System.out.println("Adding address...");
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,address.getAddress1());
            preparedStatement.setString(2,address.getAddress2());
            preparedStatement.setString(3, address.getAddress3());
            preparedStatement.setString(4, address.getCity());
            preparedStatement.setString(5, address.getState());
            preparedStatement.setString(6, address.getCountry());
            preparedStatement.setInt(7, address.getPostalCode());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            

            if (resultSet.next()){
                System.out.println("ID: "+resultSet.getInt(1));
                id = resultSet.getInt(1);
            }

            isInserted = true;
            System.out.println("Address successfully added.");

        } catch (SQLException e) {
            System.out.println("Error adding address. " + e.getMessage());
        }
        return id;
    }
    public void updateAddress(Address address){
        Connection connection = establishConnection();
        String query = "UPDATE address SET address_1 = ?, address_2 = ?," +
                "address_3 = ?, city = ?, state = ?," +
                "country = ?, postal_code = ? " +
                "WHERE address_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, address.getAddress1());
            preparedStatement.setString(2, address.getAddress2());
            preparedStatement.setString(3, address.getAddress3());
            preparedStatement.setString(4, address.getCity());
            preparedStatement.setString(5, address.getState());
            preparedStatement.setString(6, address.getCountry());
            preparedStatement.setInt(7, address.getPostalCode());
            preparedStatement.setInt(8, address.getAddressId());

            preparedStatement.execute();

            System.out.println("Address updated successfully.");
        }catch (SQLException e){
            System.out.println("Error updating address.");
            throw new RuntimeException(e.getMessage());

        }
    }
    public void insertIntoHomes(Home home){
        Connection connection = establishConnection();
        boolean isInserted = false;

        String query = "INSERT INTO homes(address_id, home_price, bed_number, bath_number, home_area, home_about, year_built, home_type,home_utilities, home_category, agent_name, agent_number, main_pic,pic_1,pic_2,pic_3,pic_4,pic_5,pic_6 ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            System.out.println("Adding home...");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,home.getAddressId());
            preparedStatement.setDouble(2, home.getHomePrice());
            preparedStatement.setInt(3, home.getBedNumber());
            preparedStatement.setInt(4, home.getBathNumber());
            preparedStatement.setDouble(5, home.getHomeArea());
            preparedStatement.setString(6, home.getHomeAbout());
            preparedStatement.setInt(7, home.getYearBuilt());
            preparedStatement.setString(8, home.getHomeType());
            preparedStatement.setString(9, home.getHomeUtilities());
            preparedStatement.setString(10,home.getHomeCategory());
            preparedStatement.setString(11,home.getAgentName() );
            preparedStatement.setString(12, home.getAgentNumber());
            preparedStatement.setString(13,home.getMainPic());
            preparedStatement.setString(14,home.getPic1() );
            preparedStatement.setString(15,home.getPic2() );
            preparedStatement.setString(16,home.getPic3());
            preparedStatement.setString(17,home.getPic4() );
            preparedStatement.setString(18,home.getPic5() );
            preparedStatement.setString(19,home.getPic6() );

            preparedStatement.execute();
            isInserted = true;
            System.out.println("Home successfully added.");
        } catch (SQLException e) {
            System.out.println("Error adding home. " + e.getMessage());
        }
    }
    public void updateHome(Home home){
        Connection connection = establishConnection();
        boolean isUpdated = false;

        String query = "UPDATE homes SET home_price = ?, bed_number = ?, bath_number = ?, home_area = ?, home_about = ?," +
                " year_built = ?,home_type = ?, home_utilities = ?, home_category = ?, agent_name = ?, agent_number = ?," +
                " main_pic = ?, pic_1 = ?, pic_2 = ?, pic_3 = ?, pic_4 = ?, pic_5 = ?, pic_6 = ? where home_id = ?";

        try {
            System.out.println("Updating home...");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, home.getHomePrice());
            preparedStatement.setInt(2, home.getBedNumber());
            preparedStatement.setInt(3, home.getBathNumber());
            preparedStatement.setDouble(4, home.getHomeArea());
            preparedStatement.setString(5, home.getHomeAbout());
            preparedStatement.setInt(6, home.getYearBuilt());
            preparedStatement.setString(7, home.getHomeType());
            preparedStatement.setString(8, home.getHomeUtilities());
            preparedStatement.setString(9,home.getHomeCategory());
            preparedStatement.setString(10,home.getAgentName() );
            preparedStatement.setString(11, home.getAgentNumber());
            preparedStatement.setString(12,home.getMainPic());
            preparedStatement.setString(13,home.getPic1() );
            preparedStatement.setString(14,home.getPic2() );
            preparedStatement.setString(15,home.getPic3());
            preparedStatement.setString(16,home.getPic4() );
            preparedStatement.setString(17,home.getPic5() );
            preparedStatement.setString(18,home.getPic6() );
            preparedStatement.setInt(19, home.getHomeId());

            preparedStatement.execute();
            isUpdated = true;
            System.out.println("Home successfully updated.");
        } catch (SQLException e) {
            System.out.println("Error updating home. " + e.getMessage());
        }
    }
    public void updateHomeNoPics(Home home){
        Connection connection = establishConnection();
        boolean isUpdated = false;

        String query = "UPDATE homes SET home_price = ?, bed_number = ?, bath_number = ?, home_area = ?, home_about = ?," +
                " year_built = ?,home_type = ?, home_utilities = ?, home_category = ?, agent_name = ?, agent_number = ?" +
                "where home_id = ?";

        try {
            System.out.println("Updating home...");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, home.getHomePrice());
            preparedStatement.setInt(2, home.getBedNumber());
            preparedStatement.setInt(3, home.getBathNumber());
            preparedStatement.setDouble(4, home.getHomeArea());
            preparedStatement.setString(5, home.getHomeAbout());
            preparedStatement.setInt(6, home.getYearBuilt());
            preparedStatement.setString(7, home.getHomeType());
            preparedStatement.setString(8, home.getHomeUtilities());
            preparedStatement.setString(9,home.getHomeCategory());
            preparedStatement.setString(10,home.getAgentName() );
            preparedStatement.setString(11, home.getAgentNumber());
            preparedStatement.setInt(12,home.getHomeId());

            preparedStatement.execute();
            isUpdated = true;
            System.out.println("Home successfully updated.");
        } catch (SQLException e) {
            System.out.println("Error updating home. " + e.getMessage());
        }
    }
    public ArrayList<User> getUsers(){
        Connection connection = establishConnection();
        String query = "SELECT * FROM users";
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            User user;

            while (resultSet.next()){
                int userId = resultSet.getInt("user_id");
                String userFirstname = resultSet.getString("user_firstname");
                String userLastname = resultSet.getString("user_lastname");
                String userEmail = resultSet.getString("user_email");
                String userPassword = resultSet.getString("user_password");
                String userProfilePicture = resultSet.getString("user_profile_picture");
                boolean userIsAdmin = resultSet.getBoolean("user_isAdmin");

                user =  new User(userId, userFirstname,userLastname,userEmail,userPassword,userProfilePicture, userIsAdmin);
                users.add(user);

            }
            return users;

        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    };

    public boolean deleteUser(int id){
        Connection connection = establishConnection();
        String query = "DELETE FROM users where user_id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            return true;


        } catch (SQLException e) {
            return false;


        }
    }
    public User getUser(String email){
        Connection connection = establishConnection();
        String query = "SELECT * FROM users where user_email=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
            int userId = resultSet.findColumn("user_id");
            String userFirstname = resultSet.getString("user_firstname");
            String userLastname = resultSet.getString("user_lastname");
            String userEmail = resultSet.getString("user_email");
            String userPassword = resultSet.getString("user_password");
            String userProfilePicture = resultSet.getString("user_profile_picture");
            boolean userIsAdmin = resultSet.getBoolean("user_isAdmin");

            connection.close();
            return new User(userId, userFirstname,userLastname,userEmail,userPassword,userProfilePicture, userIsAdmin);
            }else {
                return null;
            }

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
            preparedStatement.setString(5, user.getUser_profile_picture());
            preparedStatement.setString(6, user.getUser_email());

            preparedStatement.execute();

            System.out.println("User updated successfully.");
        }catch (SQLException e){
            System.out.println("Error updating user.");
            throw new RuntimeException(e.getMessage());

        }
    }
    public ArrayList<Home> getHomes(){
        Connection connection = establishConnection();
        String query = "SELECT * FROM homes";
        ArrayList<Home> homes = new ArrayList<Home>();
        Home home;

        try {
           Statement statement = connection.prepareStatement(query);
           ResultSet resultSet = statement.executeQuery(query);
           while (resultSet.next()){
               int homeId = resultSet.getInt("home_id");
               int addressId = resultSet.getInt("address_id");
               double homePrice = resultSet.getDouble("home_price");
               int bedNumber = resultSet.getInt("bed_number");
               int bathNumber = resultSet.getInt("bath_number");
               double homeArea = resultSet.getDouble("home_area");
               String homeAbout = resultSet.getString("home_about");
               int yearBuilt = resultSet.getInt("year_built");
               String homeType = resultSet.getString("home_type");
               String homeUtilities = resultSet.getString("home_utilities");
               String homeCategory = resultSet.getString("home_category");
               String agentName = resultSet.getString("agent_name");
               String agentNumber = resultSet.getString("agent_number");
               String mainPic = resultSet.getString("main_pic");
               String pic1 = resultSet.getString("pic_1");
               String pic2 = resultSet.getString("pic_2");
               String pic3 = resultSet.getString("pic_3");
               String pic4 = resultSet.getString("pic_4");
               String pic5 = resultSet.getString("pic_5");
               String pic6 = resultSet.getString("pic_6");
               
               home = new Home(homeId,addressId,homePrice,bedNumber,bathNumber,homeArea,homeAbout,yearBuilt, homeType,homeUtilities,homeCategory,agentName,agentNumber,mainPic,pic1,pic2,pic3,pic4,pic5,pic6);
               homes.add(home);
           }
           return homes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean deleteHome(int id){
        Connection connection = establishConnection();
        String query = "DELETE FROM homes where home_id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            return true;


        } catch (SQLException e) {
            return false;
        }
    }
    public ArrayList<Home> getHomesWithAddress(){
        Connection connection = establishConnection();
        ArrayList<Home> homes = new ArrayList<Home>();
        Home home;
        Address address;
        String query = "SELECT * FROM homes INNER JOIN dreamhomes.address a on homes.address_id = a.address_id";
        try {
            Statement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int homeId = resultSet.getInt("home_id");
                int addressId = resultSet.getInt("address_id");
                double homePrice = resultSet.getDouble("home_price");
                int bedNumber = resultSet.getInt("bed_number");
                int bathNumber = resultSet.getInt("bath_number");
                double homeArea = resultSet.getDouble("home_area");
                String homeAbout = resultSet.getString("home_about");
                int yearBuilt = resultSet.getInt("year_built");
                String homeType = resultSet.getString("home_type");
                String homeUtilities = resultSet.getString("home_utilities");
                String homeCategory = resultSet.getString("home_category");
                String agentName = resultSet.getString("agent_name");
                String agentNumber = resultSet.getString("agent_number");
                String mainPic = resultSet.getString("main_pic");
                String pic1 = resultSet.getString("pic_1");
                String pic2 = resultSet.getString("pic_2");
                String pic3 = resultSet.getString("pic_3");
                String pic4 = resultSet.getString("pic_4");
                String pic5 = resultSet.getString("pic_5");
                String pic6 = resultSet.getString("pic_6");
                String address1 = resultSet.getString("address_1");
                String address2 = resultSet.getString("address_2");
                String address3 = resultSet.getString("address_3");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String country = resultSet.getString("country");
                int postalCode = resultSet.getInt("postal_code");

                address = new Address(addressId, address1,address2,address3,city,state,country,postalCode);
                home = new Home(homeId,addressId,homePrice,bedNumber,bathNumber,homeArea,homeAbout,yearBuilt, homeType,homeUtilities,homeCategory,agentName,agentNumber,mainPic,pic1,pic2,pic3,pic4,pic5,pic6,address);
                homes.add(home);

            }
            return homes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Home> getHomesWithAddress(String prop, String value ){
        ArrayList<Home> homes= new ArrayList<Home>();
        Home home;
        Address address;
        Connection connection = establishConnection();
        String query = "SELECT * FROM homes INNER JOIN" +
                " dreamhomes.address a on homes.address_id = a.address_id WHERE " + prop + " LIKE '%" + value + "%'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int homeId = resultSet.getInt("home_id");
                int addressId = resultSet.getInt("address_id");
                double homePrice = resultSet.getDouble("home_price");
                int bedNumber = resultSet.getInt("bed_number");
                int bathNumber = resultSet.getInt("bath_number");
                double homeArea = resultSet.getDouble("home_area");
                String homeAbout = resultSet.getString("home_about");
                int yearBuilt = resultSet.getInt("year_built");
                String homeType = resultSet.getString("home_type");
                String homeUtilities = resultSet.getString("home_utilities");
                String homeCategory = resultSet.getString("home_category");
                String agentName = resultSet.getString("agent_name");
                String agentNumber = resultSet.getString("agent_number");
                String mainPic = resultSet.getString("main_pic");
                String pic1 = resultSet.getString("pic_1");
                String pic2 = resultSet.getString("pic_2");
                String pic3 = resultSet.getString("pic_3");
                String pic4 = resultSet.getString("pic_4");
                String pic5 = resultSet.getString("pic_5");
                String pic6 = resultSet.getString("pic_6");
                String address1 = resultSet.getString("address_1");
                String address2 = resultSet.getString("address_2");
                String address3 = resultSet.getString("address_3");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String country = resultSet.getString("country");
                int postalCode = resultSet.getInt("postal_code");

                address = new Address(addressId, address1,address2,address3,city,state,country,postalCode);
                home = new Home(homeId,addressId,homePrice,bedNumber,bathNumber,homeArea,homeAbout,yearBuilt, homeType,homeUtilities,homeCategory,agentName,agentNumber,mainPic,pic1,pic2,pic3,pic4,pic5,pic6,address);
                homes.add(home);
            }
            return homes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Home> getHomesWithAddress(String prop, String prop2, String value , String value2){
        ArrayList<Home> homes= new ArrayList<Home>();
        Home home;
        Address address;
        Connection connection = establishConnection();
        String query = "SELECT * FROM homes INNER JOIN" +
                " dreamhomes.address a on homes.address_id = a.address_id WHERE " + prop + "=" +
                " '" + value + "' " + "AND " + prop2 + " LIKE '%" + value2 + "%'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int homeId = resultSet.getInt("home_id");
                int addressId = resultSet.getInt("address_id");
                double homePrice = resultSet.getDouble("home_price");
                int bedNumber = resultSet.getInt("bed_number");
                int bathNumber = resultSet.getInt("bath_number");
                double homeArea = resultSet.getDouble("home_area");
                String homeAbout = resultSet.getString("home_about");
                int yearBuilt = resultSet.getInt("year_built");
                String homeType = resultSet.getString("home_type");
                String homeUtilities = resultSet.getString("home_utilities");
                String homeCategory = resultSet.getString("home_category");
                String agentName = resultSet.getString("agent_name");
                String agentNumber = resultSet.getString("agent_number");
                String mainPic = resultSet.getString("main_pic");
                String pic1 = resultSet.getString("pic_1");
                String pic2 = resultSet.getString("pic_2");
                String pic3 = resultSet.getString("pic_3");
                String pic4 = resultSet.getString("pic_4");
                String pic5 = resultSet.getString("pic_5");
                String pic6 = resultSet.getString("pic_6");
                String address1 = resultSet.getString("address_1");
                String address2 = resultSet.getString("address_2");
                String address3 = resultSet.getString("address_3");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String country = resultSet.getString("country");
                int postalCode = resultSet.getInt("postal_code");

                address = new Address(addressId, address1,address2,address3,city,state,country,postalCode);
                home = new Home(homeId,addressId,homePrice,bedNumber,bathNumber,homeArea,homeAbout,yearBuilt, homeType,homeUtilities,homeCategory,agentName,agentNumber,mainPic,pic1,pic2,pic3,pic4,pic5,pic6,address);
                homes.add(home);
            }
            return homes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Address getAddress(int addressId){
        Connection connection = establishConnection();
        String query = "SELECT * FROM address where address_id=?";
        Address address = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, addressId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String address1 = resultSet.getString("address_1");
                String address2 = resultSet.getString("address_2");
                String address3 = resultSet.getString("address_3");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String country = resultSet.getString("country");
                int postalCode = resultSet.getInt("postal_code");
                address= new Address(addressId, address1,address2,address3, city,state,country,postalCode);

            }
            return address;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Home getHome(int homeId){
        Connection connection = establishConnection();
        Home home = null;
        Address address;
        String query = "SELECT * from homes inner join address a on homes.address_id = a.address_id WHERE home_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, homeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int addressId = resultSet.getInt("address_id");
                double homePrice = resultSet.getDouble("home_price");
                int bedNumber = resultSet.getInt("bed_number");
                int bathNumber = resultSet.getInt("bath_number");
                double homeArea = resultSet.getDouble("home_area");
                String homeAbout = resultSet.getString("home_about");
                int yearBuilt = resultSet.getInt("year_built");
                String homeType = resultSet.getString("home_type");
                String homeUtilities = resultSet.getString("home_utilities");
                String homeCategory = resultSet.getString("home_category");
                String agentName = resultSet.getString("agent_name");
                String agentNumber = resultSet.getString("agent_number");
                String mainPic = resultSet.getString("main_pic");
                String pic1 = resultSet.getString("pic_1");
                String pic2 = resultSet.getString("pic_2");
                String pic3 = resultSet.getString("pic_3");
                String pic4 = resultSet.getString("pic_4");
                String pic5 = resultSet.getString("pic_5");
                String pic6 = resultSet.getString("pic_6");
                String address1 = resultSet.getString("address_1");
                String address2 = resultSet.getString("address_2");
                String address3 = resultSet.getString("address_3");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String country = resultSet.getString("country");
                int postalCode = resultSet.getInt("postal_code");

                address = new Address(addressId,address1,address2,address3,city,state,country,postalCode);
                home = new Home(homeId,addressId,homePrice,bedNumber,bathNumber,homeArea,homeAbout,yearBuilt, homeType,homeUtilities,homeCategory,agentName,agentNumber,mainPic,pic1,pic2,pic3,pic4,pic5,pic6,address);
            }
                return home;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    };

    public static void main(String[] args) {
        Database database = new Database();
        database.createUsersTable();
    }


}
