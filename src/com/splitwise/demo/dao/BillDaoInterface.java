package com.splitwise.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.splitwise.demo.modal.BillObject;
import com.test.jdbc.modal.BillList;


public interface BillDaoInterface {

	boolean addBill(BillList bill);
	
	List<BillObject> getBillList();
	
	ArrayList<BillList> getBillListAndDetails();

}