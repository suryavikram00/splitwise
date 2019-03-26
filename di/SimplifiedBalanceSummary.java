package com.split.di;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import java.util.PriorityQueue;

public class SimplifiedBalanceSummary implements BalanceSummaryInterface {

	PriorityQueue<User> positiveHeap;
	PriorityQueue<User> negativeHeap;
	List<BalanceArrayObject> outputBalanceList;
	
	public void setPositiveHeap(PriorityQueue<User> positiveHeap) {
		this.positiveHeap = positiveHeap;
	}

	public void setNegativeHeap(PriorityQueue<User> negativeHeap) {
		this.negativeHeap = negativeHeap;
	}

	public void pushToPositveAndNegative(HashMap<String, Integer> positiveBalances, HashMap<String, Integer> negativeBalances)
	{
		outputBalanceList = new LinkedList<BalanceArrayObject>();
		positiveHeap = new PriorityQueue<User>(Collections.reverseOrder()); 
		negativeHeap  = new PriorityQueue<User>(); 
		for (String key : positiveBalances.keySet()) {
			 positiveHeap.add(new User(key, positiveBalances.get(key)));
			   
			}
		
		for (String key : negativeBalances.keySet()) {
			   
			negativeHeap.add(new User(key, negativeBalances.get(key)));
		}
		
		
		//System.out.println(positiveHeap.poll());
		getBalanceDetails(positiveHeap, negativeHeap);
	}
	
	public SimplifiedBalanceSummary()
	{
		
		
	}
	
	/* (non-Javadoc)
	 * @see com.split.di.BalanceSummaryInterface#getBalanceDetails(java.util.PriorityQueue, java.util.PriorityQueue)
	 */
	@Override
	public void getBalanceDetails(PriorityQueue<User> positiveHeap, PriorityQueue<User> negativeHeap)
	{
		if(positiveHeap.peek() == null || negativeHeap.peek() == null )
		{
			return;
		}
		
		User positivePeek= positiveHeap.poll();
		User negativePeek = negativeHeap.poll();
		//if negative heap value is less than positive heap value
		if((negativePeek.getBalances()+positivePeek.getBalances()>0))
		{			
			//System.out.println(negativePeek.getUserName()+" owes Rs."+Math.abs(negativePeek.getBalances())+" to "+positivePeek.getUserName());
			
			//Store the balances in the ouput balance list
			
			outputBalanceList.add(new BalanceArrayObject(negativePeek.getUserName(), positivePeek.getUserName(), Math.abs(negativePeek.getBalances())));
			
			//positivePeek.setBalances(positivePeek.getBalances()+negativePeek.getBalances());
			User temp = new User(positivePeek.getUserName(),positivePeek.getBalances()+negativePeek.getBalances());
			positiveHeap.add(temp);
		}
		
		//if negative heap value is greater than positive heap value
		if((negativePeek.getBalances()+positivePeek.getBalances()<0))
		{
			//System.out.println(negativePeek.getUserName()+" owes Rs."+positivePeek.getBalances()+" to "+positivePeek.getUserName());
			
			//Store the balances in the ouput balance list
			
			outputBalanceList.add(new BalanceArrayObject(negativePeek.getUserName(), positivePeek.getUserName(), positivePeek.getBalances()));
			
			User temp= new User(negativePeek.getUserName(), positivePeek.getBalances()+negativePeek.getBalances());
			
			negativeHeap.add(temp);
		}
		
		
		//if negative heap value is equal to positive heap value
		
		if((negativePeek.getBalances()+positivePeek.getBalances()==0))
		{
			//Store the balances in the ouput balance list
			
			outputBalanceList.add(new BalanceArrayObject(negativePeek.getUserName(), positivePeek.getUserName(), Math.abs(negativePeek.getBalances())));
			
			//System.out.println(negativePeek.getUserName()+" owes Rs."+Math.abs(negativePeek.getBalances())+" to "+positivePeek.getUserName());
			
		}
		
		getBalanceDetails(positiveHeap, negativeHeap);
		
	}
	
	/* (non-Javadoc)
	 * @see com.split.di.BalanceSummaryInterface#getBalancesList()
	 */
	@Override
	public List<BalanceArrayObject> getBalancesList()
	{
		return outputBalanceList;
	}
	
	
	
}
