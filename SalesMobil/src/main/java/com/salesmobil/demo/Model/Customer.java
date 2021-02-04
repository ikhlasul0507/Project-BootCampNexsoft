package com.salesmobil.demo.Model;

import java.util.List;

public class Customer {
    private String idCustomer, namaCustomer, tglCustomer;
    List<Mobil> mobilList;

    public Customer(String idCustomer, String namaCustomer, String tglCustomer) {
        this.idCustomer = idCustomer;
        this.namaCustomer = namaCustomer;
        this.tglCustomer = tglCustomer;
    }


    public List<Mobil> getMobilList() {
        return mobilList;
    }

    public void setMobilList(List<Mobil> mobilList) {
        this.mobilList = mobilList;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getTglCustomer() {
        return tglCustomer;
    }

    public void setTglCustomer(String tglCustomer) {
        this.tglCustomer = tglCustomer;
    }
}
