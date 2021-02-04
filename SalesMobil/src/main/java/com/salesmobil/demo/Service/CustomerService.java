package com.salesmobil.demo.Service;

import com.salesmobil.demo.Model.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(String idCustomer);
    List<Customer> findAll();
    List<Customer> find();
    void saveCustomer(Customer customer);
    void deleteCustomerById(String idCustomer);
    void updateCustomer(Customer customer);
    Customer findByBulanTahun(int tahunCustomer, String bulanCustomer);
}
