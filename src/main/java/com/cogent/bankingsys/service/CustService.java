package com.cogent.bankingsys.service;

import com.cogent.bankingsys.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CustService {

    public Customer saveCustomer(Customer customer);

    public Optional<Customer> findByCustomerId(long customerId);

    List<Customer> findAll();

    public Customer saveOrUpdate(Customer customer);

    Optional<Customer> findCustomerByUserName(String name,String pwd);
//    Optional<Customer> updateCustomer(Long customerId, Customer customer);
}
