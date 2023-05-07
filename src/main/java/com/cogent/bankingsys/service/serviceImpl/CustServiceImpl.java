package com.cogent.bankingsys.service.serviceImpl;


import com.cogent.bankingsys.entity.Customer;
import com.cogent.bankingsys.repo.CustRepository;
import com.cogent.bankingsys.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustServiceImpl implements CustService {

    @Autowired
    CustRepository customerRepo;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Optional<Customer> findByCustomerId(long customerId) {

        Optional<Customer> customers = customerRepo.findById(customerId);
        return customers;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        return customerRepo.save(customer);
    }


}
