package com.example.springexample.demo.Controller;

import com.example.springexample.demo.Model.Category;
import com.example.springexample.demo.Service.CategoryService;
import com.example.springexample.demo.Util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    public static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    CategoryService categoryService;

    //retrive all category
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllCategory(){
        List<Category> categories = categoryService.findAllCategory();
        if (categories.isEmpty()){
            return new ResponseEntity<>(categories, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    //retrive single category
    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCategory(@PathVariable("id") int id){
        logger.info("Fetching Category with id {}", id);
        Category category = categoryService.findById(id);
        if (category==null){
            logger.error("Category With Id {} not Found.", id);
            return new ResponseEntity<>(new CustomErrorType("Product with id "+id+" not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    //create a category
    @RequestMapping(value = "/category/", method = RequestMethod.POST)
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        logger.info("Creating category : {}", category);
        if (categoryService.isCategoryExist(category)){
            logger.error("Unable to create, a product with name {} already exist", category);
        }
        categoryService.saveCategory(category);

        List<Category> categories = categoryService.findAllCategorySave();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    //update category
    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCategory(@PathVariable("id")int id, @RequestBody Category category){
        logger.info("Updating product with id {}", id);

        Category currentCategory = categoryService.findById(id);

        if (currentCategory == null){
            logger.error("Unable to update. category with id {} not fount.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to update. product with id"+id+" not found."),HttpStatus.NOT_FOUND);
        }
        currentCategory.setName(category.getName());
        categoryService.updateCategory(currentCategory);
        return new ResponseEntity<>(currentCategory, HttpStatus.OK);
    }
    //delete category
    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id){
        logger.info("Fetching & deleting product with id {}", id);

        Category category = categoryService.findById(id);
        if(category == null){
            logger.error("Unable to delete. product with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. product with id "+id+" not found."),HttpStatus.NOT_FOUND);
        }
        categoryService.deleteCategoryById(id);
        logger.info("Berhasil di hapus !");
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
    //delte all category
    @RequestMapping(value = "/category", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteAllCategory(){
        logger.info("Deleting All category");
        categoryService.deleteAllCategory();
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
}
