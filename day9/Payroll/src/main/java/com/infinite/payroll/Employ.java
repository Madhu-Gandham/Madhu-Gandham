package com.infinite.payroll;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="employ")
public class Employ {
	@Id
	@Column(name="empno")
	private int empno;
	@Column(name="empName")
	private String empName;
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	@Column(name="salary")
	private Double salary;
	@Column(name="hra")
	private Double hra;
	@Column(name="da")
	private Double da;
	@Column(name="ta")
	private Double ta;
	@Column(name="tax")
	private Double tax;
	@Column(name="pf")
	private Double pf;
	@Column(name="gross")
	private Double gross;
	@Column(name="netPay")
	private Double netPay;
	@Column(name="leaveAvailable")
	private int leaveAvailable;
	public int getLeaveAvailable() {
		return leaveAvailable;
	}
	public void setLeaveAvailable(int leaveAvailable) {
		this.leaveAvailable = leaveAvailable;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getHra() {
		return hra;
	}
	public void setHra(Double hra) {
		this.hra = hra;
	}
	public Double getDa() {
		return da;
	}
	public void setDa(Double da) {
		this.da = da;
	}
	public Double getTa() {
		return ta;
	}
	public void setTa(Double ta) {
		this.ta = ta;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getPf() {
		return pf;
	}
	public void setPf(Double pf) {
		this.pf = pf;
	}
	public Double getGross() {
		return gross;
	}
	public void setGross(Double gross) {
		this.gross = gross;
	}
	public Double getNetPay() {
		return netPay;
	}
	public void setNetPay(Double netPay) {
		this.netPay = netPay;
	}
	
	

}
