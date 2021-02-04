package com.salesmobil.demo.Service;

import com.salesmobil.demo.Model.Merk;

import java.util.List;

public interface MerkService {
    List<Merk> findAllMerk();
    Merk findById(String idMerk);
    List<Merk> findByName(String namaMerk);
    boolean isMerkExist(Merk merk);
    void saveMerk(Merk merk);
    void deleteMerkById(String idMerk);
    void deleteAllMerk();
    void updateMerk(Merk currentmerk);
}
