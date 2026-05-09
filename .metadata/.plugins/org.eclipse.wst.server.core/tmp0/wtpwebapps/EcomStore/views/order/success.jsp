<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../partials/header.jsp" %>

<link rel="stylesheet"
href="<%= request.getContextPath() %>/assets/css/checkout.css">

<div class="success-wrapper">

    <!-- FLOATING GLOW -->
    <div class="glow glow1"></div>
    <div class="glow glow2"></div>

    <!-- PARTICLES -->
    <div class="particles">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
    </div>

    <!-- MAIN CARD -->

    <div class="success-card-3d">

        <!-- DELIVERY ANIMATION -->

        <div class="delivery-animation">

            <div class="road"></div>

            <div class="truck">

                🚚

            </div>

        </div>

        <!-- SUCCESS ICON -->

        <div class="success-check">

            ✓

        </div>

        <!-- TITLE -->

        <h1>

            Order Placed Successfully!

        </h1>

        <!-- MESSAGE -->

        <p>

            Your premium CloudCart order has been confirmed
            and is now being prepared for shipment.

        </p>

        <!-- STATUS -->

        <div class="status-container">

            <div class="status-box">

                <h3>

                    Order Status

                </h3>

                <span>

                    Confirmed

                </span>

            </div>

            <div class="status-box">

                <h3>

                    Delivery

                </h3>

                <span>

                    2-4 Days

                </span>

            </div>

            <div class="status-box">

                <h3>

                    Payment

                </h3>

                <span>

                    Successful

                </span>

            </div>

        </div>

        <!-- BUTTONS -->

        <div class="success-actions">

            <a href="<%= request.getContextPath() %>/product"
               class="success-btn">

                Continue Shopping

            </a>

            <a href="<%= request.getContextPath() %>/orders"
               class="orders-btn">

                View Orders

            </a>

        </div>

    </div>

</div>

<%@ include file="../partials/footer.jsp" %>