package com.example.springexample.demo.repository;

import com.example.springexample.demo.Model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    void addCategory(Category category);
    void deleteCategoriById(int id);
    Category findById(int id);
    void deleteAllCategory();
    List<Category> findByName(String name);
    void deleteCategoryByName(String name);
    void updateCategory(Category category);

    List<Category> findByIdAndName(int id, String name);

    List<Category> findAllSave();
}
