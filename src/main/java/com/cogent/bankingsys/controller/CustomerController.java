package com.cogent.bankingsys.controller;

import com.cogent.bankingsys.entity.Account;
import com.cogent.bankingsys.entity.Customer;
import com.cogent.bankingsys.entity.Payload;
import com.cogent.bankingsys.entity.Transaction;
import com.cogent.bankingsys.service.AccService;
import com.cogent.bankingsys.service.CustService;
import com.cogent.bankingsys.service.PayloadService;
import com.cogent.bankingsys.service.TransactionService;
import com.cogent.bankingsys.service.serviceImpl.AccServiceImpl;
import com.cogent.bankingsys.service.serviceImpl.CustServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@CrossOrigin("*")
public class CustomerController {

   @Autowired
   private CustServiceImpl custService;

    @Autowired
    private AccServiceImpl accService;

    @Autowired
    private PayloadService payloadService;

    @Autowired
    private TransactionService transactionService;

    /**
     * customer register; create customer
     * @param customer
     * @return
     */
    @PostMapping(value = "/api/customer/register")
    public ResponseEntity<Customer> register(@Valid @RequestBody Customer customer){
        Customer customerResp = custService.saveCustomer(customer);
        System.out.print(customerResp);
        return new ResponseEntity<>(customerResp, HttpStatus.OK);
    }
    @GetMapping(value = "/api/customer/login/{username}/{password}")
    public ResponseEntity<Customer> login(@Valid @PathVariable String username,@Valid @PathVariable String password){
        if (Optional.of(username).isEmpty()|| Optional.of(password).isEmpty()) return new ResponseEntity<>(HttpStatus.OK);
        Optional<Customer> customer = custService.findCustomerByUserName(username,password);
        if(customer.isEmpty()) return new ResponseEntity<>(HttpStatus.OK);
        System.out.print(customer);
        return new ResponseEntity<>(customer.get(),HttpStatus.OK);
    }

    @GetMapping(value = "/api/staff/customer")
    public ResponseEntity<List<Customer>> fetAllCustomers(){
        List<Customer> accountList = custService.findAll();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @GetMapping(value = "/api/staff/accounts/approve")
    public ResponseEntity<List<Account>> getAllcouts(){
        List<Account> accountList = accService.findAll();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @PutMapping(value = "/api/staff/accounts/approve")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account){
        accService.updateAccount(account.getAccountId(),account);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(value = "/api/staff/customer")
    public ResponseEntity<Customer> blockCustomer(@RequestBody Customer customer){
        custService.updateCustomer(customer.getCustomerId(),customer);
        return new ResponseEntity<>(HttpStatus.OK);
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

    /**
     * PUT(/api/customer/transfer)
     */
    @PutMapping (value = "/api/customer/transfer")
    public ResponseEntity<Payload> savePayload(@Valid @RequestBody Payload payload){

        // update fromAccNo transaction info
        long fromAccNumber = payload.getFromAccNumber();
        Account fromAccount = accService.findByAccountNumber(fromAccNumber);
        Transaction fromTransaction = new Transaction();
        fromTransaction.setAccount(fromAccount);
        fromTransaction.setAmount(-payload.getAmount());
        fromTransaction.setDate(new Date());
        fromTransaction.setReference(payload.getReason());

        transactionService.saveTransaction(fromTransaction);
        System.out.println("from transaction: " + fromTransaction.toString());

        // update toAccNo transaction info
        long toAccountNumber = payload.getToAccNumber();
        Account toAccount = accService.findByAccountNumber(toAccountNumber);
        Transaction toTransaction = new Transaction();
        toTransaction.setAccount(toAccount);
        toTransaction.setAmount(payload.getAmount());
        toTransaction.setDate(new Date());
        toTransaction.setReference(payload.getReason());

        transactionService.saveTransaction(toTransaction);
        System.out.println("to transaction: " + toTransaction.toString());

        Payload payloadResp = payloadService.savePayload(payload);
        System.out.println(payloadResp.toString());
        return new ResponseEntity<>(payloadResp, HttpStatus.OK);
    }


}
