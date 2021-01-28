package com.example.springexample.demo.Service;

import com.example.springexample.demo.Model.CartDetail;

import java.util.List;

public interface CartDetailService {
    CartDetail findById(long id);
    CartDetail findByName(String name);
    List<CartDetail> findAll();
    List<CartDetail> find();
    void saveCartDetail(CartDetail cartDetail);
    void deleteCartDetailById(long id);
    void updateCartDetail(CartDetail cartDetail);
}
