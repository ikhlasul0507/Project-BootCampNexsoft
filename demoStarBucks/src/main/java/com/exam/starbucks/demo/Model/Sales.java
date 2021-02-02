package com.exam.starbucks.demo.Model;

import java.util.List;

public class Sales {
    private String kodeTransaksi,namaCustomer,tglTransaksi;
    List<Product> productList;

    public Sales(String kodeTransaksi, String namaCustomer, String tglTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
        this.namaCustomer = namaCustomer;
        this.tglTransaksi = tglTransaksi;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(String tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
