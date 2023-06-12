package com.infinite.Library;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class SessionHelper {
	public static SessionFactory getConnection() {
		Configuration configuration = new AnnotationConfiguration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}
}
