package com.salesmobil.demo.Service;

import com.salesmobil.demo.Model.Merk;
import com.salesmobil.demo.Model.Mobil;

import java.util.List;

public interface MobilService {
    List<Mobil> findAllMobil();
    Mobil findById(String idMobil);
    List<Mobil> findByName(String namaMobil);
    boolean isMobilExist(Mobil mobil);
    void saveMobil(Mobil mobil);
    void deleteMobilById(String idMobil);
    void deleteAllMobil();
    void updateMobil(Mobil currentmobil);
}
