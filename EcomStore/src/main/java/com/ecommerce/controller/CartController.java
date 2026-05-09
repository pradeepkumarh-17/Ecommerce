package com.ecommerce.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;

@WebServlet("/cart")
public class CartController extends HttpServlet {

    // ================= VIEW CART =================
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        Map<Integer, Integer> cart =
                (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
        }

        req.setAttribute("cartItems", cart);

        RequestDispatcher rd = req.getRequestDispatcher("views/cart/cart.jsp");
        rd.forward(req, res);
    }

    // ================= ADD TO CART =================
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int productId = Integer.parseInt(req.getParameter("productId"));

        HttpSession session = req.getSession();

        Map<Integer, Integer> cart =
                (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
        }

        // 👉 Increase quantity
        cart.put(productId, cart.getOrDefault(productId, 0) + 1);

        session.setAttribute("cart", cart);

        System.out.println("Cart Updated: " + cart);

        res.sendRedirect(req.getContextPath() + "/product");
    }
}