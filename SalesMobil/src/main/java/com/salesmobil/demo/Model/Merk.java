package com.salesmobil.demo.Model;

public class Merk {
    private String idMerk, namaMerk;

    public Merk(String idMerk, String namaMerk) {
        this.idMerk = idMerk;
        this.namaMerk = namaMerk;
    }

    public String getIdMerk() {
        return idMerk;
    }

    public void setIdMerk(String idMerk) {
        this.idMerk = idMerk;
    }

    public String getNamaMerk() {
        return namaMerk;
    }

    public void setNamaMerk(String namaMerk) {
        this.namaMerk = namaMerk;
    }
}
