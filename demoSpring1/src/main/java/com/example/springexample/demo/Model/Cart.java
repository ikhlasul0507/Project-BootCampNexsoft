package com.example.springexample.demo.Model;

import java.util.List;

public class Cart {
    private String idCart;
    private String tglTransaksi;
    private int idCustomer;
    private String statusBayar;
    List<Product> productList;
    List<CartDetail> cardDetails;

    public Cart(String idCart, String tglTransaksi, int idCustomer, String statusBayar) {
        this.idCart = idCart;
        this.tglTransaksi = tglTransaksi;
        this.idCustomer = idCustomer;
        this.statusBayar = statusBayar;
    }

    public List<CartDetail> getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(List<CartDetail> cardDetails) {
        this.cardDetails = cardDetails;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public String getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(String tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getStatusBayar() {
        return statusBayar;
    }

    public void setStatusBayar(String statusBayar) {
        this.statusBayar = statusBayar;
    }

}
