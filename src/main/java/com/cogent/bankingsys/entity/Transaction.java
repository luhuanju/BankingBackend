package com.cogent.bankingsys.entity;

import com.cogent.bankingsys.entity.enumClass.DBCR;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "date")
    private Date date;

    @Column(name = "Reference")
    private String Reference;

    @Column(name = "amount")
    private Long amount;

    @Enumerated(EnumType.STRING)
    private DBCR dbcr;

//    @Column(name = "accountId")
//    private long accountId;

    @Column(name = "payloadId")
    private long payloadId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    @JsonIgnoreProperties("transaction")
    private Account account;


    public Transaction(Long transactionId, Date date, String reference, Long amount, DBCR dbcr, long accountId, long payloadId) {
        this.transactionId = transactionId;
        this.date = date;
        Reference = reference;
        this.amount = amount;
        this.dbcr = dbcr;
//        this.accountId = accountId;
        this.payloadId = payloadId;
    }

    public Transaction() {

    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", date=" + date +
                ", Reference='" + Reference + '\'' +
                ", amount=" + amount +
                ", dbcr=" + dbcr +
//                ", accountId=" + accountId +
                ", payloadId=" + payloadId +
                '}';
    }
}
