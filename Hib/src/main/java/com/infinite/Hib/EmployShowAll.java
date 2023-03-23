package com.infinite.Hib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class EmployShowAll {
	public static void main(String[] args) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Query q= s.createQuery("from Employ");
		List<Employ> employList = q.list();
		for (Employ employ : employList) {
			System.out.print("Employ Id " +employ.getEmpID());
			System.out.print("Employ Name  " +employ.getname());
			System.out.print("Age  " +employ.getAge());
			System.out.print("Salary  " +employ.getSalary());
			System.out.print("Designation  " +employ.getDesignation());
			System.out.println("Experience  " +employ.getExperience());
			
		}
	}
}