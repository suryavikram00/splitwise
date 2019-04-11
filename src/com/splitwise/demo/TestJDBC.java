
package com.splitwise.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.splitwise.demo.modal.BillObject;
import com.splitwise.demo.modal.BillToUserMap;
import com.splitwise.demo.modal.TestBillObject;

public class TestJDBC {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(TestBillObject.class)
								.addAnnotatedClass(BillToUserMap.class)
								
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
				
		try
		{
			//logic to save and retrive data
			TestBillObject bill = new TestBillObject("food",100);
			
			BillToUserMap billToUser = new BillToUserMap(10,"surya", "surya");
			/*
			BillToUserMap billToUser1 = new BillToUserMap(100,"surya", "surya");
			BillToUserMap billToUser2= new BillToUserMap(2000,"surya", "surya");
			BillToUserMap billToUser3 = new BillToUserMap(20,"surya", "surya");
			bill.addBillTouser(billToUser);
			bill.addBillTouser(billToUser1);
			bill.addBillTouser(billToUser2);
			bill.addBillTouser(billToUser3);*/
			
			bill.setBillToUserMap(billToUser);
			
			
			System.out.println("Transaction begins!");
			
			session.beginTransaction();
			
			System.out.println("Before saving object to database!");
			
			String temp="success";
			
			BillToUserMap getBillToUser= (BillToUserMap) session.get(BillToUserMap.class, 1);
			
			TestBillObject billObj= (TestBillObject) session.get(TestBillObject.class, 1);
			
			System.out.println(billObj.getBillToUserMap());
			
			System.out.println("-------------><-------------");
			System.out.println(getBillToUser.getBillObject());
			
			//System.out.println(deleteBill);
			
			try {
				//session.save(bill);
				//session.delete(deleteBill);
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
				temp="failed";
			}
			
			
			
			System.out.println("After Saving Object to database!");
			session.getTransaction().commit();
			
		}
		finally
		{
		    factory.close();
		}
		
								
								
		

	}

}
