package com.splitwise.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.splitwise.demo.modal.BillObject;
import com.test.jdbc.modal.BillList;


public interface BillServiceInterface {

	boolean addBill(BillList billObj);
	
	List<BillObject> getBillList();
	
	ArrayList<BillList> getBillListAndDetails();

}