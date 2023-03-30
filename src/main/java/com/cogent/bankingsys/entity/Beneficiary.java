package com.cogent.bankingsys.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "beneficiaries")
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_customer")
    private Long fromCustomer;

    @Column(name = "beneficiary_ac_no")
    private Long beneficiaryAcNo;

    @Column(name = "beneficiary_added_date")
    private LocalDate beneficiaryAddedDate;

    private String approved;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromCustomer() {
        return fromCustomer;
    }

    public void setFromCustomer(Long fromCustomer) {
        this.fromCustomer = fromCustomer;
    }

    public Long getBeneficiaryAcNo() {
        return beneficiaryAcNo;
    }

    public void setBeneficiaryAcNo(Long beneficiaryAcNo) {
        this.beneficiaryAcNo = beneficiaryAcNo;
    }

    public LocalDate getBeneficiaryAddedDate() {
        return beneficiaryAddedDate;
    }

    public void setBeneficiaryAddedDate(LocalDate beneficiaryAddedDate) {
        this.beneficiaryAddedDate = beneficiaryAddedDate;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

}
