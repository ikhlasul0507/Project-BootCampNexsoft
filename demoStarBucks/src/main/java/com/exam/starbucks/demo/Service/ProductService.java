package com.exam.starbucks.demo.Service;

import com.exam.starbucks.demo.Model.Product;

import java.util.List;

public interface ProductService {
List<Product> findAllProducts();
Product findById(String idProduct);
List<Product> findByName(String namaProduct);
boolean isProductExist(Product product);
void saveProduct(Product product);
void deleteProductById(String idProduct);
void deleteAllProducts();
void updateProduct(Product currentproduct);
List<Product> findAllProductSave();


}
