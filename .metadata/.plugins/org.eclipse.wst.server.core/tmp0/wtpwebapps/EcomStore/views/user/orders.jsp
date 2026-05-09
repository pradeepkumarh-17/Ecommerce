<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../partials/header.jsp" %>

<link rel="stylesheet"
href="<%= request.getContextPath() %>/assets/css/account.css">

<div class="orders-page">

    <!-- PAGE TITLE -->

    <div class="orders-header">

        <h1>

            📦 My Orders

        </h1>

        <p>

            Track and manage your premium CloudCart purchases

        </p>

    </div>

    <!-- ORDER CARD 1 -->

    <div class="order-card glass-card">

        <!-- LEFT -->

        <div class="order-left">

            <img src="https://images.unsplash.com/photo-1523381210434-271e8be1f52b?q=80&w=800"
                 alt="Product">

        </div>

        <!-- CENTER -->

        <div class="order-center">

            <h2>

                Premium Luxury Hoodie

            </h2>

            <p class="order-id">

                Order ID:
                #CC10245

            </p>

            <p class="order-price">

                ₹2499

            </p>

            <!-- TIMELINE -->

            <div class="timeline">

                <div class="timeline-step active">

                    ✔ Ordered

                </div>

                <div class="timeline-step active">

                    🚚 Shipped

                </div>

                <div class="timeline-step">

                    📍 Out for Delivery

                </div>

                <div class="timeline-step">

                    🎉 Delivered

                </div>

            </div>

        </div>

        <!-- RIGHT -->

        <div class="order-right">

            <span class="status shipped">

                Shipped

            </span>

            <button class="track-btn">

                Track Order

            </button>

        </div>

    </div>

    <!-- ORDER CARD 2 -->

    <div class="order-card glass-card">

        <!-- LEFT -->

        <div class="order-left">

            <img src="https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=800"
                 alt="Product">

        </div>

        <!-- CENTER -->

        <div class="order-center">

            <h2>

                AirMax Sneakers

            </h2>

            <p class="order-id">

                Order ID:
                #CC10289

            </p>

            <p class="order-price">

                ₹5999

            </p>

            <!-- TIMELINE -->

            <div class="timeline">

                <div class="timeline-step active">

                    ✔ Ordered

                </div>

                <div class="timeline-step active">

                    🚚 Shipped

                </div>

                <div class="timeline-step active">

                    📍 Out for Delivery

                </div>

                <div class="timeline-step active">

                    🎉 Delivered

                </div>

            </div>

        </div>

        <!-- RIGHT -->

        <div class="order-right">

            <span class="status delivered">

                Delivered

            </span>

            <button class="track-btn">

                Buy Again

            </button>

        </div>

    </div>

</div>

<%@ include file="../partials/footer.jsp" %>