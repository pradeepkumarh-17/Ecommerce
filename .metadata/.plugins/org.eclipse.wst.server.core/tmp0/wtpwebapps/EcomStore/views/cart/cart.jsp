<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.*, com.ecommerce.dao.*, com.ecommerce.dao.impl.*, com.ecommerce.model.Product" %>

<%@ include file="../partials/header.jsp" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/cart.css">

<div class="cart-container">

<h2>Your Cart 🛒</h2>

<div class="cart-layout">

<!-- ================= LEFT SIDE ================= -->
<div class="cart-items">

<%
    Map<Integer, Integer> cartMap =
        (Map<Integer, Integer>) session.getAttribute("cart");

    ProductDAO dao = new ProductDAOImpl();
    double total = 0;

    if (cartMap != null && !cartMap.isEmpty()) {

        for (Map.Entry<Integer, Integer> entry : cartMap.entrySet()) {

            int productId = entry.getKey();
            int qty = entry.getValue();

            Product p = dao.getProductById(productId);

            if (p == null) continue;

            double price = p.getPrice();
            double sub = price * qty;
            total += sub;
%>

<div class="cart-card">

    <img src="<%= p.getImageUrl() %>"
         onerror="this.src='https://picsum.photos/100'">

    <div class="cart-info">
        <h3><%= p.getName() %></h3>
        <p class="price">₹ <%= price %></p>

        <p>Qty: <strong><%= qty %></strong></p>

        <a class="remove-btn"
           href="<%= request.getContextPath() %>/remove-item?id=<%= productId %>">
           Remove
        </a>
    </div>

    <div class="subtotal">
        ₹<%= sub %>
    </div>

</div>

<%
        }
    } else {
%>

<p style="color:red; font-weight:bold;">⚠️ Your cart is empty</p>

<%
    }
%>

</div>

<!-- ================= RIGHT SIDE ================= -->
<div class="cart-summary">

    <h3>Price Details</h3>

    <%
        int totalItems = 0;
        boolean hasItems = false;

        if (cartMap != null && !cartMap.isEmpty()) {
            hasItems = true;
            for (int q : cartMap.values()) totalItems += q;
        }
    %>

    <p>Total Items: <%= totalItems %></p>

    <h2>₹<%= total %></h2>

    <!-- ✅ FIXED CHECKOUT BUTTON -->
    <% if(hasItems){ %>
        <a href="<%= request.getContextPath() %>/checkout">
            <button class="checkout-btn">Proceed to Checkout</button>
        </a>
    <% } else { %>
        <button class="checkout-btn" disabled
                style="opacity:0.5; cursor:not-allowed;">
            Cart is Empty
        </button>
    <% } %>

</div>

</div>

</div>

<%@ include file="../partials/footer.jsp" %>