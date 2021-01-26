package com.example.springexample.demo.Service;

import com.example.springexample.demo.Model.Category;
import com.example.springexample.demo.Model.Product;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();

    Category findById(long id);

    Category findByName(String name);

    boolean isCategoryExist(Category category);

    void saveCategory(Category category);

    void deleteCategoryById(long id);

    void deleteAllCategory();

    void updateCategory(Category currentCategory);
}
