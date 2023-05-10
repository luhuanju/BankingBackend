package com.cogent.bankingsys.service;

import java.util.List;

import com.cogent.bankingsys.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.bankingsys.entity.CustomersAccount;
import com.cogent.bankingsys.repo.AccountRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo accountRepo;

//	public CustomersAccount createAccont(Account aCustomerAccount) {
//		return accountRepo.save(aCustomerAccount);
//	}


	public List<Account> getAllAccoubnt(long costomerId) {
		return accountRepo.findByCustomerId(costomerId);
	}

	public List<Account> findAll() {
		return accountRepo.findAll();
	}
}
