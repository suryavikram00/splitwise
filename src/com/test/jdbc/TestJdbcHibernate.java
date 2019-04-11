package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.splitwise.demo.modal.BillToUserMap;
import com.splitwise.demo.modal.TestBillObject;
import com.test.jdbc.modal.Course;
import com.test.jdbc.modal.Instructor;
import com.test.jdbc.modal.InstructorDetail;

public class TestJdbcHibernate {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// logic to save and retrive data
			Instructor tempInstructor= new Instructor("raghag","vikram","surya@gmail.com" );
					
			InstructorDetail tempInstructorDetail= new InstructorDetail("raghag", "playing football");
				
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//for one to many mapping
			/*tempInstructor.addCourse(new Course("java"));
			tempInstructor.addCourse(new Course("java"));
			tempInstructor.addCourse(new Course("java"));*/
			
			System.out.println("Transaction begins!");

			session.beginTransaction();
			
			//Instructor tempInstructor = (Instructor) session.get(Instructor.class, 1);
			//Course tempCourse = (Course) session.get(Course.class, 1);
			Course course1= new Course("sql");
			Course course2= new Course("sqql");
			
			//System.out.println(tempCourse.getInstructor());
			
			tempInstructor.addCourse(course1);
			tempInstructor.addCourse(course2);
			
			

			System.out.println("Before saving object to database!");

			String temp = "success";

			try {
				session.save(tempInstructor);
				session.save(course1);
				session.save(course2);
			} catch (Exception exc) {
				exc.printStackTrace();
				temp = "failed";
			}

			System.out.println(temp);
			//System.out.println(tempInstructor);

			System.out.println("After Saving Object to database!");
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
