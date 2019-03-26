package com.split.di;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public interface BalanceSummaryInterface {
	
	public void pushToPositveAndNegative(HashMap<String, Integer> positiveBalances, HashMap<String, Integer> negativeBalances);

	void getBalanceDetails(PriorityQueue<User> positiveHeap, PriorityQueue<User> negativeHeap);

	List<BalanceArrayObject> getBalancesList();

}