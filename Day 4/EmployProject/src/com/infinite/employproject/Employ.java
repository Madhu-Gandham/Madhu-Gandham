package com.infinite.employproject;

public class Employ {
	private int empno;
	private String name;
	private Gender gender;
	private String dept;
	private String design;
	private double basic;
	@Override
	public String toString() {
		return "Gender [empno=" + empno + ", name=" + name + ", gender=" + gender + ", dept=" + dept + ", design="
				+ design + ", basic=" + basic + "]";
	}
	public Employ(int empno, String name, Gender gender, String dept, String design, double basic) {
	
		this.empno = empno;
		this.name = name;
		this.gender = gender;
		this.dept = dept;
		this.design = design;
		this.basic = basic;
	}
	public Employ() {
		
		// TODO Auto-generated constructor stub
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	
	
	
	

}
