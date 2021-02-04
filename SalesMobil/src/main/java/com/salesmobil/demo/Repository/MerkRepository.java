package com.salesmobil.demo.Repository;

import com.salesmobil.demo.Model.Merk;

import java.util.List;

public interface MerkRepository {
    List<Merk> findAll();
    void addMerk(Merk merk);
    void deleteMerkById(String idMerk);
    Merk findById(String idMerk);
    List<Merk> findByName(String namaMerk);
    void deleteAllMerk();
    void updateMerk(Merk merk);
}
