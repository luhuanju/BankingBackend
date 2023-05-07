package com.cogent.bankingsys.service;

import com.cogent.bankingsys.entity.Account;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface AccService {

    public Account saveAccount(Account account);

    public Optional<Account> findByAccountId(long accountId);

    public List<Account> findAll();

    public Account findByAccountNumber(long accountNo);

}
