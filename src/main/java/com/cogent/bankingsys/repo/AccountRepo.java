package com.cogent.bankingsys.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cogent.bankingsys.entity.CustomerAccount;

@Repository
public interface AccountRepo extends JpaRepository<CustomerAccount, Integer> {

	List<CustomerAccount> findAllById(int customerId);
}

