package com.example.springexample.demo.Model;

public class Cart {
    private int idCart;
    private String tglTransaksi;
    private int idCustomer;
    private String statusBayar;

    public Cart(int idCart, String tglTransaksi, int idCustomer, String statusBayar) {
        this.idCart = idCart;
        this.tglTransaksi = tglTransaksi;
        this.idCustomer = idCustomer;
        this.statusBayar = statusBayar;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
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
