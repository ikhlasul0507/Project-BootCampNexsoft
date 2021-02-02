package com.exam.starbucks.demo.Controller;

import com.exam.starbucks.demo.Model.Sales;
import com.exam.starbucks.demo.Service.SalesService;
import com.exam.starbucks.demo.Util.CustomErrorType;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/starbucks")
public class SalesController {
    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(SalesController.class);

    @Autowired
    SalesService salesService;

    // -------------------Retrieve All sales--------------------------------------------

    @RequestMapping(value = "/sales/", method = RequestMethod.GET)
    public ResponseEntity<List<Sales>> listAllsales() {
        List<Sales> saless = (List<Sales>) salesService.findAll();
        if (saless.isEmpty()) {
            return new ResponseEntity<>(saless, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(saless, HttpStatus.OK);
        }
    }

    // -------------------Retrieve Single saLES------------------------------------------

    @RequestMapping(value = "/sales/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCart(@PathVariable("id") String id) {
        logger.info("Fetching cart with id {}", id);
        Sales sales = salesService.findById(id);
        if (sales == null) {
            logger.error("cart with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("cart with id " + id  + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    // -------------------Create a sales-------------------------------------------

    @RequestMapping(value = "/sales/", method = RequestMethod.POST)
    public ResponseEntity<?> createCart(@RequestBody Sales sales) {
        logger.info("Creating cart : {}", sales);

        salesService.saveSales(sales);
        List<Sales> sales2 = (List<Sales>) salesService.find();
        return new ResponseEntity<>(sales2, HttpStatus.OK);
    }

    // ------------------- Update a sales ------------------------------------------------

    @RequestMapping(value = "/sales/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCart(@RequestBody Sales sales) {
        logger.info("Updating Cart with id {}", sales.getKodeTransaksi());

        Sales currentSales = salesService.findById(sales.getKodeTransaksi());

        if (currentSales == null) {
            logger.error("Unable to update. Cart with id {} not found.", sales.getKodeTransaksi());
            return new ResponseEntity<>(new CustomErrorType("Unable to update. Cart with id " + sales.getKodeTransaksi() + " not found."),
                    HttpStatus.NOT_FOUND);
        } else {
////            currentCart.setTglTransaksi(cart.getTglTransaksi());
//            currentCart.setIdCustomer(cart.getIdCustomer());
//            currentCart.setStatusBayar(cart.getStatusBayar());
            salesService.updateSales(sales);
            return new ResponseEntity<>("Data Berhasil Di Update !", HttpStatus.OK);
        }

    }

    // ------------------- Delete a sales-----------------------------------------

    @RequestMapping(value = "/sales/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCart(@PathVariable("id") String id) {
        logger.info("Fetching & Deleting Category with id {}", id);

        Sales sales = salesService.findById(id);
        if (sales == null) {
            logger.error("Unable to delete. Cart with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Cart with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        salesService.deleteSalesById(id);
        return new ResponseEntity<Sales>(HttpStatus.NO_CONTENT);
    }

}

