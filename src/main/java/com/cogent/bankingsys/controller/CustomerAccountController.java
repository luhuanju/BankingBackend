package com.cogent.bankingsys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.bankingsys.entity.BeneficiaryAccount;
import com.cogent.bankingsys.entity.CustomersAccount;
import com.cogent.bankingsys.service.AccountService;
import com.cogent.bankingsys.service.BeneficiaryService;

import jakarta.validation.Valid;

@RestController
//@CrossOrigin(origins = "http://localhost:4200/")

public class CustomerAccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private BeneficiaryService beneficiaryService;


//	/**
//	 * Create Account
//	 * @param customerID
//	 * @param account
//	 * @return
//	 */
//	@PostMapping("/api/customer/{customerID}/acocunt")
//	public ResponseEntity<CustomersAccount> createAccount(@PathVariable Integer customerID,
//			@Valid @RequestBody CustomersAccount account) {
//		int accountnumber = 1000000 + new Random().nextInt(9000000);
//		account.setCustomerId(customerID);
//		account.setAccountNumber("" + accountnumber);
//		account.setApproved("No");
//		account.setDateOfCreation(new Date());
//		CustomersAccount customerAccount = accountService.createAccont(account);
//		return new ResponseEntity<>(customerAccount, HttpStatus.OK);
//	}

//	/**
//	 * Get Account List by ID
//	 * @param customerID
//	 * @return
//	 */
//	@GetMapping("/api/customer/{customerID}/acocunt")
//	public ResponseEntity<List<CustomersAccount>> getAccountList(@PathVariable Integer customerID) {
//		List<CustomersAccount> accountList = accountService.getAllAccoubnt(customerID);
//		return new ResponseEntity<>(accountList, HttpStatus.OK);
//	}

	/**
	 * 
	 * @param customerID
	 * @param account
	 * @return
	 */

	@PostMapping("/api/customer/{customerID}/beneficiary")
	public ResponseEntity<Map<String, String>> saveBeneficaryAccount(@Valid @PathVariable Integer customerID,
			@Valid @RequestBody BeneficiaryAccount account) {
		Map<String, String> message = new HashMap<>();
		account.setCustomerId(customerID);
		BeneficiaryAccount customerAccount = beneficiaryService.createAccont(account);
		if (customerAccount == null) {
			message.put("message", "Sorry Beneficiary with <"+account.getAccountNumber()+"> not added!");
			return new ResponseEntity<Map<String, String>>(message, HttpStatus.BAD_REQUEST);

		}else {
			message.put("message", "Beneficiary with <"+account.getAccountNumber()+"> added!");
			return new ResponseEntity<Map<String, String>>(message, HttpStatus.OK);
		}
	}

	/**
	 * 
	 * @param customerID
	 * @return
	 */
	@GetMapping("/api/customer/{customerID}/beneficiary")
	public ResponseEntity<List<BeneficiaryAccount>> getBeneficaryList(@Valid @PathVariable Integer customerID) {
		List<BeneficiaryAccount> accountList = beneficiaryService.getBeneficiaryAccounts(customerID);
		return new ResponseEntity<>(accountList, HttpStatus.OK);
	}

	/**
	 * deleteBeneficary
	 * 
	 * @param customerID
	 * @param beneficaryId
	 * @return
	 */
	@DeleteMapping("/api/customer/{customerID}/beneficiary/{beneficiaryID}")
	public ResponseEntity<List<BeneficiaryAccount>> deleteBeneficary(@Valid @PathVariable Integer customerID,
			@Valid @PathVariable Integer beneficiaryID) {
		beneficiaryService.deleteBeneficiaryAccounts(beneficiaryID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
