package com.splitwise.demo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.splitwise.demo.modal.BillObject;
import com.test.jdbc.CreateSessionInterface;
import com.test.jdbc.modal.BillDetails;
import com.test.jdbc.modal.BillList;
import com.test.split.SplitMoney;

@Repository
public class BillDao implements BillDaoInterface {

	
	
	@Autowired
	CreateSessionInterface sessionObject;
	
	static Session session;
	
	@PostConstruct
	public void init(){
		session = sessionObject.getSession();
		
	}
	
	/* (non-Javadoc)
	 * @see com.splitwise.demo.dao.AddBillDaoInterface#addBill(com.splitwise.demo.modal.BillObject)
	 */
	@Override
	public boolean addBill(BillList bill)
	{
			/*SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
							.addAnnotatedClass(BillObject.class)
							.buildSessionFactory();
			
			Session session = factory.getCurrentSession();*/
			
		session = sessionObject.getSession();
		BillDetails billDetail1= new BillDetails("subbu", 10);
		BillDetails billDetail2= new BillDetails("kailash", 20);
		bill.addBillDetails(billDetail1);
		bill.addBillDetails(billDetail2);
			try
			{
			//logic to save and retrive data
			//BillObject bill = new BillObject("snacks",100,"kailash",new String[] {"subramanian"});
			
			System.out.println("Transaction begins!");
			
			session.beginTransaction();
			
			System.out.println("Before saving object to database!");
			session.save(bill);
			session.save(billDetail1);
			session.save(billDetail2);
					
			System.out.println("After Saving Object to database!");
			session.getTransaction().commit();
			
			
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
				return false;
			}
			finally
			{
			session.clear();
			//session.flush();
			//factory.close();
			}

				
		return true;
	}

	@Override
	public List<BillObject> getBillList() {
		
		/*SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
						.addAnnotatedClass(BillObject.class)
						.buildSessionFactory();
		
		Session session = factory.getCurrentSession();*/
		session = sessionObject.getSession();
		List<BillObject> billList = null;
		
		try
		{
		//logic to save and retrive data
		//BillObject bill = new BillObject("snacks",100,"kailash",new String[] {"subramanian"});
		
		System.out.println("Transaction begins!");
		
		session.beginTransaction();
		
		System.out.println("Before Retriving Bill List from database!");
		
		billList = session.createQuery("from BillObject"
								+" ORDER BY billId DESC").list();
		
				
		System.out.println("After Retriving Bill List from database!");
		session.getTransaction().commit();
		
		
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
			
		}
		finally
		{
		session.clear();
		//session.flush();
		//factory.close();
		}

		
		return billList;
	}

	@Override
	public ArrayList<BillList> getBillListAndDetails() {
		session = sessionObject.getSession();
		ArrayList<BillList> billListAndDetails;
		try {
			// logic to save and retrive data
			
			
			System.out.println("Transaction begins!");

			session.beginTransaction();
			
			System.out.println("Before retriveing object from database!");
			//BillList bill= (BillList) session.get(BillList.class, 1);
			
			
			Query query = session.createQuery(" from BillList "
													
													);
			
			//query.setParameter("theBillId", 1);
			
			billListAndDetails= (ArrayList<BillList>) query.list();
			
				

			System.out.println("After retriving Object from database!");
			
			session.getTransaction().commit();
			
			
			

		} finally {
			
			session.clear();
			//factory.close();
		}

		return billListAndDetails;
	}
	
}
