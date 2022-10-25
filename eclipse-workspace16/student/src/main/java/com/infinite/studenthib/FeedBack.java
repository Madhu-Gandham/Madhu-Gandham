package com.infinite.studenthib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name="Feedback")
public class FeedBack {

	String fid;
	String studentName;
	String subject;
	String instructor;
	String fbValue;
	
	@Id
	@Column(name="fid")
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	
	@Column(name="studentName")
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	@Column(name="subject")
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Column(name="instructor")
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	@Column(name="fbValue")
	public String getFbValue() {
		return fbValue;
	}
	public void setFbValue(String fbValue) {
		this.fbValue = fbValue;
	}
	
}