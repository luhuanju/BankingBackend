package com.cogent.bankingsys.service.serviceImpl;

import com.cogent.bankingsys.entity.Transaction;
import com.cogent.bankingsys.repo.TransactionRepo;
import com.cogent.bankingsys.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    @Override
    public Optional<Transaction> findByTransactionId(long transId) {
        return transactionRepo.findById(transId);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepo.findAll();
    }
}
