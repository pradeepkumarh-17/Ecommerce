package com.ecommerce.dao.impl;

import java.sql.*;
import java.util.*;

import com.ecommerce.dao.CartDAO;
import com.ecommerce.model.*;
import com.ecommerce.util.DBConnection;

public class CartDAOImpl implements CartDAO {

    @Override
    public boolean addToCart(int userId, int productId, int quantity) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO cart_items(cart_id, product_id, quantity, price_at_add_time) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, getCartId(userId, con));
            ps.setInt(2, productId);
            ps.setInt(3, quantity);
            ps.setDouble(4, getProductPrice(productId, con));

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private int getCartId(int userId, Connection con) throws Exception {
        String sql = "SELECT cart_id FROM carts WHERE user_id=? AND status='ACTIVE'";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) return rs.getInt(1);

        String insert = "INSERT INTO carts(user_id,status) VALUES(?, 'ACTIVE')";
        PreparedStatement ps2 = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        ps2.setInt(1, userId);
        ps2.executeUpdate();

        ResultSet keys = ps2.getGeneratedKeys();
        if (keys.next()) return keys.getInt(1);

        return 0;
    }

    private double getProductPrice(int productId, Connection con) throws Exception {
        String sql = "SELECT price FROM products WHERE product_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, productId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) return rs.getDouble(1);
        return 0;
    }

    @Override public Cart getActiveCartByUser(int userId){ return null; }
    @Override public boolean createCart(int userId){ return false; }
    @Override public boolean updateCartItem(int id,int q){ return false; }
    @Override public boolean removeCartItem(int id){ return false; }
    @Override public List<CartItem> getCartItems(int userId){ return null; }
    @Override public boolean clearCart(int userId){ return false; }
}