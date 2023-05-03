package com.cogent.bankingsys.repo;

import com.cogent.bankingsys.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    @Override
    Optional<Account> findById(Long aLong);
}
