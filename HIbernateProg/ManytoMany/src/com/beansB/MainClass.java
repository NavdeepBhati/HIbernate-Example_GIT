package com.beansB;

import java.util.List;
import java.util.Set;

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

		 persist();
		fetch();
		fetch2();

	

	}

	
	private static SessionFactory buildSessionFactory() {
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	private static void persist() {
		
		Session session = sessionFactoryObj.openSession();
		Transaction t = session.beginTransaction();
		Department d1 = new Department("HR");
		Department d2 = new Department("ENG");
		Department d3 = new Department("ADMIN");

		Person p1 = new Person("RAmessah");
		p1.getDlist().add(d1);
		p1.getDlist().add(d3);

		Person p2 = new Person("Rameash2");
		p2.getDlist().add(d2);
		p2.getDlist().add(d1);

		Person p3 = new Person("Rssamesh3");
		p3.getDlist().add(d2);

		Person p4 = new Person("Rasmesh4");
		p4.getDlist().add(d2);
		p4.getDlist().add(d3);
		p4.getDlist().add(d1);

		Person p5 = new Person("Ramesh5");
		p5.getDlist().add(d1);

		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		session.save(p5);

		t.commit();
		session.close();

		System.out.println("saved successfully ");
	}

	private static void fetch() {

		Session session = sessionFactoryObj.openSession();
		Transaction t = session.beginTransaction();

		List deplist = session.createQuery("FROM Department").list();

		System.out.println("depList size" + deplist.size());

		Department dp = (Department) deplist.get(0);

		Set<Person> plist = dp.getPlist();

		// System.out.println("PLIST "+"1 " + plist.get(0).getPname() + " 2 "
		// +plist.get(1).getPname());

		for (Person person : plist) {

			System.out.println(person.toString());
		}

		t.commit();
		session.close();

	}

	private static void fetch2() {
		Session session = sessionFactoryObj.openSession();
		Transaction t = session.beginTransaction();

		List perlist = session.createQuery("FROM Person").list();

		System.out.println("depList size" + perlist.size());
		


		Person per = (Person) perlist.get(0);

		Set<Department> dSet = per.getDlist();

		// System.out.println("PLIST "+"1 " + plist.get(0).getPname() + " 2 "
		// +plist.get(1).getPname());

		for (Department dep : dSet) {

			System.out.println(dep.toString());
		}

		
		
		t.commit();
		session.close();
		
	}

}