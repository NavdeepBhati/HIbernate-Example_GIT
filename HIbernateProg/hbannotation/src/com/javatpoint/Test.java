package com.javatpoint;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Test {
	
	
private static SessionFactory sessionFactoryObj;

public static void main(String[] args) {
	//Session session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
	buildSessionFactory();
	Session session = sessionFactoryObj.openSession();

	
	Transaction t=session.beginTransaction();
	
	Employee e1=new Employee();
	e1.setId(1001);
	e1.setFirstName("sonoo");
	e1.setLastName("jaiswal");
	
	Employee e2=new Employee();
	e2.setId(1002);
	e2.setFirstName("vimal");
	e2.setLastName("jaiswal");
	
	session.persist(e1);
	session.persist(e2);
	
	t.commit();
	session.close();
	System.out.println("successfully saved");
}

private static SessionFactory buildSessionFactory() {
	Configuration configObj = new Configuration();
	configObj.configure("hibernate.cfg.xml");

	ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
	 sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
	return sessionFactoryObj;
}

}
