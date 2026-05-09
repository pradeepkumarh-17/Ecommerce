package com.ecommerce.dao.impl;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Product;
import com.ecommerce.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    // ================= GET ALL PRODUCTS =================
    @Override
    public List<Product> getAllProducts() {

        List<Product> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(
                     "SELECT * FROM products")) {

            while (rs.next()) {
                list.add(mapProduct(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ================= CATEGORY PRODUCTS =================
    @Override
    public List<Product> getProductsByCategory(int categoryId) {

        List<Product> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(
                             "SELECT * FROM products WHERE category_id=?")) {

            ps.setInt(1, categoryId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapProduct(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ================= PRODUCT DETAILS =================
    @Override
    public Product getProductById(int productId) {

        Product product = null;

        try (Connection con = DBConnection.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(
                             "SELECT * FROM products WHERE product_id=?")) {

            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                product = mapProduct(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    // ================= FILTER PRODUCTS =================
    @Override
    public List<Product> filterProducts(
            String search,
            String category,
            String gender,
            String price) {

        List<Product> list = new ArrayList<>();

        StringBuilder query =
                new StringBuilder(
                        "SELECT * FROM products WHERE 1=1");

        if (search != null && !search.isEmpty()) {
            query.append(" AND product_name LIKE ?");
        }

        if (category != null && !category.isEmpty()) {
            query.append(" AND category_id=?");
        }

        if (gender != null && !gender.isEmpty()) {
            query.append(" AND gender=?");
        }

        if ("1".equals(price)) {
            query.append(" AND price < 500");
        } else if ("2".equals(price)) {
            query.append(" AND price BETWEEN 500 AND 1500");
        } else if ("3".equals(price)) {
            query.append(" AND price > 1500");
        }

        try (Connection con = DBConnection.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(query.toString())) {

            int index = 1;

            if (search != null && !search.isEmpty()) {
                ps.setString(index++, "%" + search + "%");
            }

            if (category != null && !category.isEmpty()) {
                ps.setInt(index++,
                        Integer.parseInt(category));
            }

            if (gender != null && !gender.isEmpty()) {
                ps.setString(index++, gender);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapProduct(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ================= RELATED PRODUCTS =================
    @Override
    public List<Product> getRelatedProducts(
            int categoryId,
            int productId) {

        List<Product> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(

                             "SELECT * FROM products " +
                             "WHERE category_id=? " +
                             "AND product_id!=? " +
                             "LIMIT 4")) {

            ps.setInt(1, categoryId);
            ps.setInt(2, productId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapProduct(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ================= PRODUCT MAPPER =================
    private Product mapProduct(ResultSet rs)
            throws SQLException {

        Product p = new Product();

        p.setProductId(
                rs.getInt("product_id"));

        p.setCategoryId(
                rs.getInt("category_id"));

        p.setName(
                rs.getString("product_name"));

        p.setBrand(
                rs.getString("brand"));

        p.setDescription(
                rs.getString("description"));

        p.setPrice(
                rs.getDouble("price"));

        p.setDiscountPrice(
                rs.getDouble("discount_price"));

        p.setSize(
                rs.getString("size"));

        p.setColor(
                rs.getString("color"));

        p.setAgeGroup(
                rs.getString("age_group"));

        p.setMaterial(
                rs.getString("material"));

        p.setGender(
                rs.getString("gender"));

        p.setStock(
                rs.getInt("stock"));

        p.setImageUrl(
                rs.getString("image_url"));

        // NEW FIELDS
        p.setRating(
                rs.getDouble("rating"));

        p.setReviewsCount(
                rs.getInt("reviews_count"));

        p.setFeatures(
                rs.getString("features"));

        p.setDeliveryInfo(
                rs.getString("delivery_info"));

        p.setTags(
                rs.getString("tags"));

        return p;
    }
}