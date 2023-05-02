package com.cogent.bankingsys.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "userName")
    private String username;

    @Column(name = "fullName")
    private String fullName;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
    private ArrayList<Account> account = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
    private ArrayList<CusBeneficiary> cusBeneficiary = new ArrayList<>();

    public Customer(Long customerId, String username, String fullName, String password, String phone, String identityID, String secretQuestion, String secretAnswer, ArrayList<Account> account, ArrayList<CusBeneficiary> cusBeneficiary) {
        this.customerId = customerId;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.phone = phone;
        this.identityID = identityID;
        this.secretQuestion = secretQuestion;
        this.secretAnswer = secretAnswer;
        this.account = account;
        this.cusBeneficiary = cusBeneficiary;
    }

    public Customer() {

    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullname) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentityID() {
        return identityID;
    }

    public void setIdentityID(String identityID) {
        this.identityID = identityID;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    public ArrayList<Account> getAccount() {
        return account;
    }

    public void setAccount(ArrayList<Account> account) {
        this.account = account;
    }

    public ArrayList<CusBeneficiary> getCusBeneficiary() {
        return cusBeneficiary;
    }

    public void setCusBeneficiary(ArrayList<CusBeneficiary> cusBeneficiary) {
        this.cusBeneficiary = cusBeneficiary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", identityID='" + identityID + '\'' +
                ", secretQuestion='" + secretQuestion + '\'' +
                ", secretAnswer='" + secretAnswer + '\'' +
                ", account=" + account +
                ", cusBeneficiary=" + cusBeneficiary +
                '}';
    }
}
