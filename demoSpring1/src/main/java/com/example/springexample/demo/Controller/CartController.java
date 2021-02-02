package com.example.springexample.demo.Controller;

import com.example.springexample.demo.Model.Cart;
import com.example.springexample.demo.Service.CartService;
import com.example.springexample.demo.Util.CustomErrorType;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {
    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartService cartService;

    // -------------------Retrieve All Products--------------------------------------------

    @RequestMapping(value = "/cart/", method = RequestMethod.GET)
    public ResponseEntity<List<Cart>> listAllCarts() {
        List<Cart> carts = (List<Cart>) cartService.findAll();
        if (carts.isEmpty()) {
            return new ResponseEntity<>(carts, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(carts, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/cart/pagging/", method = RequestMethod.GET)
        public ResponseEntity<?> getCartPaging(@RequestParam("page") int page, @RequestParam("limit") int limit){
            List<Cart> cart = cartService.findWithPaging(page,limit);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
    // -------------------Retrieve Single category------------------------------------------

    @RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCart(@PathVariable("id") String id) {
        logger.info("Fetching cart with id {}", id);
        Cart cart = cartService.findById(id);
        if (cart == null) {
            logger.error("cart with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("cart with id " + id  + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    // -------------------Create a Product-------------------------------------------

    @RequestMapping(value = "/cart/", method = RequestMethod.POST)
    public ResponseEntity<?> createCart(@RequestBody Cart cart) {
        logger.info("Creating cart : {}", cart);

        cartService.saveCart(cart);
        List<Cart> carts = (List<Cart>) cartService.find();
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    // ------------------- Update a Product ------------------------------------------------

    @RequestMapping(value = "/cart/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCart(@RequestBody Cart cart) {
        logger.info("Updating Cart with id {}", cart.getIdCart());

        Cart currentCart = cartService.findById(cart.getIdCart());

        if (currentCart == null) {
            logger.error("Unable to update. Cart with id {} not found.", cart.getIdCart());
            return new ResponseEntity<>(new CustomErrorType("Unable to update. Cart with id " + cart.getIdCart() + " not found."),
                    HttpStatus.NOT_FOUND);
        } else {
//            currentCart.setTglTransaksi(cart.getTglTransaksi());
//            currentCart.setIdCustomer(cart.getIdCustomer());
//            currentCart.setStatusBayar(cart.getStatusBayar());
            cartService.updateCart(cart);
            return new ResponseEntity<>(cart, HttpStatus.CREATED);
        }

    }
    //updata status
    @RequestMapping(value = "/cart/status", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCartStatus(@RequestBody Cart cart) {
        logger.info("Updating Cart with id {}", cart.getIdCart());

        Cart currentCart = cartService.findById(cart.getIdCart());

        if (currentCart == null) {
            logger.error("Unable to update. Cart with id {} not found.", cart.getIdCart());
            return new ResponseEntity<>(new CustomErrorType("Unable to update. Cart with id " + cart.getIdCart() + " not found."),
                    HttpStatus.NOT_FOUND);
        } else {

            currentCart.setStatusBayar(cart.getStatusBayar());
            cartService.updateCartStatus(cart);
            return new ResponseEntity<>(cart, HttpStatus.CREATED);
        }

    }


    // ------------------- Delete a Product-----------------------------------------

    @RequestMapping(value = "/cart/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCart(@PathVariable("id") String id) {
        logger.info("Fetching & Deleting Category with id {}", id);

        Cart cart = cartService.findById(id);
        if (cart == null) {
            logger.error("Unable to delete. Cart with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Cart with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        cartService.deleteCartById(id);
        return new ResponseEntity<Cart>(HttpStatus.NO_CONTENT);
    }

}
