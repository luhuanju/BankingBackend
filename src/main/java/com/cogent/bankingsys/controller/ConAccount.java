package com.cogent.bankingsys.controller;

import com.cogent.bankingsys.entity.Account;
import com.cogent.bankingsys.repo.AccountRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/acc")

public class ConAccount {

    @Autowired
    AccountRepo accountRepo;

    @GetMapping(value = "/getAccount")
    public List<Account> getAccount(){
        return accountRepo.findAll();
    }

    @PostMapping(value = "/addAccount")
    public Account addAccount(@Valid @RequestBody Account account){
        return accountRepo.save(account);
    }

    @PutMapping(value = "/updateAccount/{id}")
    public ResponseEntity<Account> updateAccount (@PathVariable("id") long id, @RequestBody Account newAccount){

        Optional<Account> existingAcc = accountRepo.findById(id);

        if (existingAcc.isPresent()){
            Account temAccount = existingAcc.get();
//          // only change the Approved Yes/No
            temAccount.setApproved(newAccount.getApproved());

            return new ResponseEntity<>(accountRepo.save(temAccount), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteAccount/{id}")
    public void deleteAccount(@PathVariable("id") long id){
        accountRepo.deleteById(id);
    }



}
