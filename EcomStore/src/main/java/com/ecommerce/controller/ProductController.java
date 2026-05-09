package com.ecommerce.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.dao.impl.ProductDAOImpl;
import com.ecommerce.model.Product;

@WebServlet("/product")
public class ProductController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        System.out.println("PRODUCT CONTROLLER HIT");

        // 🔹 Get parameters safely
        String search = req.getParameter("search");
        String category = req.getParameter("category");
        String gender = req.getParameter("gender");
        String price = req.getParameter("price");

        // 🔹 Trim values (avoid null issues)
        search = (search != null) ? search.trim() : "";
        category = (category != null) ? category.trim() : "";
        gender = (gender != null) ? gender.trim() : "";
        price = (price != null) ? price.trim() : "";

        ProductDAO dao = new ProductDAOImpl();
        List<Product> products;

        // 🔹 Apply filter only if needed
        if (!search.isEmpty() || !category.isEmpty() || !gender.isEmpty() || !price.isEmpty()) {

            System.out.println("FILTER APPLIED → " + search + " | " + category + " | " + gender + " | " + price);

            products = dao.filterProducts(search, category, gender, price);

        } else {

            System.out.println("FETCHING ALL PRODUCTS");

            products = dao.getAllProducts();
        }

        // 🔹 Send data to JSP
        req.setAttribute("products", products);

        // 🔹 Keep filters selected (important for UI)
        req.setAttribute("search", search);
        req.setAttribute("category", category);
        req.setAttribute("gender", gender);
        req.setAttribute("price", price);

        RequestDispatcher rd = req.getRequestDispatcher("views/product/products.jsp");
        rd.forward(req, res);
    }
}