package com.cogent.bankingsys.entity;

import com.cogent.bankingsys.entity.enumClass.AccountStatus;
import jakarta.persistence.*;
import com.cogent.bankingsys.entity.enumClass.AccountType;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "accountNumber")
    private Long accountNumber;

    @Column(name = "accountType")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "accountBalance")
    private Long accountBalance;

    @Column(name = "approved")
    private String approved;

    @Column(name = "dateOfCreation")
    private Date dateOfCreation;

    @Column(name = "accountStatus")
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="account", cascade = CascadeType.ALL)
    private ArrayList<Transaction> transaction = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account", cascade = CascadeType.ALL)
    private ArrayList<CusBeneficiary> cusBeneficiary = new ArrayList<>();

    public Account(Long accountId, Long accountNumber, AccountType accountType, Long accountBalance, String approved, Date dateOfCreation, AccountStatus accountStatus, Customer customer, ArrayList<Transaction> transaction, ArrayList<CusBeneficiary> cusBeneficiary) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.approved = approved;
        this.dateOfCreation = dateOfCreation;
        this.accountStatus = accountStatus;
        this.customer = customer;
        this.transaction = transaction;
        this.cusBeneficiary = cusBeneficiary;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(ArrayList<Transaction> transaction) {
        this.transaction = transaction;
    }

    public ArrayList<CusBeneficiary> getCusBeneficiary() {
        return cusBeneficiary;
    }

    public void setCusBeneficiary(ArrayList<CusBeneficiary> cusBeneficiary) {
        this.cusBeneficiary = cusBeneficiary;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountNumber=" + accountNumber +
                ", accountType=" + accountType +
                ", accountBalance=" + accountBalance +
                ", approved='" + approved + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", accountStatus=" + accountStatus +
                ", customer=" + customer +
                ", transaction=" + transaction +
                ", cusBeneficiary=" + cusBeneficiary +
                '}';
    }
}
