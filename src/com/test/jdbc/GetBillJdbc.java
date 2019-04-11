package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
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
import com.test.split.SplitMoney;

public class GetBillJdbc {

	public static void main(String[] args) {

				
		CreateSession sessionObject= new CreateSession();
		
		Session session = sessionObject.getSession();
		

		try {
			// logic to save and retrive data
			
			
			System.out.println("Transaction begins!");

			session.beginTransaction();
			
			System.out.println("Before retriveing object to database!");
			//BillList bill= (BillList) session.get(BillList.class, 1);
			
			
			Query query = session.createQuery(" from BillList "
													
													);
			
			//query.setParameter("theBillId", 1);
			
			ArrayList<BillList> billList= (ArrayList<BillList>) query.list();
			
			
			
			SplitMoney split = new SplitMoney(4);
			
			for (BillList bill : billList) {
				System.out.println(bill);	
				split.processBill(bill);
				
			}
			
			System.out.println("output is here----->");
			for (int[] array : split.getTwoDiArray()) {
				System.out.println(Arrays.toString(array));	
			}
			
			
				

			String temp = "success";

			try {
				
			} catch (Exception exc) {
				exc.printStackTrace();
				temp = "failed";
			}

			System.out.println(temp);
		

			System.out.println("After retriving Object to database!");
			
			session.getTransaction().commit();
			
			System.out.println("here you go-------->");
			

		} finally {
			//factory.close();
		}

	}

}
