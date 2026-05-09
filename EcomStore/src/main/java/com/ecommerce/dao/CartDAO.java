package com.ecommerce.dao;

import java.util.List;
import com.ecommerce.model.Cart;
import com.ecommerce.model.CartItem;

public interface CartDAO {

    Cart getActiveCartByUser(int userId);

    boolean createCart(int userId);

    boolean addToCart(int userId, int productId, int quantity);

    boolean updateCartItem(int cartItemId, int quantity);

    boolean removeCartItem(int cartItemId);

    List<CartItem> getCartItems(int userId);

    boolean clearCart(int userId);
}