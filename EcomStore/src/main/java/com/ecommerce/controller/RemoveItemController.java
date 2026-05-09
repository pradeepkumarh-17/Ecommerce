package com.ecommerce.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Map;

@WebServlet("/remove-item")   // 🔥 MUST HAVE
public class RemoveItemController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        System.out.println("REMOVE CONTROLLER HIT");

        int productId = Integer.parseInt(req.getParameter("id"));

        HttpSession session = req.getSession();

        Map<Integer, Integer> cart =
                (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart != null) {
            cart.remove(productId);
        }

        session.setAttribute("cart", cart);

        res.sendRedirect("/EcomStore/cart");
    }
}