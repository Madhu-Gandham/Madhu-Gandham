package com.infinite.Library;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Entity
@ManagedBean(name="books")
@RequestScoped
@SessionScoped
@Table(name="Books1")
public class Books {
	private static final Logger logger = LogManager.getLogger(Books.class);
	public void setId(int id) {
	    this.id = id;
	    logger.info("Setting ID to: " + id);
	}
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="author")
	private String author;
	
	@Column(name="edition")
	private String edition;
	
	@Column(name="dept")
	private String dept;
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Column(name="totalBooks")
	private int totalBooks;
	
	@Transient
	private List<Integer> selectedBooks;
	
	public List<Integer> getSelectedBooks() {
		return selectedBooks;
	}
	public void setSelectedBooks(List<Integer> selectedBooks) {
		this.selectedBooks = selectedBooks;
	}
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	public int getTotalBooks() {
		return totalBooks;
	}
	public void setTotalBooks(int totalBooks) {
		this.totalBooks = totalBooks;
	}
	@Override
	public String toString() {
	    return "Books{" +
	            "id=" + id +
	            ", name='" + name + '\'' +
	            ", author='" + author + '\'' +
	            ", edition='" + edition + '\'' +
	            ", dept='" + dept + '\'' +
	            ", totalBooks=" + totalBooks +
	            '}'; 
	}
}