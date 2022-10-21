package com.infinite.Library;

import java.sql.Date;

public class TransReturn {
	private String UserName;
	private  int BookId;
	private Date Fromdate;
	private Date Todate;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public Date getFromdate() {
		return Fromdate;
	}
	public void setFromdate(Date fromdate) {
		Fromdate = fromdate;
	}
	public Date getTodate() {
		return Todate;
	}
	public void setTodate(Date todate) {
		Todate = todate;
	}
	
}
