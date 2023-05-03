package com.cogent.bankingsys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cogent.bankingsys.entity.BeneficiaryAccount;

@Repository
public interface BeneficiaryRepo extends JpaRepository<BeneficiaryAccount, Integer> {

}

