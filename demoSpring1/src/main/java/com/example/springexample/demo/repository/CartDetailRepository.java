package com.example.springexample.demo.repository;

import com.example.springexample.demo.Model.CartDetail;

import java.util.List;

public interface CartDetailRepository {
    CartDetail findById(long id);
    CartDetail findByName(String name);
    List<CartDetail> findAll();
    List<CartDetail> find();
    void saveCartDetail(CartDetail cart);
    void deleteCartDetailById(long id);
    void updateCartDetail(CartDetail cart);

}
