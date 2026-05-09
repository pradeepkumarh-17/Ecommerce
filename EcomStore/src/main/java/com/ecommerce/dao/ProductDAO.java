package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Product;

public interface ProductDAO {

    /* ALL PRODUCTS */
    List<Product> getAllProducts();

    /* CATEGORY PRODUCTS */
    List<Product> getProductsByCategory(int categoryId);

    /* SINGLE PRODUCT DETAILS */
    Product getProductById(int productId);

    /* FILTER PRODUCTS */
    List<Product> filterProducts(
            String search,
            String category,
            String gender,
            String price
    );

    /* RELATED PRODUCTS */
    List<Product> getRelatedProducts(
            int categoryId,
            int productId
    );
}