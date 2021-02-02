package com.example.springexample.demo.Controller;

import com.example.springexample.demo.Model.Category;
import com.example.springexample.demo.Model.Product;
import com.example.springexample.demo.Service.CategoryService;
import com.example.springexample.demo.Service.ProductService;
import com.example.springexample.demo.Util.CustomErrorType;
import com.example.springexample.demo.repository.CategoryRepository;
import com.example.springexample.demo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    public static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService; //Service which will do all data retrieval/manipulation work

    @Autowired
    CategoryService categoryService;

    // -------------------Retrieve All Products--------------------------------------------

    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> products = productService.findAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // -------------------Retrieve Single Product------------------------------------------

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@PathVariable("id") String id) {
        logger.info("Fetching Product with id {}", id);
        Product product = productService.findById(id);
        if (product == null) {
            logger.error("Product with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Product with id " + id  + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // -------------------Retrieve Single name Product------------------------------------------

//    @RequestMapping(value = "/product/name/{name}", method = RequestMethod.GET)
//    public ResponseEntity<?> getProduct(@PathVariable("name") String name) {
//        logger.info("Fetching Product with name {}", name);
//        Product product = (Product) productService.findByName(name).get(0);
//        if (product == null) {
//            logger.error("Product with name {} not found.", name);
//            return new ResponseEntity<>(new CustomErrorType("Product with name " + name  + " not found"), HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }


    @RequestMapping(value = "/product/detail/", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@RequestParam("id") int id, @RequestParam ("name") String name){
        logger.info("Fetching Product with id {} and name {}", id, name);
        List <Product> products = productService.findByIdAndName(id, name);
        if (products.size() == 0) {
            logger.error("Product with id {} and name {} not found.", id, name);
            return new ResponseEntity<>(new CustomErrorType("Product with id "+id+" and name " + name  + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }



    // -------------------Create a Product-------------------------------------------

    @RequestMapping(value = "/product/", method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        logger.info("Creating Product : {}", product);
        if (productService.isProductExist(product)){
            logger.error("Unable to create. A Product with name {} already exist", product.getName());
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A Product with name " +product.getName() + " already exist."), HttpStatus.CONFLICT);

        }
        Category category1 = categoryService.findById(product.getCategoryId());
        if (category1 == null){
            logger.error("Unable to create. A Category Does Not exist");
            return new ResponseEntity<>(new CustomErrorType("Id Category Not Found !"), HttpStatus.CONFLICT);

        }

        productService.saveProduct(product);
        List<Product> products = productService.findAllProductsSave();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // ------------------- Update a Product ------------------------------------------------

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        logger.info("Updating Product with id {}", id);

        Product currentProduct = productService.findById(id);

        if (currentProduct == null) {
            logger.error("Unable to update. Product with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Product with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentProduct.setName(product.getName());
        currentProduct.setCategoryId(product.getCategoryId());
        currentProduct.setPrice(product.getPrice());

        productService.updateProduct(currentProduct);
        return new ResponseEntity<>(currentProduct, HttpStatus.OK);
    }

    // ------------------- Delete a Product-----------------------------------------

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id) {
        logger.info("Fetching & Deleting Product with id {}", id);

        Product product = productService.findById(id);
        if (product == null) {
            logger.error("Unable to delete. Product with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Product with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        productService.deleteProductById(id);
        logger.info("Berhasil Di Hapus !");
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete a Product by name-----------------------------------------

//    @RequestMapping(value = "/product/name/", method = RequestMethod.DELETE)
////    public ResponseEntity<?> deleteProduct(@PathVariable("name") String name) {
//        public ResponseEntity<?> deleteProduct(@RequestParam("name") String name){
//        logger.info("Fetching & Deleting Product with name {}", name);
//
//        Product product = (Product) productService.findByName(name).get(0);
//        if (product == null) {
//            logger.error("Unable to delete. Product with name {} not found.", name);
//            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Product with name " + name + " not found."),
//                    HttpStatus.NOT_FOUND);
//        }
//        productService.deleteProductByName(name);
//        logger.info("Berhasil Di Hapus !");
//        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
//    }

    // ------------------- Delete All Products-----------------------------

    @RequestMapping(value = "/product/", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteAllProducts() {
        logger.info("Deleting All Products");

        productService.deleteAllProducts();
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }
}
