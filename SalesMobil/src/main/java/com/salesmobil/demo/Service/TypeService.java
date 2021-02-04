package com.salesmobil.demo.Service;

import com.salesmobil.demo.Model.Merk;
import com.salesmobil.demo.Model.Type;

import java.util.List;

public interface TypeService {
    List<Type> findAllType();
    Type findById(String idType);
    List<Type> findByName(String namaType);
    boolean isTypeExist(Type type);
    void saveType(Type type);
    void deleteTypeById(String idType);
    void deleteAllType();
    void updateType(Type currenttype);
}
