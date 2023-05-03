package com.cogent.bankingsys.controller;

import com.cogent.bankingsys.entity.Transaction;
import com.cogent.bankingsys.repo.TransactionRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/transaction")

public class TransactionController {

    @Autowired
    TransactionRepo transactionRepo;

    @GetMapping(value = "/getTransaction")
    public List<Transaction> getTransaction(){
        return transactionRepo.findAll();
    }

    @PostMapping(value = "/addTransaction")
    public Transaction addTransaction(@Valid @RequestBody Transaction transaction){
        return transactionRepo.save(transaction);
    }

    @PutMapping(value = "/updateTransaction/{id}")
    public ResponseEntity<Transaction> updateTransaction (@PathVariable("id") long id, @RequestBody Transaction newTransaction){

        Optional<Transaction> existingTransac = transactionRepo.findById(id);

        if (existingTransac.isPresent()){
            Transaction tempTransaction = existingTransac.get();
//          // only change the Amount
            tempTransaction.setAmount(newTransaction.getAmount());

            return new ResponseEntity<>(transactionRepo.save(tempTransaction), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteTransaction/{id}")
    public void deleteTransaction(@PathVariable("id") long id){
        transactionRepo.deleteById(id);
    }

}
