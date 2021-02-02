package com.example.springexample.demo.Model;

import java.util.List;

public class CartDetail {
    private int idCartDetail,qty;
    private String idCart,idProduct;
    List<Product> cardDetail;
    public CartDetail(int idCartDetail, String idCart, String idProduct, int qty) {
        this.idCartDetail = idCartDetail;
        this.idCart = idCart;
        this.idProduct = idProduct;
        this.qty = qty;
    }

    public List<Product> getCardDetail() {
        return cardDetail;
    }

    public void setCardDetail(List<Product> cardDetail) {
        this.cardDetail = cardDetail;
    }

    public int getIdCartDetail() {
        return idCartDetail;
    }

    public void setIdCartDetail(int idCartDetail) {
        this.idCartDetail = idCartDetail;
    }

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
