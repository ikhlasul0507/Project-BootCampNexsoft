package com.salesmobil.demo.Controller;

import com.salesmobil.demo.Model.Customer;
import com.salesmobil.demo.Service.CustomerService;
import com.salesmobil.demo.Util.CustomErrorType;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
public class CustomerController {
    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    // -------------------Retrieve All Customer--------------------------------------------

    @RequestMapping(value = "/Customer/", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllcustomer() {
        List<Customer> customers = (List<Customer>) customerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(customers, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }

    // -------------------Retrieve Single Customer------------------------------------------

    @RequestMapping(value = "/Customer/{idCustomer}", method = RequestMethod.GET)
    public ResponseEntity<?> getCart(@PathVariable("idCustomer") String idCustomer) {
        logger.info("Fetching customer with id {}", idCustomer);
        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            logger.error("cart with id {} not found.", idCustomer);
            return new ResponseEntity<>(new CustomErrorType("cart with id " + idCustomer  + " not found"), HttpStatus.NOT_FOUND);
        }else{
        return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }

    // -------------------Create a Customer-------------------------------------------

    @RequestMapping(value = "/Customer/", method = RequestMethod.POST)
    public ResponseEntity<?> createCart(@RequestBody Customer Customer) {
        logger.info("Creating cart : {}", Customer);

        customerService.saveCustomer(Customer);
        List<Customer> customer2 = (List<Customer>) customerService.find();
        return new ResponseEntity<>(customer2, HttpStatus.OK);
    }

    // ------------------- Update a Customer ------------------------------------------------

    @RequestMapping(value = "/Customer/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCart(@RequestBody Customer customer) {
        logger.info("Updating customer with id {}", customer.getIdCustomer());

        Customer currentCustomer = customerService.findById(customer.getIdCustomer());

        if (currentCustomer == null) {
            logger.error("Unable to update. Cart with id {} not found.", customer.getIdCustomer());
            return new ResponseEntity<>(new CustomErrorType("Unable to update. customer with id " + customer.getIdCustomer() + " not found."),
                    HttpStatus.NOT_FOUND);
        } else {
            customerService.updateCustomer(customer);
            return new ResponseEntity<>("Data Berhasil Di Update !", HttpStatus.OK);
        }

    }

    // ------------------- Delete a Customer-----------------------------------------

    @RequestMapping(value = "/Customer/{idCustomer}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCart(@PathVariable("idCustomer") String idCustomer) {
        logger.info("Fetching & Deleting Category with id {}", idCustomer);

        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            logger.error("Unable to delete. Cart with id {} not found.", idCustomer);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Cart with id " + idCustomer + " not found."),
                    HttpStatus.NOT_FOUND);
        }else {
            customerService.deleteCustomerById(idCustomer);
            return new ResponseEntity<>("Berhasil Di Hapus !", HttpStatus.NO_CONTENT);
        }
    }
//    Show Data By Id and Name----------------------------------------------------------------
    @RequestMapping(value = "/Customer/Search/", method = RequestMethod.GET)
    public ResponseEntity<?> showSingleCustomer(@RequestParam("tahun") int tahunCustomer, @RequestParam("bulan") String bulanCustomer) {
        logger.info("Showing Product with bulan {} tahun {} ...", tahunCustomer, bulanCustomer);

//        int bulan = Integer.parseInt(bulanCustomer);
//        if (bulan >12){
//            return new ResponseEntity<>(new CustomErrorType("Unable to show month " + bulanCustomer + " for years " + tahunCustomer + " , because months over 12"), HttpStatus.NOT_FOUND);
//        }

        Customer customer = customerService.findByBulanTahun(tahunCustomer, bulanCustomer);
        if (customer == null ) {
            logger.error("Unable to show customer, because month {} and years {} is not found", bulanCustomer, tahunCustomer);
            return new ResponseEntity<>(new CustomErrorType("Unable to show month " + bulanCustomer + " for years " + tahunCustomer + " , because not found"), HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }

}
