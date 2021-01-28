package com.example.springexample.demo.Service;


import com.example.springexample.demo.Model.Cart;

import java.util.List;

public interface CartService {
    Cart findById(long id);
    Cart findByName(String name);
    List<Cart> findAll();
    List<Cart> find();
    void saveCart(Cart cart);
    void deleteCartById(long id);
    void updateCart(Cart cart);
}
