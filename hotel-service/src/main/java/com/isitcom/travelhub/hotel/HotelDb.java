package com.isitcom.travelhub.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HotelDb {

    private static final String URL  = "jdbc:mysql://localhost:3306/hotel_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = ""; // XAMPP default

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
