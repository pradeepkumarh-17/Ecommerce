package com.ecommerce.util;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.dao.*;
import com.ecommerce.dao.impl.*;
import com.ecommerce.model.*;

public class TestDAO {

    public static void main(String[] args) {

        System.out.println("====== DAO TEST START ======\n");

        // ================= USER =================
        UserDAO userDAO = new UserDAOImpl();

        User newUser = new User();
        boolean register = userDAO.registerUser(newUser);
        System.out.println("User Register: " + register);

        User loginUser = userDAO.loginUser("testuser@gmail.com", "1234");
        if (loginUser != null) {
            System.out.println("Login SUCCESS → " + loginUser.getFullName());
        } else {
            System.out.println("Login FAILED");
        }

        // ================= PRODUCT =================
        ProductDAO productDAO = new ProductDAOImpl();

        List<Product> products = productDAO.getAllProducts();
        System.out.println("\n--- Product List ---");
        for (Product p : products) {
            System.out.println(p.getProductId() + " | " + p.getName() + " | ₹" + p.getPrice());
        }

        // ================= CART =================
        CartDAO cartDAO = new CartDAOImpl();

        boolean cartAdded = cartDAO.addToCart(1, 1, 2);
        System.out.println("\nAdd To Cart: " + cartAdded);

        // ================= ORDER =================
        OrderDAO orderDAO = new OrderDAOImpl();

        Order order = new Order();
        order.setUserId(1);
        order.setTotalAmount(1599);
        order.setPaymentMethod("COD");

        List<OrderItem> items = new ArrayList<>();

        OrderItem item1 = new OrderItem();
        item1.setProductId(1);
        item1.setQuantity(2);
        item1.setPrice(799);
        items.add(item1);

        int orderId = orderDAO.placeOrder(order, items);
        System.out.println("Order Placed ID: " + orderId);

        // ================= ADDRESS =================
        AddressDAO addressDAO = new AddressDAOImpl();

        Address address = new Address();
        address.setUserId(1);
        address.setFullAddress("123 Main Street");
        address.setCity("Bangalore");
        address.setState("Karnataka");
        address.setPincode("560001");
        address.setCountry("India");

        boolean addressAdded = addressDAO.addAddress(address);
        System.out.println("Address Added: " + addressAdded);

        System.out.println("\n====== DAO TEST END ======");
    }
}