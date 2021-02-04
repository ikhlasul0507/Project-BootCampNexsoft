package com.salesmobil.demo.Repository;

import com.salesmobil.demo.Model.Merk;
import com.salesmobil.demo.Model.Mobil;

import java.util.List;

public interface MobilRepository {
    List<Mobil> findAll();
    void addMobil(Mobil mobil);
    void deleteMobilById(String idMobil);
    Mobil findById(String idMobil);
    List<Mobil> findByName(String namaMobil);
    void deleteAllMobil();
    void updateMobil(Mobil mobil);
}
