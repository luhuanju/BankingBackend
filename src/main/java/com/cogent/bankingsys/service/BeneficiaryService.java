package com.cogent.bankingsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.bankingsys.entity.BeneficiaryAccount;
import com.cogent.bankingsys.repo.BeneficiaryRepo;

@Service
public class BeneficiaryService {

	@Autowired
	private BeneficiaryRepo beneficiaryRepo;

	public BeneficiaryAccount createAccont(BeneficiaryAccount account) {
		return beneficiaryRepo.save(account);
	}
}
