package com.infinite.Library;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ManagedBean(name="bookRequestBean")
@RequestScoped
@SessionScoped
@Table(name="book_requests")
public class BookRequest {
	@Id
	@Column(name="id")
    private int id;
	
	@Column(name="teacher_name")
    private String teacher_name;
	
	@Column(name="book_title")
    private String book_title;
	
	@Column(name="reason")
    private String reason;
	
	@Override
	public String toString() {
		return "BookRequest [id=" + id + ", teacher_name=" + teacher_name + ", book_title=" + book_title + ", reason="
				+ reason + ", status=" + status + ", created_at=" + "]";
	}

	@Column(name="status")
	 private String status = "pending";


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}
