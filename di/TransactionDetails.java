package com.split.di;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class TransactionDetails implements TransactionDetailsInterface  {

	private HashMap<String, Integer> userDetails;
	private Stack<EachTransaction> eachTransaction;
	
	

	private int totalSpendings;
	
	public TransactionDetails()
	{
		userDetails = new HashMap<>();
		eachTransaction= new Stack<>();
		totalSpendings=0;
	}
	
	//add a new User
	/* (non-Javadoc)
	 * @see com.split.di.TransactionDetailsInterface#addUser(java.lang.String)
	 */
	@Override
	public void addUser(String userName)
	{
		userDetails.put(userName, 0);
	
	}
	
	/* (non-Javadoc)
	 * @see com.split.di.TransactionDetailsInterface#getUserBalances(java.lang.String)
	 */
	@Override
	public int getUserBalances(String userName) throws Exception 
	{
		if(userDetails.get(userName)==null)
		{
			throw new Exception("User is not found!");
 		}
		
		return userDetails.get(userName);
	}
	
	/* (non-Javadoc)
	 * @see com.split.di.TransactionDetailsInterface#transaction(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void transaction(String paidBy, String splitBy, int amount)
	{
		//get balances of FROM and TO Users
		/*int fromUserBalance= userDetails.get(paidBy);
		int toUserBalance= userDetails.get(paidTo);*/
		
		//update total spendings for the group
		totalSpendings= totalSpendings+amount;
		
		//Add amount to From User
		userDetails.put(paidBy, userDetails.get(paidBy)+amount);
		
		//Subtract Amount from To User
		userDetails.put(splitBy, userDetails.get(splitBy)-amount);
		
	}
	
	/* (non-Javadoc)
	 * @see com.split.di.TransactionDetailsInterface#updatedTransaction(java.lang.String, int, java.lang.String, java.lang.String)
	 */
	@Override
	public void updatedTransaction(String description,int price, String paidBy, String... splitBy)
	{
		//update the stack for every transactions
		
		eachTransaction.push(new EachTransaction(description, paidBy, price, splitBy));
		
		//update total spendings for the group
		totalSpendings= totalSpendings+price;
		
		//get Splitted amount 
		int splitAmount = price/splitBy.length;
		
		//Add amount to From User
		userDetails.put(paidBy, userDetails.get(paidBy)+price);
		
		//Subtract Amount from every User in To array
		for(String toUser:splitBy)
		{
			userDetails.put(toUser, userDetails.get(toUser)-splitAmount);
		}
	
	}
	
	/* (non-Javadoc)
	 * @see com.split.di.TransactionDetailsInterface#getGroupBalances()
	 */
	@Override
	public List<BalanceArrayObject> getGroupBalances()
	{
		GroupBalancesInterface balances = new GroupBalances(userDetails);
		return balances.getBalanceSummary();
		
	}

	/* (non-Javadoc)
	 * @see com.split.di.TransactionDetailsInterface#getTotalSpendings()
	 */
	@Override
	public int getTotalSpendings() {
		return totalSpendings;
	}
	
	/* (non-Javadoc)
	 * @see com.split.di.TransactionDetailsInterface#getEachTransaction()
	 */
	@Override
	public Stack<EachTransaction> getEachTransaction() {
		return eachTransaction;
	}
	
	
}
