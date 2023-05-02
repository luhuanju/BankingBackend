package com.cogent.bankingsys.entity;

import com.cogent.bankingsys.entity.enumClass.AccountStatus;
import jakarta.persistence.*;
import com.cogent.bankingsys.entity.enumClass.AccountType;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "accountType")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "accountBalance")
    private Long accountBalance;

    @Column(name = "approved")
    private String approved;

    @Column(name = "accountNumber")
    private Long accountNumber;

    @Column(name = "dateOfCreation")
    private Date dateOfCreation;

    @Column(name = "customerId")
    private String customerId;

    @Column(name = "accountStatus")
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @OneToMany(mappedBy="account")
    private ArrayList<Transaction> transaction;

    public Account(Long accountId, AccountType accountType, Long accountBalance, String approved, Long accountNumber, Date dateOfCreation, String customerId, AccountStatus accountStatus, ArrayList<Transaction> transaction) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.approved = approved;
        this.accountNumber = accountNumber;
        this.dateOfCreation = dateOfCreation;
        this.customerId = customerId;
        this.accountStatus = accountStatus;
        this.transaction = transaction;
    }

    public Account() {

    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public ArrayList<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(ArrayList<Transaction> transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountType=" + accountType +
                ", accountBalance=" + accountBalance +
                ", approved='" + approved + '\'' +
                ", accountNumber=" + accountNumber +
                ", dateOfCreation=" + dateOfCreation +
                ", customerId='" + customerId + '\'' +
                ", accountStatus=" + accountStatus +
                ", transaction=" + transaction +
                '}';
    }
}
