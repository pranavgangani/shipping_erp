package com.intuitbrains.model.crew;

import com.intuitbrains.common.Flag;
import com.intuitbrains.model.company.Employee;

import java.time.LocalDateTime;

public class Bank {
	private int id;
	private String bankName, accountNumber, micrCode, swiftCode, ifscCode, branchAddress;
	private Employee enteredByEmp, updatedByEmp;
	private LocalDateTime enteredDateTime, updatedDateTime;
	private Flag flag;
	private boolean isPrimary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getMicrCode() {
		return micrCode;
	}

	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

	public Employee getEnteredByEmp() {
		return enteredByEmp;
	}

	public void setEnteredByEmp(Employee enteredByEmp) {
		this.enteredByEmp = enteredByEmp;
	}

	public Employee getUpdatedByEmp() {
		return updatedByEmp;
	}

	public void setUpdatedByEmp(Employee updatedByEmp) {
		this.updatedByEmp = updatedByEmp;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean primary) {
		isPrimary = primary;
	}

	public LocalDateTime getEnteredDateTime() {
		return enteredDateTime;
	}

	public void setEnteredDateTime(LocalDateTime enteredDateTime) {
		this.enteredDateTime = enteredDateTime;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
}
