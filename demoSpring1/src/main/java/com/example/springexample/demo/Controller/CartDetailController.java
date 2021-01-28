package com.example.springexample.demo.Controller;

import com.example.springexample.demo.Model.Cart;
import com.example.springexample.demo.Model.CartDetail;
import com.example.springexample.demo.Model.Category;
import com.example.springexample.demo.Model.Product;
import com.example.springexample.demo.Service.CartDetailService;
import com.example.springexample.demo.Service.CartService;
import com.example.springexample.demo.Service.ProductService;
import com.example.springexample.demo.Util.CustomErrorType;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartDetailController {
    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartDetailService cartDetailService;

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    // -------------------Retrieve All Products--------------------------------------------

    @RequestMapping(value = "/cartDetail/", method = RequestMethod.GET)
    public ResponseEntity<List<CartDetail>> listAllCarts() {
        List<CartDetail> carts = (List<CartDetail>) cartDetailService.findAll();
        if (carts.isEmpty()) {
            return new ResponseEntity<>(carts, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    // -------------------Retrieve Single category------------------------------------------

    @RequestMapping(value = "/cartDetail/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCartDetail(@PathVariable("id") long id) {
        logger.info("Fetching cart with id {}", id);
        CartDetail cartDetail = cartDetailService.findById(id);
        if (cartDetail == null) {
            logger.error("cart with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("cart with id " + id  + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cartDetail, HttpStatus.OK);
    }

    // -------------------Create a Product-------------------------------------------

    @RequestMapping(value = "/cartDetail/", method = RequestMethod.POST)
    public ResponseEntity<?> createCartDetail(@RequestBody CartDetail cartDetail) {
        logger.info("Creating cart : {}", cartDetail);

        Cart cart1 = cartService.findById(cartDetail.getIdCart());
        if (cart1 == null){
            logger.error("Unable to create. A Category Does Not exist");
            return new ResponseEntity<>(new CustomErrorType("Id Cart Not Found !"), HttpStatus.CONFLICT);
        }
        Product product1 = productService.findById(cartDetail.getIdProduct());
        if (product1 == null){
            logger.error("Unable to create. A Category Does Not exist");
            return new ResponseEntity<>(new CustomErrorType("Id Product Not Found !"), HttpStatus.CONFLICT);
        }

        cartDetailService.saveCartDetail(cartDetail);
        List<CartDetail> carts = (List<CartDetail>) cartDetailService.find();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    // ------------------- Update a Product ------------------------------------------------

    @RequestMapping(value = "/cartDetail/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCartDetail(@PathVariable("id") long id, @RequestBody CartDetail cartDetail) {
        logger.info("Updating Cart with id {}", id);

        CartDetail currentCartDetail = cartDetailService.findById(id);

        if (currentCartDetail == null) {
            logger.error("Unable to update. Cart with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to update. Cart with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        Cart cart1 = cartService.findById(cartDetail.getIdCart());
        if (cart1 == null){
            logger.error("Unable to create. A Category Does Not exist");
            return new ResponseEntity<>(new CustomErrorType("Id Cart Not Found !"), HttpStatus.CONFLICT);
        }
        Product product1 = productService.findById(cartDetail.getIdProduct());
        if (product1 == null){
            logger.error("Unable to create. A Category Does Not exist");
            return new ResponseEntity<>(new CustomErrorType("Id Product Not Found !"), HttpStatus.CONFLICT);
        }

        currentCartDetail.setIdCart(cartDetail.getIdCart());
        currentCartDetail.setIdProduct(cartDetail.getIdProduct());
        currentCartDetail.setQty(cartDetail.getQty());
        cartDetailService.updateCartDetail(currentCartDetail);
        return new ResponseEntity<>(cartDetail, HttpStatus.CREATED);
    }

    // ------------------- Delete a Product-----------------------------------------

    @RequestMapping(value = "/cartDetail/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCartDetail(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Category with id {}", id);

        CartDetail cartDetail = cartDetailService.findById(id);
        if (cartDetail == null) {
            logger.error("Unable to delete. Cart with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Cart with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        cartDetailService.deleteCartDetailById(id);
        return new ResponseEntity<CartDetail>(HttpStatus.NO_CONTENT);
    }

}
