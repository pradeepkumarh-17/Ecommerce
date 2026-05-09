package com.ecommerce.dao;

import java.util.List;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;

public interface OrderDAO {

    int placeOrder(Order order, List<OrderItem> items);

    List<Order> getOrdersByUser(int userId);

    Order getOrderById(int orderId);

    List<OrderItem> getOrderItems(int orderId);

    boolean updateOrderStatus(int orderId, String status);
}