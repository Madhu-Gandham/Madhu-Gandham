package com.infinite.payroll;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="leavetable")
public class LeaveTable {
	@Id
	@Column(name="leaveId")
 private int leaveId;
	
	@Column(name="empno")

 private int empno;
	@Column(name="leaveStartDate")

 private Date leaveStartDate;
	@Column(name="leaveEndDate")

 private Date leaveEndDate;
	@Column(name="noOfDays")

 private int  noOfDays;
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	@Column(name="leaveReason")

 private String leaveReason;
	@Column(name="lossOfPay")

 private Double lossOfPay;

public Double getLossOfPay() {
		return lossOfPay;
	}
	public void setLossOfPay(Double lossOfPay) {
		this.lossOfPay = lossOfPay;
	}
public int getLeaveId() {
	return leaveId;
}
public void setLeaveId(int leaveId) {
	this.leaveId = leaveId;
}
public int getEmpno() {
	return empno;
}
public void setEmpno(int empno) {
	this.empno = empno;
}
public Date getLeaveStartDate() {
	return leaveStartDate;
}
public void setLeaveStartDate(Date leaveStartDate) {
	this.leaveStartDate = leaveStartDate;
}
public Date getLeaveEndDate() {
	return leaveEndDate;
}
public void setLeaveEndDate(Date leaveEndDate) {
	this.leaveEndDate = leaveEndDate;
}

public String getLeaveReason() {
	return leaveReason;
}
public void setLeaveReason(String leaveReason) {
	this.leaveReason = leaveReason;
}

 
	

}
