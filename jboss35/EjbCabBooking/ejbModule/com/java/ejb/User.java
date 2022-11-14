package com.java.ejb;

import java.io.Serializable;

public class User implements Serializable {
	
	private int userId;
	private String userName;
	private String passcode;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private String mobile;
	private String email;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", passcode=" + passcode + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", city=" + city + ", state=" + state + ", mobile=" + mobile + ", email="
				+ email + "]";
	}
	public User(int userId, String userName, String passcode, String firtName, String lastName, String city,
			String state, String mobile, String email) {
		this.userId = userId;
		this.userName = userName;
		this.passcode = passcode;
		this.firstName = firtName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.mobile = mobile;
		this.email = email;
	}
	public User() {
		
		// TODO Auto-generated constructor stub
	}
	
	

}