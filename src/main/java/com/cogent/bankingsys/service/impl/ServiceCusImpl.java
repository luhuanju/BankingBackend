package com.cogent.bankingsys.service.impl;

import com.cogent.bankingsys.entity.Account;
import com.cogent.bankingsys.entity.Customer;
import com.cogent.bankingsys.repo.CustomerRepo;
import com.cogent.bankingsys.service.ServiceCus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceCusImpl implements ServiceCus {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer saveCustomer(Customer customer){
        List<Account> accountList = new ArrayList<>();

        Account account1 = new Account();
        account1.setAccountNumber(1111L);

        Account account2 = new Account();
        account1.setAccountNumber(1112L);

        Account account3 = new Account();
        account1.setAccountNumber(1113L);

        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        account1.setCustomer(customer);
        account2.setCustomer(customer);
        account3.setCustomer(customer);

        customer.setAccountList(accountList);

        customer = customerRepo.save(customer);

        return customer;
    }

    @Override
    public Optional<Customer> findByCustomerId(long customerId) {
        Optional<Customer> customer = customerRepo.findById(customerId);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

}
