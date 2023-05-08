package com.cogent.bankingsys.repo;

import java.util.List;

import com.cogent.bankingsys.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cogent.bankingsys.entity.CustomersAccount;


@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
	List<Account> findByCustomerId(long customerId);

}

