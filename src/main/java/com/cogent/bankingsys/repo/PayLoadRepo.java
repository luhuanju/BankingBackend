package com.cogent.bankingsys.repo;

import com.cogent.bankingsys.entity.PayLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PayLoadRepo extends JpaRepository<PayLoad, Long> {

    @Override
    Optional<PayLoad> findById(Long aLong);
}
