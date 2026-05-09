<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.*, com.ecommerce.model.Product" %>

<%@ include file="../partials/header.jsp" %>

<link rel="stylesheet"
      href="/EcomStore/assets/css/product.css">

<div class="container-3d">

    <div class="container">

        <!-- =========================================
             PREMIUM FILTER SECTION
             ========================================= -->

        <div class="filter-wrapper">

            <!-- HEADER -->
            <div class="filter-header">

                <h1>
                    Exclusive Collections
                </h1>

                <p>
                    Explore curated premium products crafted
                    for modern luxury shopping experience.
                </p>

            </div>

            <!-- FILTER FORM -->
            <form action="/EcomStore/product"
                  method="get"
                  class="lux-filter-bar">

                <!-- SEARCH -->
                <div class="filter-group">

                    <label>
                        Search
                    </label>

                    <input type="text"
                           name="search"

                           placeholder="Search premium products..."

                           value="<%= request.getParameter("search") != null
                           ? request.getParameter("search")
                           : "" %>">

                </div>

                <!-- CATEGORY -->
                <div class="filter-group">

                    <label>
                        Category
                    </label>

                    <select name="category">

                        <option value="">
                            All Categories
                        </option>

                        <option value="1"
                            <%= "1".equals(request.getParameter("category"))
                            ? "selected" : "" %>>

                            Clothes

                        </option>

                        <option value="2"
                            <%= "2".equals(request.getParameter("category"))
                            ? "selected" : "" %>>

                            Toys

                        </option>

                        <option value="3"
                            <%= "3".equals(request.getParameter("category"))
                            ? "selected" : "" %>>

                            Footwear

                        </option>

                        <option value="4"
                            <%= "4".equals(request.getParameter("category"))
                            ? "selected" : "" %>>

                            Accessories

                        </option>

                    </select>

                </div>

                <!-- GENDER -->
                <div class="filter-group">

                    <label>
                        Gender
                    </label>

                    <select name="gender">

                        <option value="">
                            All Genders
                        </option>

                        <option value="Male"
                            <%= "Male".equals(request.getParameter("gender"))
                            ? "selected" : "" %>>

                            Male

                        </option>

                        <option value="Female"
                            <%= "Female".equals(request.getParameter("gender"))
                            ? "selected" : "" %>>

                            Female

                        </option>

                        <option value="Kids"
                            <%= "Kids".equals(request.getParameter("gender"))
                            ? "selected" : "" %>>

                            Kids

                        </option>

                        <option value="Unisex"
                            <%= "Unisex".equals(request.getParameter("gender"))
                            ? "selected" : "" %>>

                            Unisex

                        </option>

                    </select>

                </div>

                <!-- PRICE -->
                <div class="filter-group">

                    <label>
                        Price
                    </label>

                    <select name="price">

                        <option value="">
                            All Prices
                        </option>

                        <option value="1"
                            <%= "1".equals(request.getParameter("price"))
                            ? "selected" : "" %>>

                            Under ₹500

                        </option>

                        <option value="2"
                            <%= "2".equals(request.getParameter("price"))
                            ? "selected" : "" %>>

                            ₹500 - ₹1500

                        </option>

                        <option value="3"
                            <%= "3".equals(request.getParameter("price"))
                            ? "selected" : "" %>>

                            Above ₹1500

                        </option>

                    </select>

                </div>

                <!-- BUTTON -->
                <button type="submit"
                        class="filter-btn">

                    Apply Filters

                </button>

            </form>

        </div>

        <!-- =========================================
             PRODUCT GRID
             ========================================= -->

        <div class="product-grid">

        <%
            List<Product> list =
                    (List<Product>)
                    request.getAttribute("products");

            if(list != null && !list.isEmpty()){

                for(Product p : list){

                    String img = p.getImageUrl();

                    if(img == null || img.isEmpty()){

                        img =
                        "https://via.placeholder.com/400";
                    }
        %>

            <!-- PRODUCT CARD -->

            <div class="product-card">

                <!-- IMAGE -->
                <div class="product-img-wrapper">

                    <a href="/EcomStore/product-details?id=<%= p.getProductId() %>">

                        <img src="<%= img %>"

                             alt="<%= p.getName() %>"

                             onerror="
                             this.src=
                             'https://source.unsplash.com/400x400/?fashion';
                             ">

                    </a>

                </div>

                <!-- PRODUCT CONTENT -->

                <div class="product-content">

                    <!-- TITLE -->
                    <h3 class="product-name">

                        <%= p.getName() %>

                    </h3>

                    <!-- BRAND -->
                    <p class="product-brand">

                        <%= p.getBrand() %>

                    </p>

                    <!-- PRICE -->
                    <div class="price-row">

                        <span class="discount-price">

                            ₹<%= p.getDiscountPrice() %>

                        </span>

                        <span class="original-price">

                            ₹<%= p.getPrice() %>

                        </span>

                    </div>

                    <!-- RATING -->
                    <div class="rating-row">

                        <span class="stars">

                            ★★★★☆

                        </span>

                        <span class="rating-text">

                            <%= p.getRating() %>
                            (<%= p.getReviewsCount() %>)

                        </span>

                    </div>

                    <!-- BUTTONS -->
                    <div class="product-actions">

                        <a href="/EcomStore/product-details?id=<%= p.getProductId() %>"
                           class="view-btn">

                            View Details

                        </a>

                        <form action="/EcomStore/cart"
                              method="post">

                            <input type="hidden"
                                   name="productId"
                                   value="<%= p.getProductId() %>">

                            <button type="submit"
                                    class="cart-btn">

                                Add To Cart

                            </button>

                        </form>

                    </div>

                </div>

            </div>

        <%
                }
            } else {
        %>

            <!-- NO DATA -->

            <div class="no-data-panel">

                <h2>
                    No Products Found
                </h2>

                <p>
                    Try changing your filters or search query.
                </p>

            </div>

        <%
            }
        %>

        </div>

    </div>

</div>

<%@ include file="../partials/footer.jsp" %>