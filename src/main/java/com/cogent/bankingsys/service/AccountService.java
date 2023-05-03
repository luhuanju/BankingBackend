package com.cogent.bankingsys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.bankingsys.entity.CustomersAccount;
import com.cogent.bankingsys.repo.AccountRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo accountRepo;

	public CustomersAccount createAccont(CustomersAccount aCustomerAccount) {
		return accountRepo.save(aCustomerAccount);
	}


	public List<CustomersAccount> getAllAccoubnt(int costomerId) {
		return accountRepo.findByCustomerId(costomerId);
	}
}
