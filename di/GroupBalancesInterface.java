package com.split.di;

import java.util.HashMap;
import java.util.List;

public interface GroupBalancesInterface {
	
	
	//Method used to sepearte positive and negative balances to form a heap	
	void splitPositiveNegativeBalances();

	List<BalanceArrayObject> getBalanceSummary();

}