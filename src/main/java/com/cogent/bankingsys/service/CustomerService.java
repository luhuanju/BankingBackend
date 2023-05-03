package com.cogent.bankingsys.service;

import com.cogent.bankingsys.entity.Customer;
import com.cogent.bankingsys.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public Customer getCustomer(long id){
        return customerRepo.findById(id).get();
    }

    public List<Customer> getAllCustomer(){
        List<Customer> customerList = new ArrayList<Customer>();
        customerRepo.findAll().forEach(customer -> customerList.add(customer));

        return customerList;
    }

    public void saveOrUpdate(Customer customer){
        customerRepo.save(customer);
    }

    public void deleteCustomer(long id){
        customerRepo.deleteById(id);
    }

}
