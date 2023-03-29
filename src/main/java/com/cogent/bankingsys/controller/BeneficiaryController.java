package com.cogent.bankingsys.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.bankingsys.repo.BeneficiaryRepository;
import com.cogent.bankingsys.entity.Beneficiary;

@RestController
@RequestMapping("/api/staff/beneficiary")
public class BeneficiaryController {
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @GetMapping
    // @PreAuthorize("hasRole('ROLE_STAFF')")
    public ResponseEntity<List<Beneficiary>> getBeneficiariesToApprove() {
        List<Beneficiary> beneficiariesToApprove = beneficiaryRepository.findByApproved("YES");
        if (beneficiariesToApprove.isEmpty()) {
            return ResponseEntity.ok(new ArrayList<>());
        } else {
            return ResponseEntity.ok(beneficiariesToApprove);
        }
    }

    @PutMapping
    public ResponseEntity<?> approveBeneficiary(@RequestBody Beneficiary beneficiary) {
        // find the corresponding beneficiary record in the database
        Optional<Beneficiary> optionalBeneficiary = beneficiaryRepository
                .findByFromCustomerAndBeneficiaryAcNoAndBeneficiaryAddedDate(beneficiary.getFromCustomer(),
                        beneficiary.getBeneficiaryAcNo(), beneficiary.getBeneficiaryAddedDate());

        if (optionalBeneficiary.isPresent()) {
            Beneficiary existingBeneficiary = optionalBeneficiary.get();

            // update the approval status of the beneficiary record
            existingBeneficiary.setApproved(beneficiary.getApproved());
            beneficiaryRepository.save(existingBeneficiary);

            // return the updated beneficiary record
            return ResponseEntity.ok(existingBeneficiary);
        } else {
            // no matching beneficiary record found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No matching beneficiary found");
        }
    }
}
