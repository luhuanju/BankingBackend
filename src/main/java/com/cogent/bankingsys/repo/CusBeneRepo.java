package com.cogent.bankingsys.repo;

import com.cogent.bankingsys.entity.CusBeneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CusBeneRepo extends JpaRepository<CusBeneficiary, Long> {

    @Override
    Optional<CusBeneficiary> findById(Long aLong);
}
