package com.example.springexample.demo.Model;

import java.util.List;

public class CartDetail {
    private int idCartDetail,idCart,idProduct,qty;


    public CartDetail(int idCartDetail, int idCart, int idProduct, int qty) {
        this.idCartDetail = idCartDetail;
        this.idCart = idCart;
        this.idProduct = idProduct;
        this.qty = qty;
    }

    public int getIdCartDetail() {
        return idCartDetail;
    }

    public void setIdCartDetail(int idCartDetail) {
        this.idCartDetail = idCartDetail;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
