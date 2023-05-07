package com.cogent.bankingsys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payload")
@Getter
@Setter
public class Payload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payloadId;

    @Column(name = "fromAccNumber")
    private Long fromAccNumber;

    @Column(name = "toAccNumber")
    private Long toAccNumber;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "reason")
    private String reason;

    public Payload(Long payloadId, Long fromAccNumber, Long toAccNumber, Long amount, String reason) {
        this.payloadId = payloadId;
        this.fromAccNumber = fromAccNumber;
        this.toAccNumber = toAccNumber;
        this.amount = amount;
        this.reason = reason;
    }

    public Payload() {

    }

    @Override
    public String toString() {
        return "Payload{" +
                "payloadId=" + payloadId +
                ", fromAccNumber=" + fromAccNumber +
                ", toAccNumber=" + toAccNumber +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                '}';
    }
}
