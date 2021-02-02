package com.example.springexample.demo.Service;

import com.example.springexample.demo.Model.Product;
import com.example.springexample.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    private static HashMap<Long, Product> products = new HashMap<>();
    private static HashMap<String, Long> idNameHashMap = new HashMap<>();

    @Autowired
    ProductRepository productRepository;


    public List<Product> findAllProducts(){
        //pagination should be added
        List<Product> products = productRepository.findAll();
        return products;
    }
    public List<Product> findAllProductsSave(){
        //pagination should be added
        List<Product> products = productRepository.findAllSave();
        return products;
    }

    public Product findById(String id){
        Product obj;
        try {
            obj = productRepository.findById(id);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            obj=null;
        }
        return obj;
    }
    public List<Product> findByName(String name){
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByIdAndName(int id, String name) {
        return productRepository.findByIdAndName(id, name);
    }
    public void saveProduct(Product product){
        synchronized (this){
            //products.put(product.getId(),product);
            //idNameHashMap.put(product.getName(),product.getId());
            productRepository.addProduct(product);
        }
    }
    public void updateProduct(Product product){
        synchronized (this){
//            products.put(product.getId(),product);
//            idNameHashMap.put(product.getName(),product.getId());
            productRepository.updateProduct(product);
        }
    }
    public void deleteProductById(String id){
        synchronized (this){
//            idNameHashMap.remove(products.get(id).getName());
//            products.remove(id);
            productRepository.deleteProductById(id);
        }
    }
    public void deleteProductByName(String name){
        synchronized (this){
//            idNameHashMap.remove(products.get(id).getName());
//            products.remove(id);
            productRepository.deleteProductByName(name);
        }
    }

    public boolean isProductExist(Product product){
        return productRepository.findByName(product.getName()).size() != 0;
    }
    public void deleteAllProducts(){
//        products.clear();
        productRepository.deleteAllProduct();
    }
}
