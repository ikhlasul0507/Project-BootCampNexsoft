package com.example.springexample.demo.repository;

import com.example.springexample.demo.Model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
