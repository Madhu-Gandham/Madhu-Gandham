package com.infinite.Library;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@ManagedBean(name="admin")
@Entity
@Table(name="admin")
public class Admin {
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getPhn_num() {
		return phn_num;
	}
	public void setPhn_num(String phn_num) {
		this.phn_num = phn_num;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public static Logger getLogger() {
		return logger;
	}

	private static final Logger logger = LogManager.getLogger(Books.class);
	public void setfirstname(String firstname) {
	    this.firstname = firstname;
	    logger.info("Setting ID to: " +firstname);
	}
	
	@Id
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="phn_num")
	private String phn_num;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="dob")
	private Date dob;
	
	
	

}
