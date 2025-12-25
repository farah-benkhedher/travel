package com.isitcom.travelhub.flight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AirDb {

    private static final String URL = "jdbc:mysql://localhost:3306/air_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = ""; // XAMPP default

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
