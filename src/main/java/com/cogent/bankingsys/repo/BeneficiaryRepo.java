package com.cogent.bankingsys.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cogent.bankingsys.entity.BeneficiaryAccount;

@Repository
public interface BeneficiaryRepo extends JpaRepository<BeneficiaryAccount, Integer> {

	List<BeneficiaryAccount> findByCustomerId(int customerId);

}

