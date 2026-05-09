package com.ecommerce.dao;

import com.ecommerce.model.User;

public interface UserDAO {

    boolean registerUser(User user);

    User loginUser(
            String email,
            String password
    );
}