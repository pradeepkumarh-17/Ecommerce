package com.ecommerce.dao.impl;

import java.sql.*;
import java.util.*;

import com.ecommerce.dao.OrderDAO;
import com.ecommerce.model.*;
import com.ecommerce.util.DBConnection;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public int placeOrder(Order order, List<OrderItem> items) {
        int orderId = 0;

        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO orders(user_id,total_amount,payment_method,order_status) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, order.getUserId());
            ps.setDouble(2, order.getTotalAmount());
            ps.setString(3, order.getPaymentMethod());
            ps.setString(4, "PENDING");

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) orderId = rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderId;
    }

    @Override public List<Order> getOrdersByUser(int userId){ return null; }
    @Override public Order getOrderById(int orderId){ return null; }
    @Override public List<OrderItem> getOrderItems(int orderId){ return null; }
    @Override public boolean updateOrderStatus(int id,String s){ return false; }
}