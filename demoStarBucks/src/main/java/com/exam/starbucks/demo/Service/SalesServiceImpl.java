package com.exam.starbucks.demo.Service;

import com.exam.starbucks.demo.Model.Sales;
import com.exam.starbucks.demo.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("cartService")
public class SalesServiceImpl implements SalesService {

    private static HashMap<Long, Service> carts = new HashMap<>();
    private static HashMap<String, Long> idNameHashMap = new HashMap<>();

    @Autowired
    SalesRepository salesRepository;

    public List<Sales> findAll() {
        List<Sales> carts = salesRepository.findAll();
        return carts;
    }


    public List<Sales> find() {
        List<Sales> saless = salesRepository.find();
        return saless;
    }

    public Sales findById(String id) {
        Sales pd;
        try{
            pd = salesRepository.findById(id);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public void saveSales(Sales sales) {
        synchronized (this) {
            salesRepository.saveSales(sales);
        }
    }

    public void updateSales(Sales sales) {
        synchronized (this) {
            salesRepository.updateSales(sales);
        }
    }

    public void deleteSalesById(String id) {
        synchronized (this) {
            salesRepository.deleteSalesById(id);
        }
    }


}
