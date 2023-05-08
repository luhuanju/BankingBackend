package com.cogent.bankingsys.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.cogent.bankingsys.repo.BeneficiaryRepository;
import com.cogent.bankingsys.entity.Beneficiary;

@RestController
@RequestMapping()
@CrossOrigin(origins = "*")
public class BeneficiaryController {
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;
    @PostMapping("api/costomer/{customerId}/beneficiary")
    public ResponseEntity<String> addBeneficiary(@PathVariable Long customerId,
                                                 @RequestBody Beneficiary beneficiaryRequest) {

        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setFromCustomer(customerId);
        beneficiary.setBeneficiaryAcNo(beneficiaryRequest.getBeneficiaryAcNo());
        LocalDate currentDate = LocalDate.now();
        beneficiary.setBeneficiaryAddedDate(currentDate);
        beneficiary.setApproved(beneficiaryRequest.getApproved());


        Optional<Beneficiary> optionalBeneficiary = beneficiaryRepository
                .findByFromCustomerAndBeneficiaryAcNoAndBeneficiaryAddedDate(beneficiary.getFromCustomer(),
                        beneficiary.getBeneficiaryAcNo(), beneficiary.getBeneficiaryAddedDate());

        if (!optionalBeneficiary.isPresent()) {
            beneficiaryRepository.save(beneficiary);
            return ResponseEntity.ok("Beneficiary with account number " + beneficiary.getBeneficiaryAcNo() + " added");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body("Error Message");



    }
    @GetMapping("/api/staff/beneficiary")
    // @PreAuthorize("hasRole('ROLE_STAFF')")
    public ResponseEntity<List<Beneficiary>> getBeneficiariesToApprove() {
        List<Beneficiary> beneficiariesToApprove = beneficiaryRepository.findByApproved("NO");
        if (beneficiariesToApprove.isEmpty()) {
            return ResponseEntity.ok(new ArrayList<>());
        } else {
            return ResponseEntity.ok(beneficiariesToApprove);
        }
    }

    @PutMapping("/api/staff/beneficiary")
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
