package com.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MainClass {

	public static void main(String[] args) {

		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();

		Transaction t = session.beginTransaction();
			

		//fetch(session);
		fetch2b(session);

		// persist(session, t);

	}

	protected static void persist(Session session, Transaction t) {
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
		p1.setD(dlist);

		Serializable id11 = session.save(p1);
		long id11l = (int) session.save(p1);

		Person p2 = new Person();
		p2.setPname("Ramesh2");
		// p2.setD(dlist);
		session.persist(p2);

		int id1 = p1.getId();
		int id2 = p2.getId();

		t.commit();
		session.close();

		System.out.println("Ser" + id11.toString() + "  " + id11 + "  " + id11l);
		System.out.println("saved successfully   " + id1 + "   " + id2);
	}

	private static void fetch(Session session) {

		Transaction t = session.beginTransaction();

		List addlist = session.createQuery("FROM Person").list();

		Person p = (Person) addlist.get(0);

		List<Department> dlist = p.getD();

		System.out.println("employeeb    " + dlist.get(0).getName());

	}

	private static void fetch2b(Session session) {

		Transaction t = session.beginTransaction();

		List deplist = session.createQuery("FROM Department").list();

		Department d = (Department) deplist.get(0);


		System.out.println("employeeb    " + d.getName());

	}
}