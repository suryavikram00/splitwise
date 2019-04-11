package com.splitwise.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.splitwise.demo.modal.BillObject;
import com.splitwise.demo.service.BillServiceInterface;
import com.test.jdbc.modal.BillList;
import com.test.split.SplitMoney;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GroupBalances {
	
	@Autowired
	private BillServiceInterface billService;
	
	@Autowired
	private SplitMoney splitMoney;
	
	
	
	
	
	@RequestMapping(value = "/getGroupBalances", method = RequestMethod.GET)
	public int[][] getBills( )
	{
		
			
			 
				splitMoney.setArraySize(4);
				
				for (BillList bill :  billService.getBillListAndDetails()) {
					System.out.println(bill);	
					splitMoney.processBill(bill);
					
				}
				
				System.out.println("output is here----->");
				for (int[] array : splitMoney.getTwoDiArray()) {
					System.out.println(Arrays.toString(array));	
				}
			
			 
			 return splitMoney.getTwoDiArray();
	}
}
