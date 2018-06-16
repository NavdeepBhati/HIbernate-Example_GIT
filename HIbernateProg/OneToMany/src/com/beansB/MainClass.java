package com.beansB;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainClass {

	static SessionFactory sessionFactoryObj;

	public static void main(String[] args) {

		buildSessionFactory();

		// Session session = new
		// AnnotationConfiguration().configure().buildSessionFactory().openSession();

		persist();
		fetch();
		System.exit(1);
	}

	private static SessionFactory buildSessionFactory() {
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	private static void persist() {

		Session session = sessionFactoryObj.openSession();

		Transaction t = session.beginTransaction();

		Department d1 = new Department(1, "HR");
		Department d2 = new Department(2, "ENG");
		Department d3 = new Department(3, "ADMIN");

		session.save(d1);
		session.save(d2);
		session.save(d3);

		Person p1 = new Person("RAmesh", d1);
		Person p2 = new Person("Ramesh2", d1);
		Person p3 = new Person("Ramesh3", d2);
		Person p4 = new Person("Ramesh4", d1);
		Person p5 = new Person("Ramesh5", d1);

		session.persist(p1);
		session.persist(p2);
		session.persist(p3);
		session.persist(p4);
		session.persist(p5);

		t.commit();
		session.close();
		System.out.println("saved successfully ");
	}

	private static void fetch() {
		Session session = sessionFactoryObj.openSession();
		Transaction t = session.beginTransaction();

		List<Department> deplist = session.createQuery("FROM Department").list();

		System.out.println("depList size" + deplist.size());

		Department dp = (Department) deplist.get(0);

		List<Person> plist = dp.getPlist();

		Person p =(Person) session.get(Person.class, 4);
		
		System.out.println(p);
		
		
		System.out.println("PLIST  " + "1  " + plist.get(0).getPname() + "  2  " + plist.get(1).getPname());

		t.commit();
		session.close();

	}
}