package com.salesmobil.demo.Model;

public class Type {
    private String idType, namaType;

    public Type(String idType, String namaType) {
        this.idType = idType;
        this.namaType = namaType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getNamaType() {
        return namaType;
    }

    public void setNamaType(String namaType) {
        this.namaType = namaType;
    }
}
