package com.split.di;

import java.util.Arrays;
import java.util.Stack;

public class MainApp {
	
	static TransactionDetailsInterface trx;
	
	public MainApp()
	{
		trx= new TransactionDetails();
	}
	
	public static void getTransactionOnGroup(Stack<EachTransaction> tempStack)
	{
		while(!tempStack.isEmpty())
		{
			EachTransaction array = tempStack.pop();
			System.out.println("Description ---> "+array.getDescription());
			System.out.println(array.getPaidBy()+" paid Rs."+array.getPrice()+" to "+Arrays.toString(array.getSplitBy()));
		}
		
	}

	public static void main(String[] args) {
		
		//TransactionDetails trx = new TransactionDetails();
		MainApp app = new MainApp();
		trx.addUser("surya");
		trx.addUser("kailash");
		trx.addUser("subbu");
		trx.addUser("gowtham");
		
		//trx.transaction("kailash", "surya", 50);
		
		//trx.transaction("surya", "subbu", 30);
		
		trx.updatedTransaction("Lunch",100, "gowtham", new String[]{"surya"});
		trx.updatedTransaction("Expense",70, "kailash", new String[]{"gowtham"});
		trx.updatedTransaction("Gowtham",260, "subbu", new String[]{"gowtham"});
		trx.updatedTransaction("Petrol",300, "surya", new String[]{"subbu"});
		trx.updatedTransaction("Snacks",27, "kailash", new String[]{"surya"});
		trx.updatedTransaction("Snacks",30, "subbu", new String[]{"surya"});
		trx.updatedTransaction("Snacks",27, "gowtham", new String[]{"surya"});
		trx.updatedTransaction("Briyani",210, "kailash", new String[]{"surya","kailash"});
		trx.updatedTransaction("Snacks",70, "surya", new String[]{"subbu"});
		
		
		for(BalanceArrayObject array: trx.getGroupBalances())
		{
			System.out.println(array.getOwes()+" owes you Rs."+array.getAmount()+" to "+array.getOwed());
			//System.out.println(array.getOwed()+" getsback Rs."+array.getAmount()+" from "+array.getOwes());
			
		}
		
		System.out.println("<-------------------------------->");
		System.out.println("Total spendings on this Group! : "+trx.getTotalSpendings());
		System.out.println("<-------------------------------->");
		/*for(EachTransaction array: trx.getEachTransaction())
		{
			System.out.println("Description ---> "+array.getDescription());
			System.out.println(array.getPaidBy()+" paid Rs."+array.getPrice());
			
			
		}*/
		Stack<EachTransaction> tempStack = trx.getEachTransaction();
		getTransactionOnGroup(tempStack);
		
		try {
			/*System.out.println("**************************************");
			System.out.println("balance for kailash! "+trx.getUserBalances("kailash"));
			System.out.println("balance for subbu! "+trx.getUserBalances("subbu"));
			System.out.println("balance for surya! "+trx.getUserBalances("surya"));
			System.out.println("balance for gowtham! "+trx.getUserBalances("gowtham"));*/
		} catch (Exception e) {
			System.out.println("User is not found!");
		}
		
		
		
	}

}
