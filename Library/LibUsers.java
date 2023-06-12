package com.infinite.Library;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@ManagedBean(name="Lib")
@Entity
@Table(name="libusers")
public class LibUsers {
	private static final Logger logger = LogManager.getLogger(Books.class);
	public void setfirstname(String firstname) {
	    this.firstname = firstname;
	    logger.info("Setting ID to: " +firstname);
	}
	
	@Id
	
	
	private String firstname;
	private String phn_num;



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

	@Column(name="username")
	private String userName;

	@Column(name="password")
	private String password;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="securityQuestion")
	private String securityQuestion;
	
	@Column(name="answers")
	private String answers;
	
	
	
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name="dob")
	private Date dob;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
