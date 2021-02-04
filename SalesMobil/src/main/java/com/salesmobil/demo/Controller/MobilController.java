package com.salesmobil.demo.Controller;

import com.salesmobil.demo.Model.Mobil;
import com.salesmobil.demo.Service.MobilService;
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
public class MobilController {
    public static final Logger logger = LoggerFactory.getLogger(MobilController.class);
    @Autowired
    MobilService mobilService;
    //get all product
    @RequestMapping(value = "/MobilGetAll/", method = RequestMethod.GET)
    public ResponseEntity<List<Mobil>> listAllProduct() {
        List<Mobil> mobils = mobilService.findAllMobil();
        if (mobils.isEmpty()) {
            return new ResponseEntity<>(mobils, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(mobils, HttpStatus.OK);
        }
    }

    //get pruduct by id
    @RequestMapping(value = "/MobilGetId/{idMobil}", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@PathVariable("idMobil") String idMobil) {
        logger.info("Fetching product with idProduct {}", idMobil);
        Mobil mobil = mobilService.findById(idMobil);
        if (mobil == null) {
            logger.error("Product with idMobil {} not found .", idMobil);
            return new ResponseEntity<>(new CustomErrorType("Product with id " + idMobil + " not found"), HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(mobil, HttpStatus.OK);
        }
    }

    //insert product
    @RequestMapping(value = "/Mobil/", method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody Mobil mobil) {
        logger.info("Creating Product  : {} ", mobil);
        if (mobilService.isMobilExist(mobil)) {
            logger.error("Unable to create, Mobil already exist", mobil.getNamaMobil());
            return new ResponseEntity<>(new CustomErrorType("Unable to create, Mobil already" + mobil.getNamaMobil()), HttpStatus.CONFLICT);
        }else {
            mobilService.saveMobil(mobil);
            return new ResponseEntity<>("Data Berhasil Di Simpan", HttpStatus.OK);
        }
    }
    //delete product by id
    @RequestMapping(value = "/MobilGetId/{idMobil}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("idMobil") String idMobil) {
        logger.info("Fetching & Deleting Product with id Mobil {}", idMobil);

        Mobil mobil = mobilService.findById(idMobil);
        if (mobil == null) {
            logger.error("Unable to delete. Mobil with id {} not found.", idMobil);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Product with id Mobil " + idMobil + " not found."),
                    HttpStatus.NOT_FOUND);
        }else {
            mobilService.deleteMobilById(idMobil);
            return new ResponseEntity<>("Data Berhasil Di Hapus", HttpStatus.OK);
        }
    }
    //delete all product
    @RequestMapping(value = "/MobilDeleteAll/", method = RequestMethod.DELETE)
    public ResponseEntity<Mobil> deleteAllMobil() {
        logger.info("Deleting All Mobils");
        mobilService.deleteAllMobil();
        return new ResponseEntity<Mobil>(HttpStatus.OK);
    }
    //update product
    @RequestMapping(value = "/MobilUpdate/{idMobil}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMobil(@PathVariable("idMobil") String idMobil, @RequestBody Mobil mobil) {
        logger.info("Updating Mobil with id {}", idMobil);

        Mobil currentMobil = mobilService.findById(idMobil);

        if (currentMobil == null) {
            logger.error("Unable to update. Mobil with id {} not found.", idMobil);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Mobil with id " + idMobil + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        currentMobil.setNamaMobil(mobil.getNamaMobil());
        currentMobil.setIdMerk(mobil.getIdMerk());
        currentMobil.setIdType(mobil.getIdType());
        currentMobil.setHarga(mobil.getHarga());
        currentMobil.setTahun(mobil.getTahun());
        mobilService.updateMobil(currentMobil);
        return new ResponseEntity<>(currentMobil, HttpStatus.OK);
    }

}
