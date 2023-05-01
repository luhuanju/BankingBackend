package com.cogent.bankingsys.entity;

import com.cogent.bankingsys.entity.enumClass.AccountType;
import com.cogent.bankingsys.entity.enumClass.Active;
import jakarta.persistence.*;

@Entity
@Table(name = "cusBeneficiary")
public class CusBeneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cusBeneficiaryId;

    // #TODO: accountID/ accountNumber, accountType, approved from account Table?
    @Column(name = "accountNumber")
    private Long accountNumber;

    @Column(name = "accountType")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "approved")
    private String approved;

    @Column(name = "beneficiaryAccountNo")
    private Long beneficiaryAccountNo;

    @Column(name = "beneficiaryName")
    private String beneficiaryName;

    @Column(name = "active")
    @Enumerated(EnumType.STRING)
    private Active active;

    public CusBeneficiary(Long cusBeneficiaryId, Long accountNumber, AccountType accountType, String approved, Long beneficiaryAccountNo, String beneficiaryName, Active active) {
        this.cusBeneficiaryId = cusBeneficiaryId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.approved = approved;
        this.beneficiaryAccountNo = beneficiaryAccountNo;
        this.beneficiaryName = beneficiaryName;
        this.active = active;
    }

    public CusBeneficiary() {

    }

    public Long getCusBeneficiaryId() {
        return cusBeneficiaryId;
    }

    public void setCusBeneficiaryId(Long cusBeneficiaryId) {
        this.cusBeneficiaryId = cusBeneficiaryId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public Long getBeneficiaryAccountNo() {
        return beneficiaryAccountNo;
    }

    public void setBeneficiaryAccountNo(Long beneficiaryAccountNo) {
        this.beneficiaryAccountNo = beneficiaryAccountNo;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public Active getActive() {
        return active;
    }

    public void setActive(Active active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CusBeneficiary{" +
                "cusBeneficiaryId=" + cusBeneficiaryId +
                ", accountNumber=" + accountNumber +
                ", accountType=" + accountType +
                ", approved='" + approved + '\'' +
                ", beneficiaryAccountNo=" + beneficiaryAccountNo +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", active=" + active +
                '}';
    }
}
