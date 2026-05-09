package com.ecommerce.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

@WebServlet("/place-order")
public class PlaceOrderController extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res)

            throws ServletException, IOException {

        // =====================================
        // GET FORM DATA
        // =====================================

        String address =
                req.getParameter("address");

        String city =
                req.getParameter("city");

        String state =
                req.getParameter("state");

        String pincode =
                req.getParameter("pincode");

        String phone =
                req.getParameter("phone");

        String payment =
                req.getParameter("payment");

        // =====================================
        // DEBUG LOGS
        // =====================================

        System.out.println("================================");

        System.out.println("ORDER PLACED");

        System.out.println("Address : " + address);

        System.out.println("City : " + city);

        System.out.println("State : " + state);

        System.out.println("Pincode : " + pincode);

        System.out.println("Phone : " + phone);

        System.out.println("Payment : " + payment);

        System.out.println("================================");

        // =====================================
        // GET SESSION
        // =====================================

        HttpSession session =
                req.getSession();

        // =====================================
        // GET CART
        // =====================================

        Map<Integer,Integer> cart =
                (Map<Integer,Integer>)
                        session.getAttribute("cart");

        // =====================================
        // EMPTY CART CHECK
        // =====================================

        if(cart == null || cart.isEmpty()){

            res.sendRedirect(
                    req.getContextPath()
                    + "/cart"
            );

            return;
        }

        // =====================================
        // PAYMENT HANDLING
        // =====================================

        if("UPI".equals(payment)){

            System.out.println(
                    "UPI Payment Selected"
            );
        }

        else if("CARD".equals(payment)){

            System.out.println(
                    "Card Payment Selected"
            );
        }

        else{

            System.out.println(
                    "Cash On Delivery"
            );
        }

        // =====================================
        // CLEAR CART
        // =====================================

        session.removeAttribute("cart");

        // =====================================
        // SUCCESS MESSAGE
        // =====================================

        session.setAttribute(
                "successMessage",
                "Order placed successfully!"
        );

        // =====================================
        // REDIRECT SUCCESS PAGE
        // =====================================

        res.sendRedirect(
                req.getContextPath()
                + "/views/order/success.jsp"
        );
    }
}