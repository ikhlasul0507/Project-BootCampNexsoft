package com.salesmobil.demo.Service;

import com.salesmobil.demo.Model.Merk;
import com.salesmobil.demo.Model.Type;
import com.salesmobil.demo.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("typeService")
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeRepository typeRepository;

    public List<Type> findAllType(){
        //pagination should be added
        List<Type> types = typeRepository.findAll();
        return types;
    }

    public Type findById(String idType){
        Type obj;
        try {
            obj = typeRepository.findById(idType);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            obj=null;
        }
        return obj;
    }
    public List<Type> findByName(String nameType){
        return typeRepository.findByName(nameType);
    }

    public void saveType(Type type){
        synchronized (this){
            //products.put(product.getId(),product);
            //idNameHashMap.put(product.getName(),product.getId());
            typeRepository.addType(type);
        }
    }
    public void updateType(Type type){
        synchronized (this){
//            products.put(product.getId(),product);
//            idNameHashMap.put(product.getName(),product.getId());
            typeRepository.updateType(type);
        }
    }

    public void deleteTypeById(String idType){
        synchronized (this){
//            idNameHashMap.remove(products.get(id).getName());
//            products.remove(id);
            typeRepository.deleteTypeById(idType);
        }
    }

    public boolean isTypeExist(Type type){
        return typeRepository.findByName(type.getNamaType()).size() != 0;
    }
    public void deleteAllType(){
//        products.clear();
        typeRepository.deleteAllType();
    }
}