package com.dreamhomes.dreamhomes;

import com.dreamhomes.dreamhomes.models.User;

import java.sql.*;

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
                "home_utilities VARCHAR(100)," +
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
    public void insertIntoAddress(){
        Connection connection = establishConnection();
        boolean isInserted = false;

        String query = "INSERT INTO address(address_1, address_2, address_3, city, state, country, postal_code) values(?, ?, ?,?,?,?,?)";

        try {
            System.out.println("Adding address...");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"President Obama");
            preparedStatement.setString(2, "1600 Pennsylvania Avenue NW");
            preparedStatement.setString(3, String.valueOf(NULL));
            preparedStatement.setString(4, "Washington");
            preparedStatement.setString(5, "DC");
            preparedStatement.setString(6, "US");
            preparedStatement.setString(7, "20500");

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
            preparedStatement.setInt(1,1);
            preparedStatement.setInt(2, 29331952);
            preparedStatement.setInt(3, 4);
            preparedStatement.setInt(4, 3);
            preparedStatement.setInt(5, 214);
            preparedStatement.setString(6, "Welcome to your future home in Dacono, CO! This splendid 4-bedroom, 3-bathroom 2-story house is a perfect blend of modern comfort and thoughtful design. As you enter, you'll be welcomed by an inviting open floor plan, showcasing the spaciousness and versatility of the living spaces. The eat-in kitchen is a focal point, boasting a kitchen island, pantry, and the convenience of a modern lifestyle. Relax and rejuvenate in the luxurious five-piece master bath, a private oasis within your home. The master suite is designed for tranquility and comfort, offering a retreat from the hustle and bustle of daily life. Imagine entertaining or simply enjoying meals on your new back patio. With mountain views as your backdrop, this outdoor space becomes a picturesque retreat. The perfect spot to unwind after a long day and create lasting memories with friends and family. Central air cooling ensures your comfort year-round, and ceiling fans add an extra touch of circulation and freshness. The new back patio extends your living space outdoors, creating a seamless connection between indoor and outdoor living. Roof replaced in 2018 with class 4 shingles as well as a new hot water heater in 2021! Exciting developments are on the horizon with a new King Soopers breaking ground in 2024, offering convenience for your shopping needs. This property is strategically located, providing easy access to schools and a short commute to I-25, making your daily routine more efficient. This home is not just a residence; it's an opportunity to embrace the Colorado lifestyle. With thoughtful features, mountain views, and the promise of nearby amenities, this property in Dacono is a gem waiting to be discovered. Don't miss the chance to make it your own. Schedule a showing today!");
            preparedStatement.setInt(7, 2015);
            preparedStatement.setString(8, "Single Family");
            preparedStatement.setString(9, "Forced Air Heating and Cooling System\n" +
                    "High Speed Internet\n" +
                    "Cable TV Available");
            preparedStatement.setString(10,"sell" );
            preparedStatement.setString(11,"Holly Vejrostek" );
            preparedStatement.setString(12, "(720) 902-6509");
            preparedStatement.setString(13,"https://images.homes.com/listings/215/2200550253-128155561/5625-westview-cir-dacono-co-primaryphoto.jpg" );
            preparedStatement.setString(14,"https://images.homes.com/listings/115/9247170253-128155561/5625-westview-cir-dacono-co-buildingphoto-2.jpg" );
            preparedStatement.setString(15,"https://images.homes.com/listings/115/1347170253-128155561/5625-westview-cir-dacono-co-buildingphoto-3.jpg" );
            preparedStatement.setString(16,"https://images.homes.com/listings/115/8573410253-128155561/5625-westview-cir-dacono-co-buildingphoto-4.jpg" );
            preparedStatement.setString(17,"https://images.homes.com/listings/115/9773410253-128155561/5625-westview-cir-dacono-co-buildingphoto-5.jpg" );
            preparedStatement.setString(18,"https://images.homes.com/listings/115/3083410253-128155561/5625-westview-cir-dacono-co-buildingphoto-6.jpg" );
            preparedStatement.setString(19,"https://images.homes.com/listings/115/1383410253-128155561/5625-westview-cir-dacono-co-buildingphoto-7.jpg" );

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

    public static void main(String[] args) {
       Database database = new Database();
       database.insertIntoHomes();
    }

}
