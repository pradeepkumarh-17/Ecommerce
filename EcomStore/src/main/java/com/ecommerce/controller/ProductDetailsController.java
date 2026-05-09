package com.ecommerce.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.List;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.dao.impl.ProductDAOImpl;

import com.ecommerce.model.Product;

@WebServlet("/product-details")
public class ProductDetailsController
        extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res)

            throws ServletException, IOException {

        try {

            // GET PRODUCT ID
            String idParam =
                    req.getParameter("id");

            // INVALID ID
            if (idParam == null
                    || idParam.isEmpty()) {

                res.sendRedirect(
                        req.getContextPath()
                        + "/product");

                return;
            }

            int productId =
                    Integer.parseInt(idParam);

            // DAO
            ProductDAO dao =
                    new ProductDAOImpl();

            // MAIN PRODUCT
            Product product =
                    dao.getProductById(productId);

            // PRODUCT NOT FOUND
            if (product == null) {

                res.sendRedirect(
                        req.getContextPath()
                        + "/product");

                return;
            }

            // RELATED PRODUCTS
            List<Product> relatedProducts =

                    dao.getRelatedProducts(
                            product.getCategoryId(),
                            productId
                    );

            // SEND TO JSP
            req.setAttribute(
                    "product",
                    product
            );

            req.setAttribute(
                    "relatedProducts",
                    relatedProducts
            );

            // FORWARD
            RequestDispatcher rd =

                    req.getRequestDispatcher(
                            "/views/product/product-details.jsp"
                    );

            rd.forward(req, res);

        } catch (Exception e) {

            e.printStackTrace();

            res.sendRedirect(
                    req.getContextPath()
                    + "/product");
        }
    }
}