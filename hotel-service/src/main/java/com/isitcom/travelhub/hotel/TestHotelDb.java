package com.isitcom.travelhub.hotel;

import java.sql.Connection;

public class TestHotelDb {
    public static void main(String[] args) {
        try (Connection c = HotelDb.getConnection()) {
            System.out.println("✅ Connected to HOTEL_DB!");
        } catch (Exception e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
    }
}
