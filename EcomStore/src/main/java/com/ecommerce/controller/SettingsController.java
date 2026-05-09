package com.ecommerce.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/settings")
public class SettingsController extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res)

            throws ServletException, IOException {

        RequestDispatcher rd =
                req.getRequestDispatcher(
                        "/views/user/settings.jsp"
                );

        rd.forward(req, res);
    }
}