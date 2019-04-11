package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.splitwise.demo.modal.BillToUserMap;
import com.splitwise.demo.modal.TestBillObject;
import com.test.jdbc.modal.BillDetails;
import com.test.jdbc.modal.BillList;
import com.test.jdbc.modal.Course;
import com.test.jdbc.modal.Instructor;
import com.test.jdbc.modal.InstructorDetail;

public class TestBillJdbc {

	public static void main(String[] args) {

				
		CreateSession sessionObject= new CreateSession();
		
		Session session = sessionObject.getSession();

		try {
			// logic to save and retrive data
			
			
			BillList bill1= new BillList("food","surya", 60);
			
			BillDetails billDetail1= new BillDetails("subbu", 10);
			BillDetails billDetail2= new BillDetails("kailash", 20);
			BillDetails billDetail3= new BillDetails("gowtham", 20);
			BillDetails billDetail4= new BillDetails("surya", 10);
			
			bill1.addBillDetails(billDetail1);
			bill1.addBillDetails(billDetail2);
			bill1.addBillDetails(billDetail3);
			bill1.addBillDetails(billDetail4);
			
			BillList bill2= new BillList("Briyani","subbu", 1111);
			
			BillDetails billDetail11= new BillDetails("surya", 30);
			BillDetails billDetail12= new BillDetails("kailash", 30);
			
			bill2.addBillDetails(billDetail11);
			bill2.addBillDetails(billDetail12);
			
			System.out.println("Transaction begins!");

			session.beginTransaction();
			
			

			System.out.println("Before saving object to database!");

			String temp = "success";

			try {
				System.out.println("bill 1 is saving to db");
				session.save(bill1);
				session.save(billDetail1);
				session.save(billDetail2);
				session.save(billDetail3);
				session.save(billDetail4);
				System.out.println("bill 2 is saving to db");
				System.out.println(bill2);
				session.save(bill2);
				session.save(billDetail11);
				session.save(billDetail12);
				session.clear();
				System.out.println("whatch out--------->");
				System.out.println("bill 2 is again saving to db");
				BillList bill3=(BillList)bill2.clone();  
				bill3.setBillPrice(2122);
				System.out.println(bill3);
				session.save(bill3);
				//session.save(billDetail11);
				//session.save(billDetail12);
			} catch (Exception exc) {
				exc.printStackTrace();
				temp = "failed";
			}

			System.out.println(temp);
			//System.out.println(tempInstructor);

			System.out.println("After Saving Object to database!");
			session.getTransaction().commit();

		} finally {
			//factory.close();
		}

	}

}
