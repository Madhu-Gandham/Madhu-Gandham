package com.infinite.Hib;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class EmploySerach {
	public static void main(String[] args) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		int empID;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ ID  ");
		empID = sc.nextInt();
		Query q = s.createQuery("from Employ where empID="+empID);
		List<Employ> employList = q.list();
		if (employList.size() == 1) {
			Employ employ = employList.get(0);
			System.out.print("Employ No " +employ.getEmpID());
			System.out.print("Employ Name  " +employ.getname());
			System.out.print("Gender  " +employ.getAge());
			System.out.print("Department  " +employ.getDesignation());
			System.out.print("Designation  " +employ.getExperience());
			System.out.println("Salary  " +employ.getSalary());
		} else {
			System.out.println("Record Not Found...");
		}
	}
}