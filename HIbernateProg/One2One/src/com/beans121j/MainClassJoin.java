package com.beans121j;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MainClassJoin {

	
	
	public static void main(String[] args) {

		Session session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		
		fetch(session);
		
		
	
 //--------------------------------save------------------------------------------------------------//
/* 	Addressj addressb = new Addressj();
		addressb.setArea("arae");
		addressb.setCity("city");
		addressb.setAddId(7);
		
		session.save(addressb);
		
		Employeej employeeb = new Employeej();
		employeeb.setFirstName("firstName");
		employeeb.setLastName("lastname");
		employeeb.setAddressb(addressb);
		employeeb.setId(7);
		session.save(employeeb);
		
		t.commit();// transaction is committed
		session.close();
		System.out.println("successfully saved");
*/		
		

		
		
			


	}
	
	//------------------bidirectional mapping fetching example-----------------------//
	private static void fetch(Session session) {
		
		Transaction t=session.beginTransaction();
		
        List addlist = session.createQuery("FROM Addressj").list();
        
        Addressj addj = (Addressj) addlist.get(0);
        
        
        
        System.out.println("employeeb    " + addj.getAddId());
		
		
	}
}
