package com.infinite.Hib;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class EmployInsert {

	public static void main(String[] args) {
		Employ employ = new Employ();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employ Id  ");
		employ.setEmpID(sc.nextInt());
		
		
		System.out.println("Enter Employ Name  ");
		employ.setname(sc.next());
		
		System.out.println("Enter Designation  ");
		employ.setDesignation(sc.next());
		
		System.out.println("Enter Experience  ");
		employ.setExperience(sc.next());
		
		System.out.println("Enter Salary  ");
		employ.setSalary(sc.nextDouble());
		
		System.out.println("Enter Age");
		employ.setAge(sc.nextInt());
		
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(employ);
		t.commit();
	}
}