package com.salesmobil.demo.Model;

import java.util.List;

public class Mobil {
    private String idMobil,namaMobil,idMerk,idType;
    private int harga,tahun;
    private int qty;
    public Mobil(){

    }

    public Mobil(String idMobil, String namaMobil, String idMerk, String idType, int harga, int tahun, int qty) {
        this.idMobil = idMobil;
        this.namaMobil = namaMobil;
        this.idMerk = idMerk;
        this.idType = idType;
        this.harga = harga;
        this.tahun = tahun;
        this.qty = qty;
    }

    public Mobil(String idMobil, String namaMobil, String idMerk, String idType, int harga, int tahun) {
        this.idMobil = idMobil;
        this.namaMobil = namaMobil;
        this.idMerk = idMerk;
        this.idType = idType;
        this.harga = harga;
        this.tahun = tahun;
    }


    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(String idMobil) {
        this.idMobil = idMobil;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public String getIdMerk() {
        return idMerk;
    }

    public void setIdMerk(String idMerk) {
        this.idMerk = idMerk;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }
}
