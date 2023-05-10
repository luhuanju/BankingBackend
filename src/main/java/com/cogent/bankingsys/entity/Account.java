package com.cogent.bankingsys.entity;

import com.cogent.bankingsys.entity.enumClass.AccountStatus;
import com.cogent.bankingsys.entity.enumClass.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "accountNumber", unique = true)
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
//    @Enumerated(EnumType.STRING)
    private boolean accountStatus;

    @Column(name = "customerId")
    private long customerId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("account")
    private List<Transaction> transaction;

    public Account(Long accountId, Long accountNumber, AccountType accountType, Long accountBalance, String approved, Date dateOfCreation, boolean accountStatus, long customerId, List<Transaction> transaction) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.approved = approved;
        this.dateOfCreation = dateOfCreation;
        this.accountStatus = accountStatus;
        this.customerId = customerId;
        this.transaction = transaction;
    }

    public Account() {

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
                ", customerId=" + customerId +
                ", transaction=" + transaction +
                '}';
    }
}
