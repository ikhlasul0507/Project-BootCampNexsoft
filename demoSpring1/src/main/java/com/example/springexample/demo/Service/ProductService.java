package com.example.springexample.demo.Service;

import com.example.springexample.demo.Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();

    Product findById(String id);

    List<Product> findByName(String name);

    boolean isProductExist(Product product);

    void saveProduct(Product product);

    void deleteProductById(String id);

    void deleteAllProducts();

    void updateProduct(Product currentProduct);

    void deleteProductByName(String nama);

    List<Product> findByIdAndName(int id, String name);

    List<Product> findAllProductsSave();
}
