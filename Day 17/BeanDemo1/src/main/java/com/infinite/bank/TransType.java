package com.infinite.bank;

import java.sql.Date;

public class TransType {
	private int accountno;
	private double transamount;
	private Date transdate;
	private String transtype;
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public double getTransamount() {
		return transamount;
	}
	public void setTransamount(double transamount) {
		this.transamount = transamount;
	}
	public Date getTransdate() {
		return transdate;
	}
	public void setTransdate(Date transdate) {
		this.transdate = transdate;
	}
	public String getTranstype() {
		return transtype;
	}
	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}

}
