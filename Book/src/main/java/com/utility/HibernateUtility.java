package com.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static SessionFactory factory;

	static {
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			System.out.println("SessionFactory initialized successfully.");
		} catch (Throwable ex) {
			System.err.println("SessionFactory creation failed: " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (factory == null) {
			System.err.println("SessionFactory is null, reinitializing...");
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} else if (factory.isClosed()) {
			System.err.println("SessionFactory was closed, reinitializing...");
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}

	public static void closeSessionFactory() {
		if (factory != null && !factory.isClosed()) {
			factory.close();
			System.out.println("SessionFactory closed.");
		}
	}
}
