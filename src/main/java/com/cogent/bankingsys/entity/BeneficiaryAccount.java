package com.cogent.bankingsys.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class BeneficiaryAccount {
	@Id
	private int customerId;

	@NotBlank
	private String accountNumber;

	@Enumerated(EnumType.ORDINAL)
	private AccountType accountType;

	private String approved;

	@Override
	public String toString() {
		return "BeneficiaryAccount [customerId=" + customerId + ", accountNumber=" + accountNumber + ", accountType="
				+ accountType + ", approved=" + approved + "]";
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
