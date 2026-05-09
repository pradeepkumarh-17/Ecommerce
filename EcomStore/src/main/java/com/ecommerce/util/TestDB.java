package com.ecommerce.util;

import java.sql.Connection;

public class TestDB {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if (con != null) {
            System.out.println("✅ Connection SUCCESS");
        } else {
            System.out.println("❌ Connection FAILED");
        }
    }
}