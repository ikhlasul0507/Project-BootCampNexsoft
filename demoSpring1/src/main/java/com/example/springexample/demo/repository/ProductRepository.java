package com.example.springexample.demo.repository;

import com.example.springexample.demo.Model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    void addProduct(Product product);
    void deleteProductById(int id);
    Product findById(int id);
    void deleteAllProduct();
    List<Product> findByName(String name);
    void deleteProductByName(String name);
    void updateProduct(Product product);

    List<Product> findByIdAndName(int id, String name);

    List<Product> findAllSave();
}
