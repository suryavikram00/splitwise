package com.splitwise.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splitwise.demo.dao.BillDaoInterface;
import com.splitwise.demo.modal.BillObject;
import com.test.jdbc.modal.BillList;

@Service
public class BillService implements BillServiceInterface {
	
	@Autowired
	private BillDaoInterface BillDao;
	
	/* (non-Javadoc)
	 * @see com.splitwise.demo.service.AddBillServiceInterface#addBill(com.splitwise.demo.modal.BillObject)
	 */
	@Override
	public boolean addBill(BillList bill)
	{
		return  BillDao.addBill(bill);
	}

	@Override
	public List<BillObject> getBillList() {
		
		return BillDao.getBillList();
	}

	@Override
	public ArrayList<BillList> getBillListAndDetails() {
		// TODO Auto-generated method stub
		return BillDao.getBillListAndDetails();
	}

}
