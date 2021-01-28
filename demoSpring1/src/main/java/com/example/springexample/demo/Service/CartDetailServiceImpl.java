package com.example.springexample.demo.Service;

import com.example.springexample.demo.Model.Cart;
import com.example.springexample.demo.Model.CartDetail;
import com.example.springexample.demo.repository.CartDetailRepository;
import com.example.springexample.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("cartDetailService")
public class CartDetailServiceImpl implements CartDetailService {

    private static HashMap<Long, Cart> carts = new HashMap<>();
    private static HashMap<String, Long> idNameHashMap = new HashMap<>();

    @Autowired
    CartDetailRepository cartDetailRepository;

    public List<CartDetail> findAll() {
        List<CartDetail> carts = cartDetailRepository.findAll();
        return carts;
    }

    public List<CartDetail> find() {
        List<CartDetail> carts = cartDetailRepository.find();
        return carts;
    }

    public CartDetail findById(long id) {
        CartDetail pd;
        try{
            pd = cartDetailRepository.findById(id);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public CartDetail findByName(String name) {
        CartDetail pd;
        try{
            pd = cartDetailRepository.findByName(name);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public void saveCartDetail(CartDetail cartDetail) {
        synchronized (this) {
            cartDetailRepository.saveCartDetail(cartDetail);
        }
    }

    public void updateCartDetail(CartDetail cartDetail) {
        synchronized (this) {
            cartDetailRepository.updateCartDetail(cartDetail);
        }
    }

    public void deleteCartDetailById(long id) {
        synchronized (this) {
            cartDetailRepository.deleteCartDetailById(id);
        }
    }


}

