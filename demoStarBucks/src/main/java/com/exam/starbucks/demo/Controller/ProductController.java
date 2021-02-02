package com.exam.starbucks.demo.Controller;

import com.exam.starbucks.demo.Model.Product;
import com.exam.starbucks.demo.Service.ProductService;
import com.exam.starbucks.demo.Util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("starbucks")
public class ProductController {

    public static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    ProductService productService;

    //get all product
    @RequestMapping(value = "/productGetAll/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProduct() {
        List<Product> products = productService.findAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //get pruduct by id
    @RequestMapping(value = "/productGetId/{idProduct}", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@PathVariable("idProduct") String idProduct) {
        logger.info("Fetching product with idProduct {}", idProduct);
        Product product = productService.findById(idProduct);
        if (product == null) {
            logger.error("Product with idProduct {} not found .", idProduct);
            return new ResponseEntity<>(new CustomErrorType("Product with id " + idProduct + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //insert product
    @RequestMapping(value = "/product/", method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        logger.info("Creating Product  : {} ", product);
        if (productService.isProductExist(product)) {
            logger.error("Unable to create, product already exist", product.getNamaProduct());
            return new ResponseEntity<>(new CustomErrorType("Unable to create, product already" + product.getNamaProduct()), HttpStatus.CONFLICT);
        }
        productService.saveProduct(product);
//        Product Baru = productService.findById(product.getIdProduct());
        return new ResponseEntity<>("Data Berhasil Di Simpan", HttpStatus.OK);
    }
    //delete product by id
    @RequestMapping(value = "/productGetId/{idProduct}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("idProduct") String idProduct) {
        logger.info("Fetching & Deleting Product with id Product {}", idProduct);

        Product product = productService.findById(idProduct);
        if (product == null) {
            logger.error("Unable to delete. Product with id {} not found.", idProduct);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Product with id product " + idProduct + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        productService.deleteProductById(idProduct);
        return new ResponseEntity<>("Data Berhasil Di Hapus",HttpStatus.OK);
    }
    //delete all product
    @RequestMapping(value = "/productDeleteAll/", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteAllProducts() {
        logger.info("Deleting All Products");
        productService.deleteAllProducts();
        return new ResponseEntity<Product>(HttpStatus.OK);
    }
    //update product
    @RequestMapping(value = "/productUpdate/{idProduct}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@PathVariable("idProduct") String idProduct, @RequestBody Product product) {
        logger.info("Updating Product with id {}", idProduct);

        Product currentProduct = productService.findById(idProduct);

        if (currentProduct == null) {
            logger.error("Unable to update. Product with id {} not found.", idProduct);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Product with id " + idProduct + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentProduct.setNamaProduct(product.getNamaProduct());
        currentProduct.setHarga(product.getHarga());

        productService.updateProduct(currentProduct);
        return new ResponseEntity<>(currentProduct, HttpStatus.OK);
    }

}
