package com.example.springexample.demo.Service;


import com.example.springexample.demo.Model.Cart;

import java.util.List;

public interface CartService {
    Cart findById(String id);
    Cart findByName(String name);
    List<Cart> findAll();
    List<Cart> find();
    void saveCart(Cart cart);
    void deleteCartById(String id);
    void updateCart(Cart cart);

    void updateCartStatus(Cart cart);

    List<Cart> findWithPaging(int page, int limit);
}
