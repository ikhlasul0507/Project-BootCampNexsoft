package com.exam.starbucks.demo.repository;

import com.exam.starbucks.demo.Model.Sales;

import java.util.List;

public interface SalesRepository {
    Sales findById(String id);
    List<Sales> findAll();
    List<Sales> find();
    void saveSales(Sales sales);
    void deleteSalesById(String id);
    void updateSales(Sales sales);

}
