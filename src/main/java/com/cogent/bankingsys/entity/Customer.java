package com.cogent.bankingsys.entity;

import com.cogent.bankingsys.entity.enumClass.CustomerStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "username")
    private String username;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "identityID")
    private String identityID;

    @Column(name = "secretQuestion")
    private String secretQuestion;

    @Column(name = "secretAnswer")
    private String secretAnswer;

    @Column(name = "status")
    private boolean status;

    public Customer(Long customerId, String username, String fullname, String password, String phone, String identityID, String secretQuestion, String secretAnswer) {
        this.customerId = customerId;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.phone = phone;
        this.identityID = identityID;
        this.secretQuestion = secretQuestion;
        this.secretAnswer = secretAnswer;
    }

    public Customer() {

    }

    @Override
        public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", identityID='" + identityID + '\'' +
                ", secretQuestion='" + secretQuestion + '\'' +
                ", secretAnswer='" + secretAnswer + '\'' +
                ", status=" + status +
                '}';
    }
}
