package com.infinite.Hib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employ")
public class Employ {
	
	@Id
	@Column(name="EmpID")
	private int EmpID;
	
	@Column(name="name")
	private String  name;
	
	@Column(name="Age")
	private int Age;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="experience")
	private String experience;
	
	public int getEmpID() {
		return EmpID;
	}
	public void setEmpID(int empId) {
		EmpID = empId;
	}
	public String getname() {
		return name;
	}
	public void setname(String ename) {
		name = ename;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	

}
