package com.beansm21;

import java.io.Serializable;
import java.util.ArrayList;
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
		persistEntity();
		fetch();
	}
	private static SessionFactory buildSessionFactory() {
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	private static void persistEntity() {

		Session session = sessionFactoryObj.openSession();

		Transaction t = session.beginTransaction();

		Department d1 = new Department(1, "HR");
		Department d2 = new Department(2, "ENG");
		Department d3 = new Department(3, "ADMIN");

		session.save(d1);
		session.save(d2);
		session.save(d3);

		List<Department> dlist = new ArrayList<>();
		dlist.add(d1);
		dlist.add(d2);
		dlist.add(d3);

		Person p1 = new Person();
		p1.setPname("Ramesh");
		p1.setDepartment(d1);

		Serializable id11 = session.save(p1);
		long id11l = (int) session.save(p1);

		Person p2 = new Person();
		p2.setPname("Ramesh2");
		// p2.setD(dlist);
		session.persist(p2);

		t.commit();
		session.close();

		System.out.println("saved successfully   ");
	}


	private static void fetch() {

		Session session = sessionFactoryObj.openSession();
		Transaction t = session.beginTransaction();
		List addlist = session.createQuery("FROM Person").list();
		Person p = (Person) addlist.get(0);

		System.out.println(p);
	}
}