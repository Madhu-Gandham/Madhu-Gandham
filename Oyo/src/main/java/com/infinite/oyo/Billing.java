package com.infinite.oyo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Billing")
public class Billing {
	
	@Id
	@Column(name="bookId")
 private String bookId;
	
	@Column(name="roomId")
 private String roomId;
	
	@Column(name="noOfDays")
 private int noOfDays;
	
	@Column(name="billAmt")
 private int billAmt;
	
public String getBookId() {
	return bookId;
}
public void setBookId(String bookId) {
	this.bookId = bookId;
}
public String getRoomId() {
	return roomId;
}
public void setRoomId(String roomId) {
	this.roomId = roomId;
}
public int getNoOfDays() {
	return noOfDays;
}
public void setNoOfDays(int noOfDays) {
	this.noOfDays = noOfDays;
}
public int getBillAmt() {
	return billAmt;
}
public void setBillAmt(int billAmt) {
	this.billAmt = billAmt;
}
 
}
