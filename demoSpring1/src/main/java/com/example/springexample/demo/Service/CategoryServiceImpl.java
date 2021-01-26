package com.example.springexample.demo.Service;
import com.example.springexample.demo.Model.Category;
import com.example.springexample.demo.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    private static HashMap<Long, Category> category = new HashMap<>();
    private static HashMap<String, Long> idNameHashMap = new HashMap<>();

    public List<Category> findAllCategory() {
        //pagination should be added
        return new ArrayList<>(category.values());
    }

    public Category findById(long id) {
        return category.get(id);
    }

    public Category findByName(String name) {
        if (idNameHashMap.get(name) != null) {
            return category.get(idNameHashMap.get(name));
        }
        return null;
    }

    public void saveCategory(Category category) {
        synchronized (this) {
            category.put(category.getId(),category);
            idNameHashMap.put(category.getName(), category.getId());
        }
    }

    public void updateCategory(Category category) {
        synchronized (this) {
            category.put(Category, category);
            idNameHashMap.put(category.getName(), category.getId());
        }
    }

    public void deleteCategoryById(long id) {
        synchronized (this) {
            idNameHashMap.remove(category.get(id).getName());
            category.remove(id);
        }
    }

    public boolean isCategoryExist(Category category) {
        return findByName(category.getName()) != null;
    }

    public void deleteAllCategory() {
        category.clear();
    }
}
