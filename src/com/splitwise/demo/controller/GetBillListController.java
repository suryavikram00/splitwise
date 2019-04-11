package com.splitwise.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.BlobFromLocator;
import com.splitwise.demo.modal.BillObject;
import com.splitwise.demo.service.BillServiceInterface;
import com.test.jdbc.modal.BillList;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GetBillListController {
	
	@Autowired
	private BillServiceInterface billService;
	
	
	
	
	
	@RequestMapping(value = "/getBillList", method = RequestMethod.GET)
	public List<BillObject> getBills( )
	{
		
			return billService.getBillList();

	}


}
