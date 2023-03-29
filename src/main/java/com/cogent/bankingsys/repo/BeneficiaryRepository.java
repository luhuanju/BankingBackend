package com.cogent.bankingsys.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cogent.bankingsys.entity.Beneficiary;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
    List<Beneficiary> findByApproved(String string);

    Optional<Beneficiary> findByFromCustomerAndBeneficiaryAcNoAndBeneficiaryAddedDate(Long fromCustomer,
            Long beneficiaryAcNo, LocalDate beneficiaryAddedDate);
}
