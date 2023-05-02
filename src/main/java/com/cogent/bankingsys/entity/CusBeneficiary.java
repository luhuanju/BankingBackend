package com.cogent.bankingsys.entity;

import com.cogent.bankingsys.entity.enumClass.AccountType;
import com.cogent.bankingsys.entity.enumClass.Active;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "cusBeneficiary")
public class CusBeneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cusBeneficiaryId;

    // accountNumber is beneficiaryAccountNo
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "accountType")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "approved")
    private String approved;

    // accountNumber is beneficiaryAccountNo
    //  @OneToMany(mappedBy = "cusBeneficiary")
    @Column(name = "beneficiaryName")
    private String beneficiaryName;

    @Column(name = "active")
    @Enumerated(EnumType.STRING)
    private Active active;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public CusBeneficiary(Long cusBeneficiaryId, Account account, AccountType accountType, String approved, String beneficiaryName, Active active, Customer customer) {
        this.cusBeneficiaryId = cusBeneficiaryId;
        this.account = account;
        this.accountType = accountType;
        this.approved = approved;
        this.beneficiaryName = beneficiaryName;
        this.active = active;
        this.customer = customer;
    }

    public CusBeneficiary() {

    }

    public Long getCusBeneficiaryId() {
        return cusBeneficiaryId;
    }

    public void setCusBeneficiaryId(Long cusBeneficiaryId) {
        this.cusBeneficiaryId = cusBeneficiaryId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CusBeneficiary{" +
                "cusBeneficiaryId=" + cusBeneficiaryId +
                ", account=" + account +
                ", accountType=" + accountType +
                ", approved='" + approved + '\'' +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", active=" + active +
                ", customer=" + customer +
                '}';
    }
}
