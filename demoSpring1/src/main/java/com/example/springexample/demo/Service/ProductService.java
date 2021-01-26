package com.example.springexample.demo.Service;

import com.example.springexample.demo.Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();

    Product findById(long id);

    Product findByName(String name);

    boolean isProductExist(Product product);

    void saveProduct(Product product);

    void deleteProductById(long id);

    void deleteAllProducts();

    void updateProduct(Product currentProduct);
}
