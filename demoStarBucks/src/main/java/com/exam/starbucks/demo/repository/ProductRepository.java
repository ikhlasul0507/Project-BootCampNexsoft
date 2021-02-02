package com.exam.starbucks.demo.repository;


import com.exam.starbucks.demo.Model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    void addProduct(Product product);
    void deleteProductById(String id);
    Product findById(String id);
    List<Product> findByName(String namaProduct);
    void deleteAllProduct();
    void updateProduct(Product product);
    List<Product> findAllSave();
}
