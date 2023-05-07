package com.cogent.bankingsys.controller;

import com.cogent.bankingsys.entity.Account;
import com.cogent.bankingsys.entity.Customer;
import com.cogent.bankingsys.service.AccService;
import com.cogent.bankingsys.service.CustService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

@RestController

public class CustomerController {

   @Autowired
   private CustService custService;

    @Autowired
    private AccService accService;

    /**
     * customer register; create customer
     * @param customer
     * @return
     */
    @PostMapping(value = "/api/customer/register")
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer){
        Customer customerResp = custService.saveCustomer(customer);
        return new ResponseEntity<>(customerResp, HttpStatus.OK);
    }

    /**
     * create account for a customer
     * @param customerID
     * @param account
     * @return
     */
    @PostMapping(value = "/api/customer/{customerID}/acocunt")
    public ResponseEntity<Account> saveAccount(@PathVariable Long customerID,
                                               @Valid @RequestBody Account account){

        account.setApproved("No");

        long accountnumber = 1000000 + new Random().nextInt(9000000);
        account.setAccountNumber(accountnumber);

        account.setDateOfCreation(new Date());
        account.setCustomerId(customerID);

        Account accountResp = accService.saveAccount(account);
        System.out.println("accountResp: " + accountResp.toString());

        return new ResponseEntity<>(accountResp, HttpStatus.OK);

    }

    /**
     * /api/customer/:customerID/account/:accountNo
     * update accountApproved status to 'Yes'
     * approve account for a customer
     * @return
     */
    @PutMapping(value = "/api/customer/{customerID}/account/{accountNo}")
    public ResponseEntity<Account> approvedAccount(@PathVariable Long customerID,
                                                   @PathVariable Long accountNo) {
        Account account = accService.findByAccountNumber(accountNo);

        account.setApproved("Yes");
        Account accountResp = accService.saveAccount(account);
        System.out.println("update Account: " + account.toString());

        return new ResponseEntity<>(accountResp, HttpStatus.OK);
    }

    /**
     * get customer by customerId
     * GET(/api/customer/getcustomer/{userId})
     * @param userId
     * @return
     */
    @GetMapping(value = "/api/customer/getcustomer/{userId}")
    public Optional<Customer> getCustomerById(@Valid @PathVariable long userId){
        System.out.println("userId: " + userId);
        Optional<Customer> customer = custService.findByCustomerId(userId);
        return customer;
    }

    /**
     * PUT(/api/customer/:customerID)
     * update customer by customerID
     * @param customerID
     * @param newCustomer
     * @return
     */
    @PutMapping(value = "/api/customer/{customerID}")
    public ResponseEntity<Customer> updateCustomer(@Valid @PathVariable long customerID, @RequestBody Customer newCustomer) {
        Optional<Customer> oldCust = custService.findByCustomerId(customerID);

        if (oldCust.isPresent()){
            Customer newCust = oldCust.get();

            newCust.setUsername(newCustomer.getUsername());
            newCust.setFullname(newCustomer.getFullname());
            newCust.setPassword(newCustomer.getPassword());
            newCust.setPhone(newCustomer.getPhone());
            newCust.setIdentityID(newCustomer.getIdentityID());
            newCust.setSecretQuestion(newCustomer.getSecretQuestion());
            newCust.setSecretAnswer(newCustomer.getSecretAnswer());

            Customer custResp = custService.saveCustomer(newCust);

            return new ResponseEntity<>(custResp, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * get account by accountId(accountNo)
     * /api/customer/{customerID}/account/{accountID}
     * @param customerID
     * @param accountID
     * @return
     */
    @GetMapping(value = "/api/customer/{customerID}/account/{accountID}")
    public Account getAccountByNo(@Valid @PathVariable long customerID, @Valid @PathVariable long accountID){

        System.out.println("customerID: " + customerID + "; accountNo:" + accountID);

        Account account = accService.findByAccountNumber(accountID);

        return account;
    }


}
