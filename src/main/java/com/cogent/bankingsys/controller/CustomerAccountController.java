package com.cogent.bankingsys.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.bankingsys.entity.CustomerAccount;
import com.cogent.bankingsys.service.AccountService;

import jakarta.validation.Valid;

@RestController
public class CustomerAccountController {

	@Autowired
	private AccountService accountService;


	@PostMapping("/api/customer/{customerID}/acocunt")
	public ResponseEntity<CustomerAccount> createAccount(@PathVariable Integer customerID,
			@Valid @RequestBody CustomerAccount account) {
		int accountnumber = 1000000 + new Random().nextInt(9000000);
		account.setCustomerId(customerID);
		account.setAccountNumber("" + accountnumber);
		account.setApproved("No");
		account.setDateOfCreation(new Date());
		CustomerAccount customerAccount = accountService.createAccont(account);
		return new ResponseEntity<>(customerAccount, HttpStatus.OK);
	}

}
