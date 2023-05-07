package com.cogent.bankingsys.repo;

import com.cogent.bankingsys.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustRepository extends JpaRepository<Customer, Long> {

    @Override
    Optional<Customer> findById(Long along);
    Optional<Customer> findByUsernameAndPassword(String username,String password);
}
