package com.cogent.bankingsys.service.serviceImpl;

import com.cogent.bankingsys.entity.Account;
import com.cogent.bankingsys.entity.Customer;
import com.cogent.bankingsys.repo.AccRepository;
import com.cogent.bankingsys.service.AccService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccServiceImpl implements AccService {
    @Autowired
    private AccRepository accountRepo;

    @Override
    public Account saveAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Optional<Account> findByAccountId(long accountId) {
        return accountRepo.findById(accountId);
    }

    @Override
    public List<Account> findAll() {
        return accountRepo.findAll();
    }

    @Override
    public Account findByAccountNumber(long accountNo) {

        return accountRepo.findByAccountNumber(accountNo);
    }


    @Transactional
    public void updateAccount(Long accountId, Account account) {
        Optional<Account> optionalEntity = accountRepo.findById(accountId);
        if (optionalEntity.isPresent()) {
            Account entity = optionalEntity.get();
            entity=account;
            accountRepo.save(entity);
        }
    }
}
