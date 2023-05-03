package com.cogent.bankingsys.controller;

import com.cogent.bankingsys.entity.Customer;
import com.cogent.bankingsys.entity.PayLoad;
import com.cogent.bankingsys.repo.CustomerRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @GetMapping(value = "/getCustomer")
    public List<Customer> getCustomer(){
        return customerRepo.findAll();
    }

    @PostMapping(value = "/addCustomer")
    public Customer addCustomer(@Valid @RequestBody Customer customer){
        return customerRepo.save(customer);
    }

    @PutMapping(value = "/updateCustomer/{id}")
    public ResponseEntity<Customer> udpateCustomer (@PathVariable("id") long id, @RequestBody Customer newCustomer){

        Optional<Customer> existingCust = customerRepo.findById(id);

        if (existingCust.isPresent()){
            Customer tempCustomer = existingCust.get();
//          // only change the full name
            tempCustomer.setFullname(newCustomer.getFullname());
//            tempCustomer.setCustomerId(newCustomer.getCustomerId());
//            tempCustomer.setPassword(newCustomer.getPassword());
//            tempCustomer.setPhone(newCustomer.getPhone());

            return new ResponseEntity<>(customerRepo.save(tempCustomer), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") long id){
        customerRepo.deleteById(id);
    }

}
