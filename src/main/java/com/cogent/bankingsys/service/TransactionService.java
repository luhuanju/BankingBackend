package com.cogent.bankingsys.service;

import com.cogent.bankingsys.entity.Transaction;
import com.cogent.bankingsys.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    public Transaction getTransactoin(long id){
        return transactionRepo.findById(id).get();
    }

    public List<Transaction> getAllTransaction(){
        List<Transaction> transactionList = new ArrayList<Transaction>();
        transactionRepo.findAll().forEach(trans -> transactionList.add(trans));

        return transactionList;
    }

    public void saveOrUpdate(Transaction transaction){
        transactionRepo.save(transaction);
    }

    public void deleteTransaction(long id){
        transactionRepo.deleteById(id);
    }


}
