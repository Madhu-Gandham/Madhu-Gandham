package com.infinite.canteen;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainProg {

	public static void main(String[] args) {
		SessionFactory sessionFactory= SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customer");
		List<Customer> customers = query.list();
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
