package com.cogent.bankingsys.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payload")
public class PayLoad {

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

    public PayLoad(Long payloadId, Long fromAccNumber, Long toAccNumber, Long amount, String reason) {
        this.payloadId = payloadId;
        this.fromAccNumber = fromAccNumber;
        this.toAccNumber = toAccNumber;
        this.amount = amount;
        this.reason = reason;
    }

    public PayLoad() {

    }

    public Long getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(Long payloadId) {
        this.payloadId = payloadId;
    }

    public Long getFromAccNumber() {
        return fromAccNumber;
    }

    public void setFromAccNumber(Long fromAccNumber) {
        this.fromAccNumber = fromAccNumber;
    }

    public Long getToAccNumber() {
        return toAccNumber;
    }

    public void setToAccNumber(Long toAccNumber) {
        this.toAccNumber = toAccNumber;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "PayLoad{" +
                "payloadId=" + payloadId +
                ", fromAccNumber=" + fromAccNumber +
                ", toAccNumber=" + toAccNumber +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                '}';
    }
}
