package com.cogent.bankingsys.service;

import com.cogent.bankingsys.entity.Account;
import com.cogent.bankingsys.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepo accountRepo;

    public Account getAccount(long id){
        return accountRepo.findById(id).get();
    }

    public List<Account> getAllAccount(){
        List<Account> accountList = new ArrayList<Account>();
        accountRepo.findAll().forEach(account -> accountList.add(account));

        return accountList;
    }

    public void saveOrUpdate(Account account){
        accountRepo.save(account);
    }

    public void deleteAccount(long id){
        accountRepo.deleteById(id);
    }

}
