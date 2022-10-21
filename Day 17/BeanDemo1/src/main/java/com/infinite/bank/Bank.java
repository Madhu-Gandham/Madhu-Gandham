package com.infinite.bank;

public class Bank {
	private int accountsNo;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private int amount;
	private String cheqFacil;
	private String accountType;
	public int getAccountsNo() {
		return accountsNo;
	}
	public void setAccountsNo(int accountsNo) {
		this.accountsNo = accountsNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCheqFacil() {
		return cheqFacil;
	}
	public void setCheqFacil(String cheqFacil) {
		this.cheqFacil = cheqFacil;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Bank() {
		
		// TODO Auto-generated constructor stub
	}
	public Bank(int accountsNo, String firstName, String lastName, String city, String state, int amount,
			String cheqFacil, String accountType) {
		
		this.accountsNo = accountsNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.amount = amount;
		this.cheqFacil = cheqFacil;
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "Bank [accountsNo=" + accountsNo + ", firstName=" + firstName + ", lastName=" + lastName + ", city="
				+ city + ", state=" + state + ", amount=" + amount + ", cheqFacil=" + cheqFacil + ", accountType="
				+ accountType + "]";
	}

}
