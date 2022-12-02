package com.java.ejb;

import java.io.Serializable;
import java.sql.Date;

public class Booking implements Serializable{
    
	private int bookingId;
	private Date bookingDate;
	private int userId;
	private int driverId;
	private String startingLocation;
	private String  endingLocation;
	private double kilometers;
	private Status bookingStatus;
	private double billAmount;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getStartingLocation() {
		return startingLocation;
	}
	public void setStartingLocation(String startingLocation) {
		this.startingLocation = startingLocation;
	}
	public String getEndingLocation() {
		return endingLocation;
	}
	public void setEndingLocation(String endingLocation) {
		this.endingLocation = endingLocation;
	}
	public double getKilometers() {
		return kilometers;
	}
	public void setKilometers(double kilometers) {
		this.kilometers = kilometers;
	}
	public Status getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(Status bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", userId=" + userId + ", driverId="
				+ driverId + ", startingLocation=" + startingLocation + ", endingLocation=" + endingLocation
				+ ", kilometers=" + kilometers + ", bookingStatus=" + bookingStatus + ", billAmount=" + billAmount
				+ "]";
	}
	public Booking(int bookingId, Date bookingDate, int userId, int driverId, String startingLocation,
			String endingLocation, double kilometers, Status bookingStatus, double billAmount) {
		
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.userId = userId;
		this.driverId = driverId;
		this.startingLocation = startingLocation;
		this.endingLocation = endingLocation;
		this.kilometers = kilometers;
		this.bookingStatus = bookingStatus;
		this.billAmount = billAmount;
	}
	public Booking() {
		
		// TODO Auto-generated constructor stub
	}
	
	

	
}