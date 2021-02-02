package com.exam.starbucks.demo.Model;

public class Product {
    private String idProduct, namaProduct;
    private int harga;
    private int qty;

    public Product(){

    }
    public Product(String idProduct, String namaProduct, int harga) {
        this.idProduct = idProduct;
        this.namaProduct = namaProduct;
        this.harga = harga;
    }

  public Product(String idProduct, String namaProduct, int harga, int qty) {
      this.idProduct = idProduct;
      this.namaProduct = namaProduct;
      this.harga = harga;
      this.qty = qty;
  }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNamaProduct() {
        return namaProduct;
    }

    public void setNamaProduct(String namaProduct) {
        this.namaProduct = namaProduct;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
