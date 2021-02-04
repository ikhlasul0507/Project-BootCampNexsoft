package com.salesmobil.demo.Model;

import java.util.List;

public class CustomerDetail {
    private String idCustomerDetail,idCustomer,idMobil;
    private int qty;
    List<Mobil> customerDetail;

    public CustomerDetail(String idCustomerDetail, String idCustomer, String idMobil, int qty) {
        this.idCustomerDetail = idCustomerDetail;
        this.idCustomer = idCustomer;
        this.idMobil = idMobil;
        this.qty = qty;
    }

    public String getIdCustomerDetail() {
        return idCustomerDetail;
    }

    public void setIdCustomerDetail(String idCustomerDetail) {
        this.idCustomerDetail = idCustomerDetail;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(String idMobil) {
        this.idMobil = idMobil;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public List<Mobil> getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(List<Mobil> customerDetail) {
        this.customerDetail = customerDetail;
    }
}
