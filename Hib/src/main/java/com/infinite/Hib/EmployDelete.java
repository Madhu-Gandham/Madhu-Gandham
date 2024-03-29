package com.infinite.Hib;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class EmployDelete {

	public static void main(String[] args) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		int empID;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ ID   ");
		empID = sc.nextInt();
		Query q = s.createQuery("from Employ where empID="+empID);
		List<Employ> employList = q.list();
		if (employList.size() == 1) {
			Employ employ = employList.get(0);
			Transaction t = s.beginTransaction();
		    s.delete(employ);
		    t.commit();
		    System.out.println("Record Deleted...");
		}
	}
}