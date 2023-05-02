package com.cogent.bankingsys.entity;

import com.cogent.bankingsys.entity.enumClass.AccountStatus;
import com.cogent.bankingsys.entity.enumClass.DBCR;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;

    @Column(name = "date")
    private Date date;

    @Column(name = "Reference")
    private String Reference;

    @Column(name = "amount")
    private Long amount;

    @Enumerated(EnumType.STRING)
    private DBCR dbcr;

    public Transaction(Long transactionId, Account account, Date date, String reference, Long amount, DBCR dbcr) {
        this.transactionId = transactionId;
        this.account = account;
        this.date = date;
        Reference = reference;
        this.amount = amount;
        this.dbcr = dbcr;
    }

    public Transaction() {

    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReference() {
        return Reference;
    }

    public void setReference(String reference) {
        Reference = reference;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public DBCR getDbcr() {
        return dbcr;
    }

    public void setDbcr(DBCR dbcr) {
        this.dbcr = dbcr;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", account=" + account +
                ", date=" + date +
                ", Reference='" + Reference + '\'' +
                ", amount=" + amount +
                ", dbcr=" + dbcr +
                '}';
    }
}
