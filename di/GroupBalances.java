package com.split.di;

import java.util.HashMap;
import java.util.List;

public class GroupBalances implements GroupBalancesInterface {

	HashMap<String, Integer> userDetails;
	HashMap<String, Integer> positiveBalances;
	HashMap<String, Integer> negativeBalances;
	
	public GroupBalances()
	{
		
	}
	
	public GroupBalances(HashMap<String, Integer> userDetails)
	{
		this.positiveBalances = new HashMap<>();
		this.negativeBalances = new HashMap<>();
		this.userDetails = userDetails;
		splitPositiveNegativeBalances();
	}
	
	//Method used to sepearte positive and negative balances to form a heap	
	/* (non-Javadoc)
	 * @see com.split.di.GroupBalancesInterface#splitPositiveNegativeBalances()
	 */
	@Override
	public void splitPositiveNegativeBalances()
	{
		for (String key : userDetails.keySet()) {
		   if(userDetails.get(key) == null)
		   continue; 
		   
		   if(userDetails.get(key)>0) {
			   this.positiveBalances.put(key, userDetails.get(key));
		   }
		   else
		   {
			   this.negativeBalances.put(key, userDetails.get(key));
		   }
		   
		}
	}
	
	/* (non-Javadoc)
	 * @see com.split.di.GroupBalancesInterface#getBalanceSummary()
	 */
	@Override
	public List<BalanceArrayObject> getBalanceSummary()
	{
		SimplifiedDebts debts = new SimplifiedDebts();
		
		BalanceSummaryInterface summary =  debts.getBalanceSummaryObject();
		summary.pushToPositveAndNegative(positiveBalances, negativeBalances);
		return summary.getBalancesList();
		//positiveBalances, negativeBalances
	}
	
	
}
