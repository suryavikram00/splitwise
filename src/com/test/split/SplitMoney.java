package com.test.split;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.test.jdbc.modal.BillDetails;
import com.test.jdbc.modal.BillList;

@Component
public class SplitMoney {
	
	private ArrayList<BillList> billList;
	
	int[][] twoDiArray;
	
	public int[][] getTwoDiArray() {
		return twoDiArray;
	}

	public void setTwoDiArray(int[][] twoDiArray) {
		this.twoDiArray = twoDiArray;
	}

	private List<String> userArray;

	public ArrayList<BillList> getBillList() {
		return billList;
	}

	public void setBillList(ArrayList<BillList> billList) {
		this.billList = billList;
	}
	
	public SplitMoney(int groupSize)
	{
		twoDiArray= new int[groupSize][groupSize];
		userArray= new LinkedList<>();
		userArray.add("surya");
		userArray.add("subbu");
		userArray.add("kailash");
		userArray.add("gowtham");
		
		 
	}
	
	public SplitMoney()
	{
		
	}
	
	public void setArraySize(int groupSize) {
		twoDiArray= new int[groupSize][groupSize];
		userArray= new LinkedList<>();
		userArray.add("surya");
		userArray.add("subbu");
		userArray.add("kailash");
		userArray.add("gowtham");
	}
	
	
	public void processBill(BillList billList)
	{
	
		
		/*userArray[0]="surya";
		userArray[1]="subbu";
		userArray[2]="kailash";
		userArray[3]="gowtham";*/
		
		
		
		String temp = billList.getPaidBy();
		System.out.println("check---->"+userArray.indexOf(temp));
		
			int paidByIndex= userArray.indexOf(temp);
			twoDiArray[paidByIndex][paidByIndex]=twoDiArray[paidByIndex][paidByIndex]+billList.getBillPrice();
			
			for (BillDetails billDetails : billList.getBillDetails()) {
				processBillDetails(billDetails,paidByIndex);
			}
		
		
	}
	
	private void processBillDetails(BillDetails billdetails,int paidByIndex)
	{
		int owesByIndex= userArray.indexOf(billdetails.getOwesBy());
		
		//update row(add money) for the one who paid
		twoDiArray[paidByIndex][owesByIndex]= twoDiArray[paidByIndex][owesByIndex]
												+(billdetails.getOwesByGetsBack());
		
		//update row(subtract money) for the one who owes
		twoDiArray[owesByIndex][paidByIndex]= twoDiArray[owesByIndex][paidByIndex]
												-(billdetails.getOwesByGetsBack());
		
		//subtract in the total balances for the particular user
		//i.e [2][2] or [3][3]
		twoDiArray[owesByIndex][owesByIndex]= twoDiArray[owesByIndex][owesByIndex]
				-(billdetails.getOwesByGetsBack());
		
	}
	
	
	
	
	
	

}
