package com.cogent.bankingsys.controller;


import com.cogent.bankingsys.entity.Customer;
import com.cogent.bankingsys.service.ServiceCus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cust")

public class ConCustomer {

    @Autowired
    private ServiceCus serviceCus;

    @RequestMapping(value = "/addCus")
    public Customer saveCustomer(@RequestBody Customer customer) {
        Customer customerResp = serviceCus.saveCustomer(customer);
        return customerResp;
    }

    @RequestMapping(value = "/{customerId}")
    public Optional<Customer> getCustomerDetails(@PathVariable long customerId) {
        Optional<Customer> customer = serviceCus.findByCustomerId(customerId);
        return customer;
    }

    @RequestMapping(value = "/getAllCus")
    public List<Customer> getAllCustomer() {
        return serviceCus.findAll();
    }
}
