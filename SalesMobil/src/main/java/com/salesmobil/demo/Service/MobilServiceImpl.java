package com.salesmobil.demo.Service;

import com.salesmobil.demo.Model.Mobil;
import com.salesmobil.demo.Repository.MobilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mobilService")
public class MobilServiceImpl implements MobilService {
    @Autowired
    MobilRepository mobilRepository;

    public List<Mobil> findAllMobil(){
        //pagination should be added
        List<Mobil> mobils = mobilRepository.findAll();
        return mobils;
    }

    public Mobil findById(String idMobil){
        Mobil obj;
        try {
            obj = mobilRepository.findById(idMobil);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            obj=null;
        }
        return obj;
    }
    public List<Mobil> findByName(String nameMobil){
        return mobilRepository.findByName(nameMobil);
    }

    public void saveMobil(Mobil mobil){
        synchronized (this){
            //products.put(product.getId(),product);
            //idNameHashMap.put(product.getName(),product.getId());
            mobilRepository.addMobil(mobil);
        }
    }
    public void updateMobil(Mobil mobil){
        synchronized (this){
//            products.put(product.getId(),product);
//            idNameHashMap.put(product.getName(),product.getId());
            mobilRepository.updateMobil(mobil);
        }
    }

    public void deleteMobilById(String idMobil){
        synchronized (this){
//            idNameHashMap.remove(products.get(id).getName());
//            products.remove(id);
            mobilRepository.deleteMobilById(idMobil);
        }
    }

    public boolean isMobilExist(Mobil mobil){
        return mobilRepository.findByName(mobil.getNamaMobil()).size() != 0;
    }
    public void deleteAllMobil(){
//        products.clear();
        mobilRepository.deleteAllMobil();
    }
}