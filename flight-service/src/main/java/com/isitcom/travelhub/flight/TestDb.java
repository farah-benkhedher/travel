package com.isitcom.travelhub.flight;

import java.sql.Connection;

public class TestDb {
    public static void main(String[] args) {
        try (Connection c = AirDb.getConnection()) {
            System.out.println("✅ Connected to AIR_DB!");
        } catch (Exception e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
    }
}
