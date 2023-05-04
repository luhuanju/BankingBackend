package com.cogent.bankingsys.entity;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class CustomersAccount {
	
	public CustomersAccount(int customerId, double accountBalance, String approved, String accountNumber,
			Date dateOfCreation, AccountType
			accountType) {
		super();
		this.customerId = customerId;
		this.accountBalance = accountBalance;
		this.approved = approved;
		this.accountNumber = accountNumber;
		this.dateOfCreation = dateOfCreation;
		this.accountType = accountType;
	}

	public CustomersAccount() {
	}
	private int customerId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private double accountBalance;

	private String approved;
	
	private String accountNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfCreation;

	@Enumerated(EnumType.ORDINAL)
	private AccountType accountType;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "CustomerAccount [customerId=" + customerId + ", accountBalance=" + accountBalance + ", approved="
				+ approved + ", accountNumber=" + accountNumber + ", dateOfCreation=" + dateOfCreation
				+ ", accountType=" + accountType + "]";
	}

}
