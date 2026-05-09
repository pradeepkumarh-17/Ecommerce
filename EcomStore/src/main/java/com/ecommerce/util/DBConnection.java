package com.ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce_store?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // change if needed

    public static Connection getConnection() {

        try {
            // Load Driver (optional for newer versions but safe)
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            if (con != null) {
                System.out.println("✅ DB Connected");
            } else {
                System.out.println("❌ Connection returned NULL");
            }

            return con;

        } catch (Exception e) {
            System.out.println("❌ DB ERROR: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}