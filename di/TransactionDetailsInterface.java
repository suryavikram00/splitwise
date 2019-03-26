package com.split.di;

import java.util.List;
import java.util.Stack;

public interface TransactionDetailsInterface {

	//add a new User
	void addUser(String userName);

	int getUserBalances(String userName) throws Exception;

	void transaction(String paidBy, String splitBy, int amount);

	void updatedTransaction(String description, int price, String paidBy, String... splitBy);

	List<BalanceArrayObject> getGroupBalances();

	int getTotalSpendings();

	Stack<EachTransaction> getEachTransaction();

}