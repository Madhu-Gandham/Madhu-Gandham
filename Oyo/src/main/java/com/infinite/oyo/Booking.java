package com.infinite.oyo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Booking")
public class Booking {
	
	@Id
	@Column(name="bookId")
	private String bookId;
	
	@Column(name="roomId")
	private String roomId;
	
	@Column(name="custName")
	private String custName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="bookDate")
	private Date bookDate;
	
	@Column(name="chkinDate")
	private Date chkinDate;
	
	@Column(name="chkoutDate")
	private Date chkoutDate;
	
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
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getBookDate() {
		return bookDate;
	}
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	public Date getChkinDate() {
		return chkinDate;
	}
	public void setChkinDate(Date chkinDate) {
		this.chkinDate = chkinDate;
	}
	public Date getChkoutDate() {
		return chkoutDate;
	}
	public void setChkoutDate(Date chkoutDate) {
		this.chkoutDate = chkoutDate;
	}
	
	
	
}
