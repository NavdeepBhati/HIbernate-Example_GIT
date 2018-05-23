package com.beans;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class MianClass {

	public static void main(String[] args) {

		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();

		Transaction t = session.beginTransaction();

		// ----------------------------------------------------------------------///
		
		  Address address = new Address(1,"zipcode", "city");
		  
		  int id= (int) session.save(address);
		  
		  System.out.println("id"+id);
		  
		  
		  Employee employee = new Employee(address.getId(), "firstName",
		  "lastName");
		  
		  employee.setAddress(address); session.save(employee);
		 

		// ----------------------------------------------------------------------///

		/*Employee e = (Employee) session.get(Employee.class, 1);

		
		  Address a=(Address) session.get(Address.class, 1);
		  
		  System.out.println(a);
		  
		  System.out.println("addrss"+a.getId());
		 */

		t.commit();// transaction is committed
		session.close();

//		System.out.println(e.getId() + "   " + e.getAddress().getCity());

		
		
		
		System.out.println("successfully saved");

	}

}
