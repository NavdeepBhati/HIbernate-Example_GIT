package com.beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MianClass {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADEMO1");
		EntityManager entitymanager = emfactory.createEntityManager();
		EntityTransaction transaction = entitymanager.getTransaction();
		
		
		
		Persons p= new Persons();
		Persons p1= new Persons();
		Persons p2= new Persons();
		Department d = new Department();
		Department d1 = new Department();
		Department d2 = new Department();
		
		entitymanager.getTransaction().begin();	
		//d.setId(222);
		p.setPname("zmonty9");
		p1.setPname("aNavdeep");
		p2.setPname("cKushalll");
		
		d.setName("devp7");
		d1.setName("devp7");
		d2.setName("devp8");
	/*
		p.setDepartment(d);
		p1.setDepartment(d);
		p2.setDepartment(d);
	*/	
		
		p.getDeptlist().add(d);
		
		p1.getDeptlist().add(d);
		p1.getDeptlist().add(d1);
		
		p2.getDeptlist().add(d);
		p2.getDeptlist().add(d1);
		p2.getDeptlist().add(d2);
		
		/*d.getPersonsList().add(p);
		d.getPersonsList().add(p1);
		d.getPersonsList().add(p2);
		*/
		
		/*d.personsList.add(p);
		d.personsList.add(p1);
		d.personsList.add(p2);
		*/
		
		
		d.getPersonsList().add(p);
		//d.getPersonsList().add(p1);
		d.getPersonsList().add(p2);
		

		d1.getPersonsList().add(p);
		//d1.getPersonsList().add(p1);
		//d1.getPersonsList().add(p2);
		

		d2.getPersonsList().add(p);
		d2.getPersonsList().add(p1);
		d2.getPersonsList().add(p2);
		
		
		
		//entitymanager.persist(d1);
		entitymanager.persist(p);
		
		entitymanager.persist(p1);
		//entitymanager.persist(d2);
		entitymanager.persist(p2);
		entitymanager.persist(d);
		entitymanager.persist(d1);
		entitymanager.persist(d2);
		
	//	d.setPersonsList(pl);
		//p.setDepartment(d);
		//entitymanager.merge();
		//d.setPersons(p);
	
		
		entitymanager.getTransaction().commit();
	}
	
	
}
