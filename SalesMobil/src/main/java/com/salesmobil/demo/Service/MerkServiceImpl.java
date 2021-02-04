package com.salesmobil.demo.Service;

import com.salesmobil.demo.Model.Merk;
import com.salesmobil.demo.Repository.MerkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("merkService")
public class MerkServiceImpl implements MerkService {
    @Autowired
    MerkRepository merkRepository;

    public List<Merk> findAllMerk(){
        //pagination should be added
        List<Merk> merks = merkRepository.findAll();
        return merks;
    }

    public Merk findById(String idMerk){
        Merk obj;
        try {
            obj = merkRepository.findById(idMerk);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            obj=null;
        }
        return obj;
    }
    public List<Merk> findByName(String nameMerk){
        return merkRepository.findByName(nameMerk);
    }

    public void saveMerk(Merk merk){
        synchronized (this){
            //products.put(product.getId(),product);
            //idNameHashMap.put(product.getName(),product.getId());
            merkRepository.addMerk(merk);
        }
    }
    public void updateMerk(Merk merk){
        synchronized (this){
//            products.put(product.getId(),product);
//            idNameHashMap.put(product.getName(),product.getId());
            merkRepository.updateMerk(merk);
        }
    }

    public void deleteMerkById(String idMerk){
        synchronized (this){
//            idNameHashMap.remove(products.get(id).getName());
//            products.remove(id);
            merkRepository.deleteMerkById(idMerk);
        }
    }

    public boolean isMerkExist(Merk merk){
        return merkRepository.findByName(merk.getNamaMerk()).size() != 0;
    }
    public void deleteAllMerk(){
//        products.clear();
        merkRepository.deleteAllMerk();
    }
}


