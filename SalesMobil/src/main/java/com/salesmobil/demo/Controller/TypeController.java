package com.salesmobil.demo.Controller;

import com.salesmobil.demo.Model.Merk;
import com.salesmobil.demo.Model.Type;
import com.salesmobil.demo.Service.MerkService;
import com.salesmobil.demo.Service.TypeService;
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
public class TypeController {
    public static final Logger logger = LoggerFactory.getLogger(TypeController.class);
    @Autowired
    TypeService typeService;
    //get all product
    @RequestMapping(value = "/typeGetAll/", method = RequestMethod.GET)
    public ResponseEntity<List<Type>> listAllType() {
        List<Type> types = typeService.findAllType();
        if (types.isEmpty()) {
            return new ResponseEntity<>(types, HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(types, HttpStatus.OK);
        }
    }

    //get pruduct by id
    @RequestMapping(value = "/typeGetId/{idType}", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@PathVariable("idType") String idType) {
        logger.info("Fetching type with idtype {}", idType);
        Type type = typeService.findById(idType);
        if (type == null) {
            logger.error("type with idType {} not found .", idType);
            return new ResponseEntity<>(new CustomErrorType("type with id " + idType + " not found"), HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(type, HttpStatus.OK);
        }
    }

    //insert product
    @RequestMapping(value = "/type/", method = RequestMethod.POST)
    public ResponseEntity<?> createType(@RequestBody Type type) {
        logger.info("Creating type  : {} ", type);
        if (typeService.isTypeExist(type)) {
            logger.error("Unable to create, type already exist", type.getNamaType());
            return new ResponseEntity<>(new CustomErrorType("Unable to create, type already" + type.getNamaType()), HttpStatus.CONFLICT);
        }else {
            typeService.saveType(type);
            return new ResponseEntity<>("Data Berhasil Di Simpan", HttpStatus.OK);
        }
    }
    //delete product by id
    @RequestMapping(value = "/typeGetId/{idType}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteType(@PathVariable("idType") String idType) {
        logger.info("Fetching & Deleting type with id type {}", idType);

        Type type = typeService.findById(idType);
        if (type == null) {
            logger.error("Unable to delete. type with id {} not found.", idType);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Product with id type " + idType + " not found."),
                    HttpStatus.NOT_FOUND);
        }else {
            typeService.deleteTypeById(idType);
            return new ResponseEntity<>("Data Berhasil Di Hapus", HttpStatus.OK);
        }
    }
    //delete all product
    @RequestMapping(value = "/typeDeleteAll/", method = RequestMethod.DELETE)
    public ResponseEntity<Type> deleteAllType() {
        logger.info("Deleting All type");
        typeService.deleteAllType();
        return new ResponseEntity<Type>(HttpStatus.OK);
    }
    //update product
    @RequestMapping(value = "/typeUpdate/{idType}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateType(@PathVariable("idType") String idType, @RequestBody Type type) {
        logger.info("Updating type with id {}", idType);

        Type currentType = typeService.findById(idType);

        if (currentType == null) {
            logger.error("Unable to update. type with id {} not found.", idType);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. type with id " + idType + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentType.setNamaType(type.getNamaType());

        typeService.updateType(currentType);
        return new ResponseEntity<>(currentType, HttpStatus.OK);
    }

}
