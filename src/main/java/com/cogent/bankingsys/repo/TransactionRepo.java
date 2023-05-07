package com.cogent.bankingsys.repo;

import com.cogent.bankingsys.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    @Override
    Optional<Transaction> findById(Long along);
}
