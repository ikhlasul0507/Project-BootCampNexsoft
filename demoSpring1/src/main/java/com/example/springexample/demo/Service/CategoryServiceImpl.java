package com.example.springexample.demo.Service;
import com.example.springexample.demo.Model.Category;
import com.example.springexample.demo.Model.Product;
import com.example.springexample.demo.repository.CategoryRepository;
import com.example.springexample.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    private static HashMap<Long, Category> categories = new HashMap<>();
    private static HashMap<String, Long> idNameHashMap = new HashMap<>();

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAllCategory() {
        //pagination should be added
//        return new ArrayList<>(categories.values());
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
    public List<Category> findAllCategorySave() {
        //pagination should be added
//        return new ArrayList<>(categories.values());
        List<Category> categories = categoryRepository.findAllSave();
        return categories;
    }

    public Category findById(int id) {
//        return categories.get(id);
        Category obj;
        try {
            obj = categoryRepository.findById(id);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            obj = null;
        }
        return obj;
    }

    public Category findByName(String name) {
        if (idNameHashMap.get(name) != null) {
            return categories.get(idNameHashMap.get(name));
        }
        return null;
    }

    public void saveCategory(Category category) {
        synchronized (this){
//            categories.put(category.getId(),category);
//            idNameHashMap.put(category.getName(),category.getId());
            categoryRepository.addCategory(category);
        }
    }

    public void updateCategory(Category category) {
        synchronized (this) {
            categories.put(category.getId(), category);
            idNameHashMap.put(category.getName(), category.getId());
        }
    }

    public void deleteCategoryById(int id) {
        synchronized (this) {
//            idNameHashMap.remove(categories.get(id).getName());
//            categories.remove(id);
            categoryRepository.deleteCategoriById(id);
        }
    }

    public boolean isCategoryExist(Category category) {
        return categoryRepository.findByName(category.getName()).size() != 0;
    }


    public void deleteAllCategory() {
        categories.clear();
    }
}
