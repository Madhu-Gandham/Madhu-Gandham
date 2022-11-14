package com.java.ejb;

import java.io.Serializable;

public class Driver  implements Serializable{
	
	
	private int driverId;
	private String  driverUserName;
	private String  driverPassword;
	private String  driverFirstName;
	private String  driverLastName;
	private String  driverCity;
	private String  driverState;
	private String  driverMobile;
	private String  driverEmail;
	private String  cabType;
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverUserName() {
		return driverUserName;
	}
	public void setDriverUserName(String driverUserName) {
		this.driverUserName = driverUserName;
	}
	public String getDriverPassword() {
		return driverPassword;
	}
	public void setDriverPassword(String driverPassword) {
		this.driverPassword = driverPassword;
	}
	public String getDriverFirstName() {
		return driverFirstName;
	}
	public void setDriverFirstName(String driverFirstName) {
		this.driverFirstName = driverFirstName;
	}
	public String getDriverLastName() {
		return driverLastName;
	}
	public void setDriverLastName(String driverLastName) {
		this.driverLastName = driverLastName;
	}
	public String getDriverCity() {
		return driverCity;
	}
	public void setDriverCity(String driverCity) {
		this.driverCity = driverCity;
	}
	public String getDriverState() {
		return driverState;
	}
	public void setDriverState(String driverState) {
		this.driverState = driverState;
	}
	public String getDriverMobile() {
		return driverMobile;
	}
	public void setDriverMobile(String driverMobile) {
		this.driverMobile = driverMobile;
	}
	public String getDriverEmail() {
		return driverEmail;
	}
	public void setDriverEmail(String driverEmail) {
		this.driverEmail = driverEmail;
	}
	public String getCabType() {
		return cabType;
	}
	public void setCabType(String cabType) {
		this.cabType = cabType;
	}
	public Driver(int driverId, String driverUserName, String driverPassword, String driverFirstName,
			String driverLastName, String driverCity, String driverState, String driverMobile, String driverEmail,
			String cabType) {
		this.driverId = driverId;
		this.driverUserName = driverUserName;
		this.driverPassword = driverPassword;
		this.driverFirstName = driverFirstName;
		this.driverLastName = driverLastName;
		this.driverCity = driverCity;
		this.driverState = driverState;
		this.driverMobile = driverMobile;
		this.driverEmail = driverEmail;
		this.cabType = cabType;
	}
	public Driver() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverUserName=" + driverUserName + ", driverPassword="
				+ driverPassword + ", driverFirstName=" + driverFirstName + ", driverLastName=" + driverLastName
				+ ", driverCity=" + driverCity + ", driverState=" + driverState + ", driverMobile=" + driverMobile
				+ ", driverEmail=" + driverEmail + ", cabType=" + cabType + "]";
	}
	
	

}