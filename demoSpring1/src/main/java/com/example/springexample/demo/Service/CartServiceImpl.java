package com.example.springexample.demo.Service;

import com.example.springexample.demo.Model.Cart;
import com.example.springexample.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {

    private static HashMap<Long, Cart> carts = new HashMap<>();
    private static HashMap<String, Long> idNameHashMap = new HashMap<>();

    @Autowired
    CartRepository cartRepository;

    public List<Cart> findAll() {
        List<Cart> carts = cartRepository.findAll();
        return carts;
    }

    public List<Cart> find() {
        List<Cart> carts = cartRepository.find();
        return carts;
    }

    public Cart findById(long id) {
        Cart pd;
        try{
            pd = cartRepository.findById(id);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public Cart findByName(String name) {
        Cart pd;
        try{
            pd = cartRepository.findByName(name);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public void saveCart(Cart cart) {
        synchronized (this) {
            cartRepository.saveCart(cart);
        }
    }

    public void updateCart(Cart cart) {
        synchronized (this) {
            cartRepository.updateCart(cart);
        }
    }

    public void deleteCartById(long id) {
        synchronized (this) {
            cartRepository.deleteCartById(id);
        }
    }


}
