package com.ecommerce.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/wishlist")
public class WishlistController extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res)

            throws ServletException, IOException {

        RequestDispatcher rd =
                req.getRequestDispatcher(
                        "/views/user/wishlist.jsp"
                );

        rd.forward(req, res);
    }
}