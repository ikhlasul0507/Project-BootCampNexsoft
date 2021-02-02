package com.exam.starbucks.demo.Model;

import java.util.List;

public class SalesDetail {
    private String kodeDetail, kodeTransaksi, kodeProduct;
    private int qty;
    List<Product> salesDetail;

    public SalesDetail(String kodeDetail, String kodeTransaksi, String kodeProduct, int qty) {
        this.kodeDetail = kodeDetail;
        this.kodeTransaksi = kodeTransaksi;
        this.kodeProduct = kodeProduct;
        this.qty = qty;
    }

    public String getKodeDetail() {
        return kodeDetail;
    }

    public void setKodeDetail(String kodeDetail) {
        this.kodeDetail = kodeDetail;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public String getKodeProduct() {
        return kodeProduct;
    }

    public void setKodeProduct(String kodeProduct) {
        this.kodeProduct = kodeProduct;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public List<Product> getSalesDetail() {
        return salesDetail;
    }

    public void setSalesDetail(List<Product> salesDetail) {
        this.salesDetail = salesDetail;
    }
}
