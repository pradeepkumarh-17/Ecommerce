package com.ecommerce.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

import com.ecommerce.dao.UserDAO;
import com.ecommerce.dao.impl.UserDAOImpl;

import com.ecommerce.model.User;

@WebServlet("/auth")
public class AuthController extends HttpServlet {

    // =========================================
    // GET REQUEST
    // =========================================

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res)

            throws ServletException, IOException {

        String action =
                req.getParameter("action");

        // LOGIN PAGE
        if(action == null
                || "login".equals(action)) {

            RequestDispatcher rd =
                    req.getRequestDispatcher(
                            "/views/auth/login.jsp"
                    );

            rd.forward(req, res);
        }

        // REGISTER PAGE
        else if("register".equals(action)) {

            RequestDispatcher rd =
                    req.getRequestDispatcher(
                            "/views/auth/register.jsp"
                    );

            rd.forward(req, res);
        }
    }

    // =========================================
    // POST REQUEST
    // =========================================

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res)

            throws ServletException, IOException {

        String action =
                req.getParameter("action");

        UserDAO dao =
                new UserDAOImpl();

        // =====================================
        // REGISTER
        // =====================================

        if("register".equals(action)) {

            String name =
                    req.getParameter("name");

            String email =
                    req.getParameter("email");

            String phone =
                    req.getParameter("phone");

            String password =
                    req.getParameter("password");

            User user =
                    new User();

            user.setFullName(name);

            user.setEmail(email);

            user.setPhone(phone);

            user.setPassword(password);

            boolean success =
                    dao.registerUser(user);

            // SUCCESS
            if(success) {

                res.sendRedirect(
                        req.getContextPath()
                        + "/auth?action=login"
                );

            }

            // FAILURE
            else {

                res.sendRedirect(
                        req.getContextPath()
                        + "/auth?action=register&error=true"
                );
            }
        }

        // =====================================
        // LOGIN
        // =====================================

        else if("login".equals(action)) {

            String email =
                    req.getParameter("email");

            String password =
                    req.getParameter("password");

            User user =
                    dao.loginUser(email, password);

            // SUCCESS
            if(user != null) {

                HttpSession session =
                        req.getSession();

                session.setAttribute(
                        "user",
                        user
                );

                session.setAttribute(
                        "userName",
                        user.getFullName()
                );

                res.sendRedirect(
                        req.getContextPath()
                        + "/views/user/home.jsp"
                );
            }

            // FAILURE
            else {

                res.sendRedirect(
                        req.getContextPath()
                        + "/auth?action=login&error=true"
                );
            }
        }
    }
}