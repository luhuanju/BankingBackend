package com.cogent.bankingsys.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class BeneficiaryAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private int customerId;

	@NotBlank
	private String accountNumber;

	@Enumerated(EnumType.ORDINAL)
	private AccountType accountType;

	private String approved;

	public BeneficiaryAccount() {
		super();
	}

	public BeneficiaryAccount(int id, int customerId, @NotBlank String accountNumber, AccountType accountType,
			String approved) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.approved = approved;
	}


	@Override
	public String toString() {
		return "BeneficiaryAccount [id=" + id + ", customerId=" + customerId + ", accountNumber=" + accountNumber
				+ ", accountType=" + accountType + ", approved=" + approved + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

}
