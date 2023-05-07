package com.cogent.bankingsys.service;

import com.cogent.bankingsys.entity.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface TransactionService {

    public Transaction saveTransaction(Transaction transaction);

    public Optional<Transaction> findByTransactionId(long transId);

    List<Transaction> findAll();
}
