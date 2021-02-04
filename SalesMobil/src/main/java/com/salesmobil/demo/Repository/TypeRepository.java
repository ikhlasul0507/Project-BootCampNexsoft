package com.salesmobil.demo.Repository;

import com.salesmobil.demo.Model.Merk;
import com.salesmobil.demo.Model.Type;

import java.util.List;

public interface TypeRepository {
    List<Type> findAll();
    void addType(Type type);
    void deleteTypeById(String idType);
    Type findById(String idType);
    List<Type> findByName(String namaType);
    void deleteAllType();
    void updateType(Type type);
}
