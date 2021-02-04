package com.salesmobil.demo.Controller;

import com.salesmobil.demo.Model.Merk;
import com.salesmobil.demo.Service.MerkService;
import com.salesmobil.demo.Util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
public class MerkController {
    public static final Logger logger = LoggerFactory.getLogger(MerkController.class);
    @Autowired
    MerkService merkService;
    //get all product
    @RequestMapping(value = "/merkGetAll/", method = RequestMethod.GET)
    public ResponseEntity<List<Merk>> listAllProduct() {
        List<Merk> merks = merkService.findAllMerk();
        if (merks.isEmpty()) {
            return new ResponseEntity<>(merks, HttpStatus.NOT_FOUND);
        }else{
        return new ResponseEntity<>(merks, HttpStatus.OK);
        }
    }

    //get pruduct by id
    @RequestMapping(value = "/merkGetId/{idMerk}", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@PathVariable("idMerk") String idMerk) {
        logger.info("Fetching product with idProduct {}", idMerk);
        Merk merk = merkService.findById(idMerk);
        if (merk == null) {
            logger.error("Product with idMerk {} not found .", idMerk);
            return new ResponseEntity<>(new CustomErrorType("Product with id " + idMerk + " not found"), HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(merk, HttpStatus.OK);
        }
    }

    //insert product
    @RequestMapping(value = "/merk/", method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody Merk merk) {
        logger.info("Creating Product  : {} ", merk);
        if (merkService.isMerkExist(merk)) {
            logger.error("Unable to create, merk already exist", merk.getNamaMerk());
            return new ResponseEntity<>(new CustomErrorType("Unable to create, merk already" + merk.getNamaMerk()), HttpStatus.CONFLICT);
        }else {
            merkService.saveMerk(merk);
            return new ResponseEntity<>("Data Berhasil Di Simpan", HttpStatus.OK);
        }
    }
    //delete product by id
    @RequestMapping(value = "/merkGetId/{idMerk}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("idMerk") String idMerk) {
        logger.info("Fetching & Deleting Product with id Merk {}", idMerk);

        Merk merk = merkService.findById(idMerk);
        if (merk == null) {
            logger.error("Unable to delete. merk with id {} not found.", idMerk);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Product with id merk " + idMerk + " not found."),
                    HttpStatus.NOT_FOUND);
        }else {
            merkService.deleteMerkById(idMerk);
            return new ResponseEntity<>("Data Berhasil Di Hapus", HttpStatus.OK);
        }
    }
    //delete all product
    @RequestMapping(value = "/merkDeleteAll/", method = RequestMethod.DELETE)
    public ResponseEntity<Merk> deleteAllMerk() {
        logger.info("Deleting All Merks");
        merkService.deleteAllMerk();
        return new ResponseEntity<Merk>(HttpStatus.OK);
    }
    //update product
    @RequestMapping(value = "/merkUpdate/{idMerk}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMerk(@PathVariable("idMerk") String idMerk, @RequestBody Merk merk) {
        logger.info("Updating merk with id {}", idMerk);

        Merk currentMerk = merkService.findById(idMerk);

        if (currentMerk == null) {
            logger.error("Unable to update. merk with id {} not found.", idMerk);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. merk with id " + idMerk + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentMerk.setNamaMerk(merk.getNamaMerk());

        merkService.updateMerk(currentMerk);
        return new ResponseEntity<>(currentMerk, HttpStatus.OK);
    }

}
