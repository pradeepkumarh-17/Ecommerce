package com.ecommerce.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class OrderController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // For now simple success flow
        res.sendRedirect("/EcomStore/views/order/success.jsp");
    }
}