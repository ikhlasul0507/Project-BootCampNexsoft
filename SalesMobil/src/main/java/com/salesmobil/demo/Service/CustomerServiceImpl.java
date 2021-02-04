package com.salesmobil.demo.Service;
import com.salesmobil.demo.Model.Customer;
import com.salesmobil.demo.Repository.CustomerRepository;
import com.salesmobil.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll() {
        List<Customer> carts = customerRepository.findAll();
        return carts;
    }


    public List<Customer> find() {
        List<Customer> customers = customerRepository.find();
        return customers;
    }

    public Customer findById(String id) {
        Customer pd;
        try{
            pd = customerRepository.findById(id);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            pd = null;
        }
        return pd;
    }

    public Customer findByBulanTahun(int tahunCustomer, String bulanCustomer) {
        Customer customer1;
        try {
            customer1 = customerRepository.findByBulanTahun(tahunCustomer, bulanCustomer);
        } catch (Exception e) {
            customer1 = null;
        }
        return customer1;
    }

    public void saveCustomer(Customer customer) {
        synchronized (this) {
            customerRepository.saveCustomer(customer);
        }
    }

    public void updateCustomer(Customer customer) {
        synchronized (this) {
            customerRepository.updateCustomer(customer);
        }
    }

    public void deleteCustomerById(String id) {
        synchronized (this) {
            customerRepository.deleteCustomerById(id);
        }
    }


}

