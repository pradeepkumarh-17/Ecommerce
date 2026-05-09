package com.ecommerce.dao.impl;

import com.ecommerce.dao.UserDAO;
import com.ecommerce.model.User;
import com.ecommerce.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {

    // =========================================
    // REGISTER USER
    // =========================================

    @Override
    public boolean registerUser(User user) {

        String sql =
                "INSERT INTO users(full_name, email, phone, password_hash) VALUES(?,?,?,?)";

        try (Connection con =
                     DBConnection.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1,
                    user.getFullName());

            ps.setString(2,
                    user.getEmail());

            ps.setString(3,
                    user.getPhone());

            ps.setString(4,
                    user.getPassword());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // =========================================
    // LOGIN USER
    // =========================================

    @Override
    public User loginUser(
            String email,
            String password) {

        String sql =
                "SELECT * FROM users WHERE email=? AND password_hash=?";

        try (Connection con =
                     DBConnection.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, email);

            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                User user =
                        new User();

                user.setUserId(
                        rs.getInt("user_id"));

                user.setFullName(
                        rs.getString("full_name"));

                user.setEmail(
                        rs.getString("email"));

                user.setPhone(
                        rs.getString("phone"));

                user.setStatus(
                        rs.getString("status"));

                return user;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}