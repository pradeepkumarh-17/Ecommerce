package com.ecommerce.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res)

            throws ServletException, IOException {

        HttpSession session =
                req.getSession(false);

        if(session != null){

            session.invalidate();
        }

        res.sendRedirect(
                req.getContextPath()
                + "/auth?action=login"
        );
    }
}