package com.beansm21;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


public class MainClass {

	public static void main(String[] args) {
		
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();

		Transaction t =session.beginTransaction();

	//	fetch(session);
		
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
		
		Serializable id11=session.save(p1);
		long id11l=(int) session.save(p1);
		
		
		Person p2 = new Person();
		p2.setPname("Ramesh2");
		//p2.setD(dlist);
		session.persist(p2);

		
		
		
		t.commit();
		session.close();
		
		System.out.println("saved successfully   ");
		
		
	}
	private static void fetch(Session session) {
		
		Transaction t=session.beginTransaction();
		
        List addlist = session.createQuery("FROM Person").list();
        
        Person p = (Person) addlist.get(0);
        
      
}
}