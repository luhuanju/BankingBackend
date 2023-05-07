package com.cogent.bankingsys.controller;

import com.cogent.bankingsys.entity.Account;
import com.cogent.bankingsys.entity.Customer;
import com.cogent.bankingsys.entity.Transaction;
import com.cogent.bankingsys.service.AccService;
import com.cogent.bankingsys.service.CustService;
import com.cogent.bankingsys.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController

public class AccountController {

    @Autowired
    private CustService custService;

    @Autowired
    private AccService accService;

    @Autowired
    private TransactionService transactionService;

//    @PostMapping(value = "/api/customer/{customerId}/acocunt")
//    public ResponseEntity<Account> saveAccount(@PathVariable Long customerId,
//                                               @Valid @RequestBody Account account){
//
//        account.setCustomerId(customerId);
//        account.setApproved("No");
//
//        Account accountResp = accountService.saveAccount(account);
//        System.out.println("accountResp: " + accountResp.toString());
//
//        return new ResponseEntity<>(accountResp, HttpStatus.OK);
//
//    }

    @GetMapping(value = "/api/account/getAccount")
    public List<Account> getAccount(){
        return accService.findAll();
    }

    @GetMapping(value = "/api/customer/getCustomer")
    public List<Customer> getCustomer(){
        return custService.findAll();
    }

    @GetMapping(value = "/api/staff/account/{accountNo}")
    public Optional<Customer> getStatement(@Valid @PathVariable Long accountNo){
        return custService.findByCustomerId(accountNo);
    }

//    @GetMapping(value = "/api/customer/{customerId}")
//    public Optional<Customer> getCustomerById(@Valid @PathVariable long customerId){
//        System.out.println(customerId);
//        Optional<Customer> customer = customerService.findByCustomerId(customerId);
//        return customer;
//    }

//    /**
//     * get transaction
//     * @param customerID
//     * @param accountID
//     * @return
//     */
//    @GetMapping(value = "/api/customer/{customerID}/account/{accountID}/getTrans")
//    public Account getAccountAndTrans(@Valid @PathVariable long customerID, @Valid @PathVariable long accountID){
//
//        System.out.println("customerID: " + customerID + "; accountNo:" + accountID);
//
//        Account account = accountService.findByAccountNumber(accountID);
//
//        return account;
//    }

    /**
     * save transaction
     * @param accountID
     * @param transaction
     * @return
     */
    @PostMapping(value = "/api/customer/{customerID}/account/{accountID}/addTrans")
    public Transaction saveTrans(@Valid @PathVariable long accountID, @RequestBody Transaction transaction){

        Account account = accService.findByAccountNumber(accountID);

        System.out.println("account: " + account.toString());
        if (account != null){
            transaction.setAccount(account);
            System.out.println("transaction: " + transaction.toString());
            return transactionService.saveTransaction(transaction);
        }
        else{
            return null;
        }

    }



}
