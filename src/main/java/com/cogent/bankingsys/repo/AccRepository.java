package com.cogent.bankingsys.repo;

import com.cogent.bankingsys.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccRepository extends JpaRepository<Account, Long> {

    @Override
    Optional<Account> findById(Long aLong);

    @Query("SELECT e FROM Account e WHERE e.accountNumber = :accountNo")
    Account findByAccountNumber(@Param("accountNo") long accountNo);

}
