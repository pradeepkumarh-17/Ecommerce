<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="com.ecommerce.model.Product" %>
<%@ page import="java.util.List" %>

<%@ include file="../partials/header.jsp" %>

<link rel="stylesheet"
      href="/EcomStore/assets/css/product.css">

<div class="container-3d">

    <div class="container">

    <%
        Product p =
            (Product) request.getAttribute("product");

        List<Product> relatedProducts =
            (List<Product>) request.getAttribute(
                    "relatedProducts"
            );

        if(p != null){

            String img = p.getImageUrl();

            if(img == null || img.isEmpty()){

                img =
                "https://picsum.photos/600";
            }
    %>

    <!-- ===================================== -->
    <!-- PRODUCT DETAILS -->
    <!-- ===================================== -->

    <div class="product-details glass-panel">

        <!-- IMAGE SECTION -->
        <div class="image-section">

            <div class="product-img-card">

                <img src="<%= img %>"

                     alt="<%= p.getName() %>"

                     onerror="
                     this.src=
                     'https://source.unsplash.com/600x600/?shopping';
                     ">

            </div>

        </div>

        <!-- INFO SECTION -->
        <div class="info-section">

            <!-- TITLE -->
            <h2 class="product-title">
                <%= p.getName() %>
            </h2>

            <!-- BRAND -->
            <p class="brand">
                Brand:
                <span>
                    <%= p.getBrand() %>
                </span>
            </p>

            <!-- RATING -->
            <div class="rating">

                <span class="stars">
                    ★★★★☆
                </span>

                <span class="review-count">

                    (<%= p.getRating() %>/5 •

                    <%= p.getReviewsCount() %>

                    reviews)

                </span>

            </div>

            <!-- PRICE -->
            <div class="price-box">

                <p class="discount-price">

                    ₹<%= p.getDiscountPrice() %>

                </p>

                <p class="original-price">

                    ₹<%= p.getPrice() %>

                </p>

                <span class="discount-badge">

                    PREMIUM OFFER

                </span>

            </div>

            <!-- STOCK -->
            <div class="stock-status">

            <%
                if(p.getStock() > 0){
            %>

                <span class="in-stock">

                    In Stock
                    (<%= p.getStock() %>)

                </span>

            <%
                } else {
            %>

                <span class="out-stock">

                    Out Of Stock

                </span>

            <%
                }
            %>

            </div>

            <!-- DESCRIPTION -->
            <p class="desc">

                <%= p.getDescription() %>

            </p>

            <!-- FEATURES -->
            <div class="features-box">

                <h4>Features</h4>

                <p>

                    <%= p.getFeatures() %>

                </p>

            </div>

            <!-- COLOR -->
            <div class="option">

                <strong>Color:</strong>

                <span class="product-meta">

                    <%= p.getColor() %>

                </span>

            </div>

            <!-- SIZE -->
            <div class="option">

                <strong>Size:</strong>

                <span class="product-meta">

                    <%= p.getSize() %>

                </span>

            </div>

            <!-- MATERIAL -->
            <div class="option">

                <strong>Material:</strong>

                <span class="product-meta">

                    <%= p.getMaterial() %>

                </span>

            </div>

            <!-- GENDER -->
            <div class="option">

                <strong>Gender:</strong>

                <span class="product-meta">

                    <%= p.getGender() %>

                </span>

            </div>

            <!-- DELIVERY -->
            <div class="delivery-info">

                <p>

                    <strong>Delivery:</strong>

                    <%= p.getDeliveryInfo() %>

                </p>

            </div>

            <!-- TAGS -->
            <div class="tags-box">

                <strong>Tags:</strong>

                <span>

                    <%= p.getTags() %>

                </span>

            </div>

            <!-- ADD TO CART -->
            <form action="/EcomStore/cart"
                  method="post"
                  class="details-cart-form">

                <input type="hidden"
                       name="productId"
                       value="<%= p.getProductId() %>">

                <button class="cart-btn big-btn">

                    Add To Cart

                </button>

            </form>

        </div>

    </div>

    <!-- ===================================== -->
    <!-- REVIEWS -->
    <!-- ===================================== -->

    <div class="reviews-section">

        <h3 class="section-title">

            Customer Reviews

        </h3>

        <div class="reviews-grid">

            <div class="review-card glass-panel">

                <div class="stars">

                    ★★★★★

                </div>

                <p>

                    Amazing premium quality product.
                    Worth every rupee.

                </p>

                <small>

                    - Pradeep Kumar

                </small>

            </div>

            <div class="review-card glass-panel">

                <div class="stars">

                    ★★★★☆

                </div>

                <p>

                    Fast delivery and excellent packaging.

                </p>

                <small>

                    - Rahul Sharma

                </small>

            </div>

            <div class="review-card glass-panel">

                <div class="stars">

                    ★★★★★

                </div>

                <p>

                    Premium finish and very comfortable.

                </p>

                <small>

                    - Sneha Verma

                </small>

            </div>

        </div>

    </div>

    <!-- ===================================== -->
    <!-- RELATED PRODUCTS -->
    <!-- ===================================== -->

    <div class="related-section">

        <h3 class="section-title">

            Related Products

        </h3>

        <div class="related-grid">

        <%
            if(relatedProducts != null){

                for(Product rp : relatedProducts){
        %>

            <div class="related-card glass-panel">

                <img src="<%= rp.getImageUrl() %>"

                     alt="<%= rp.getName() %>"

                     onerror="
                     this.src=
                     'https://source.unsplash.com/300x300/?product';
                     ">

                <h4>

                    <%= rp.getName() %>

                </h4>

                <p class="related-price">

                    ₹<%= rp.getDiscountPrice() %>

                </p>

                <a href="/EcomStore/product-details?id=<%= rp.getProductId() %>"
                   class="view-btn">

                    View Details

                </a>

            </div>

        <%
                }
            }
        %>

        </div>

    </div>

    <%
        } else {
    %>

    <!-- PRODUCT NOT FOUND -->

    <div class="error-panel glass-panel">

        <h2>

            Product Not Found

        </h2>

        <p>

            The product you are looking for
            does not exist.

        </p>

        <a href="/EcomStore/product"
           class="btn">

            Return To Products

        </a>

    </div>

    <%
        }
    %>

    </div>

</div>

<%@ include file="../partials/footer.jsp" %>