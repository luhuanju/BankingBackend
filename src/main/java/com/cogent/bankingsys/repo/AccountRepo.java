package com.cogent.bankingsys.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cogent.bankingsys.entity.CustomersAccount;


@Repository
public interface AccountRepo extends JpaRepository<CustomersAccount, Integer> {
	List<CustomersAccount> findByCustomerId(int customerId);
}

