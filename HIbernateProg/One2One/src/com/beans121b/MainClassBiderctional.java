package com.beans121b;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MainClassBiderctional {

	public static void main(String[] args) {

		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();

		Transaction t = session.beginTransaction();

		//fetch(session);

		persist(session, t);

	}

	protected static void persist(Session session, Transaction t) {
		Addressb addressb = new Addressb();
		addressb.setArea("arae");
		addressb.setCity("city");
		addressb.setAddId(1);

		//session.save(addressb);

		Employeeb employeeb = new Employeeb();
		employeeb.setFirstName("firstName");
		employeeb.setLastName("lastname");
		employeeb.setAddressb(addressb);
		employeeb.setId(1);
		session.save(employeeb);

		t.commit();// transaction is committed
		session.close();
		System.out.println("successfully saved");
	}

	// ------------------bidirectional mapping fetching
	// example-----------------------//
	private static void fetch(Session session) {

		Transaction t = session.beginTransaction();

		List addlist = session.createQuery("FROM Addressb").list();

		Addressb addressb = (Addressb) addlist.get(0);

		System.out.println("employeeb    " + addressb.getEmployeeb().getFirstName());

	}
}
