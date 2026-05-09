package com.ecommerce.model;

public class User {

    // =========================================
    // FIELDS
    // =========================================

    private int userId;

    private String fullName;

    private String email;

    private String phone;

    private String password;

    private String status;

    // =========================================
    // USER ID
    // =========================================

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    // =========================================
    // FULL NAME
    // =========================================

    public String getFullName() {

        return fullName;
    }

    public void setFullName(String fullName) {

        this.fullName = fullName;
    }

    // =========================================
    // EMAIL
    // =========================================

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    // =========================================
    // PHONE
    // =========================================

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    // =========================================
    // PASSWORD
    // =========================================

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    // =========================================
    // STATUS
    // =========================================

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }
}