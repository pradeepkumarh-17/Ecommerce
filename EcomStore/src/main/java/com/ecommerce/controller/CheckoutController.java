package com.ecommerce.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.dao.impl.ProductDAOImpl;
import com.ecommerce.model.Product;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res)

            throws ServletException, IOException {

        HttpSession session =
                req.getSession();

        // =====================================
        // CHECK LOGIN
        // =====================================

        Object user =
                session.getAttribute("user");

        if (user == null) {

            res.sendRedirect(
                    req.getContextPath()
                    + "/auth?action=login"
            );

            return;
        }

        // =====================================
        // GET CART
        // =====================================

        Map<Integer, Integer> cart =
                (Map<Integer, Integer>)
                        session.getAttribute("cart");

        // =====================================
        // EMPTY CART CHECK
        // =====================================

        if (cart == null || cart.isEmpty()) {

            res.sendRedirect(
                    req.getContextPath()
                    + "/cart"
            );

            return;
        }

        // =====================================
        // CALCULATE TOTAL
        // =====================================

        ProductDAO dao =
                new ProductDAOImpl();

        double total = 0;

        for (Map.Entry<Integer, Integer> entry
                : cart.entrySet()) {

            Product product =
                    dao.getProductById(
                            entry.getKey()
                    );

            if (product != null) {

                total +=
                        product.getPrice()
                        * entry.getValue();
            }
        }

        // =====================================
        // SEND TOTAL TO JSP
        // =====================================

        req.setAttribute(
                "total",
                total
        );

        // =====================================
        // FORWARD TO CHECKOUT PAGE
        // =====================================

        RequestDispatcher rd =
                req.getRequestDispatcher(
                        "/views/order/checkout.jsp"
                );

        rd.forward(req, res);
    }
}