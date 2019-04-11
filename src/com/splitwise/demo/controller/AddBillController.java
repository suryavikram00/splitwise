package com.splitwise.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.splitwise.demo.modal.BillObject;
import com.splitwise.demo.service.BillServiceInterface;
import com.test.jdbc.modal.BillList;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AddBillController {
	
	@Autowired
	private BillServiceInterface billService;
	
	@Autowired
	private BillList billObj;
	
	@RequestMapping(value = "/addBill", method = RequestMethod.POST)
	public String[] addBill( @RequestBody BillList bill)
	{
		System.out.println(bill);
		
		billObj.setDescription(bill.getDescription());
		billObj.setBillPrice(bill.getBillPrice());
		billObj.setPaidBy(bill.getPaidBy());
		
		
		if(billService.addBill(billObj))
		{
			return new String[]{"Success! Data is inserted in the DB"};
		}
		
		return new String[]{"Failure! There is some Error"};
	}
	
	



}
