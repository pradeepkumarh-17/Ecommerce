<%@ page import="com.ecommerce.model.User" %>

<%@ include file="../partials/header.jsp" %>

<link rel="stylesheet"
href="<%= request.getContextPath() %>/assets/css/account.css">

<%
    User user =
        (User) session.getAttribute("user");
%>

<div class="account-page">

    <h1>&#128100; User Profile</h1>

    <div class="account-card">

        <div class="profile-item">

            <strong>Name:</strong>

            <span>
                <%= user.getFullName() %>
            </span>

        </div>

        <div class="profile-item">

            <strong>Email:</strong>

            <span>
                <%= user.getEmail() %>
            </span>

        </div>

        <div class="profile-item">

            <strong>Phone:</strong>

            <span>
                <%= user.getPhone() %>
            </span>

        </div>

    </div>

</div>

<%@ include file="../partials/footer.jsp" %>