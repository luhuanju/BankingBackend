package com.cogent.bankingsys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.bankingsys.entity.CustomerAccount;
import com.cogent.bankingsys.repo.AccountRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo accountRepo;

	public CustomerAccount createAccont(CustomerAccount aCustomerAccount) {
		return accountRepo.save(aCustomerAccount);
	}

	public List<CustomerAccount> getAllAccoubnt(int costomerId) {
		return accountRepo.findAllById(costomerId);
	}
}
