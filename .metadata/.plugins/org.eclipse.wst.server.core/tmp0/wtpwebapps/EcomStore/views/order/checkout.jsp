<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../partials/header.jsp" %>

<link rel="stylesheet"
href="<%= request.getContextPath() %>/assets/css/checkout.css">

<div class="checkout-container">

    <h1 class="checkout-title">

        🛍️ Secure Checkout

    </h1>

    <!-- FORM START -->

    <form action="<%= request.getContextPath() %>/place-order"
          method="post">

        <div class="checkout-layout">

            <!-- LEFT -->

            <div class="checkout-left">

                <!-- SHIPPING -->

                <div class="card">

                    <h2>

                        Shipping Address

                    </h2>

                    <div class="form-group">

                        <label>

                            Full Address

                        </label>

                        <textarea
                            name="address"
                            required
                            placeholder="Enter your address"></textarea>

                    </div>

                    <div class="row">

                        <div class="form-group">

                            <label>

                                City

                            </label>

                            <input type="text"
                                   name="city"
                                   required
                                   placeholder="City">

                        </div>

                        <div class="form-group">

                            <label>

                                State

                            </label>

                            <input type="text"
                                   name="state"
                                   required
                                   placeholder="State">

                        </div>

                    </div>

                    <div class="row">

                        <div class="form-group">

                            <label>

                                Pincode

                            </label>

                            <input type="text"
                                   name="pincode"
                                   required
                                   placeholder="Pincode">

                        </div>

                        <div class="form-group">

                            <label>

                                Phone

                            </label>

                            <input type="text"
                                   name="phone"
                                   required
                                   placeholder="Phone">

                        </div>

                    </div>

                </div>

                <!-- PAYMENT -->

                <div class="card">

                    <h2>

                        Payment Method

                    </h2>

                    <!-- COD -->

                    <label class="payment-option">

                        <input type="radio"
                               name="payment"
                               value="COD"
                               checked>

                        Cash On Delivery

                    </label>

                    <!-- UPI -->

                    <label class="payment-option">

                        <input type="radio"
                               name="payment"
                               value="UPI">

                        UPI Payment
                        (GPay / PhonePe / Paytm)

                    </label>

                    <!-- CARD -->

                    <label class="payment-option">

                        <input type="radio"
                               name="payment"
                               value="CARD">

                        Credit / Debit Card

                    </label>

                    <!-- CARD SECTION -->

                    <div class="card-payment-box">

                        <h3>

                            💳 Card Details

                        </h3>

                        <div class="form-group">

                            <input type="text"
                                   placeholder="Card Holder Name">

                        </div>

                        <div class="form-group">

                            <input type="text"
                                   placeholder="Card Number">

                        </div>

                        <div class="row">

                            <div class="form-group">

                                <input type="text"
                                       placeholder="MM/YY">

                            </div>

                            <div class="form-group">

                                <input type="password"
                                       placeholder="CVV">

                            </div>

                        </div>

                        <!-- OFFERS -->

                        <div class="offer-box">

                            <h4>

                                🎉 Bank Offers

                            </h4>

                            <p>

                                • 10% OFF on HDFC Cards

                            </p>

                            <p>

                                • Flat ₹500 OFF on ICICI Credit Cards

                            </p>

                            <p>

                                • 5% Cashback on SBI Debit Cards

                            </p>

                        </div>

                    </div>

                    <!-- UPI SECTION -->

                    <div class="upi-box">

                        <h3>

                            📱 Choose UPI App

                        </h3>

                        <div class="upi-apps">

                            <div class="upi-app">

                                🟣 PhonePe

                            </div>

                            <div class="upi-app">

                                🟢 Google Pay

                            </div>

                            <div class="upi-app">

                                🔵 Paytm

                            </div>

                        </div>

                    </div>

                </div>

            </div>

            <!-- RIGHT -->

            <div class="checkout-right">

                <div class="card">

                    <h2>

                        Order Summary

                    </h2>

                    <div class="summary-item">

                        <span>

                            Subtotal

                        </span>

                        <span>

                            ₹<%= request.getAttribute("total") %>

                        </span>

                    </div>

                    <div class="summary-item">

                        <span>

                            Delivery

                        </span>

                        <span>

                            FREE

                        </span>

                    </div>

                    <div class="summary-total">

                        <span>

                            Total

                        </span>

                        <span>

                            ₹<%= request.getAttribute("total") %>

                        </span>

                    </div>

                    <!-- BUTTON -->

                    <button type="submit"
                            class="place-order-btn">

                        Place Order

                    </button>

                </div>

            </div>

        </div>

    </form>

</div>

<script>

const paymentRadios =
document.querySelectorAll(
'input[name="payment"]'
);

const upiBox =
document.querySelector('.upi-box');

const cardBox =
document.querySelector('.card-payment-box');

function updatePaymentUI(){

    let selected =
    document.querySelector(
    'input[name="payment"]:checked'
    ).value;

    upiBox.style.display =
    selected === 'UPI'
    ? 'block'
    : 'none';

    cardBox.style.display =
    selected === 'CARD'
    ? 'block'
    : 'none';
}

paymentRadios.forEach(radio => {

    radio.addEventListener(
    'change',
    updatePaymentUI
    );

});

updatePaymentUI();

</script>

<%@ include file="../partials/footer.jsp" %>