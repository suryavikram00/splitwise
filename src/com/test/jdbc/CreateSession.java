 package com.test.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.splitwise.demo.modal.BillObject;
import com.test.jdbc.modal.BillDetails;
import com.test.jdbc.modal.BillList;

@Component
public class CreateSession implements CreateSessionInterface {

	private static Session session;
	
	public CreateSession()
	{
		
	}
	
	public Session getSession()
	{
		if(session==null)
		{
			
			session=setSession();
		}
		
		return session;
	}
	
	public Session setSession()
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(BillList.class)
				.addAnnotatedClass(BillDetails.class)
				.addAnnotatedClass(BillObject.class)
				.buildSessionFactory();

		session = factory.openSession();
		
		return session;
	}
	
}
