package com.split.di;

public class BalanceArrayObject {

	private String owes;
	private String owed;
	private int amount;
	
	
	public BalanceArrayObject(String owes, String owed, int amount) {
		
		this.owes = owes;
		this.owed = owed;
		this.amount = amount;
	}
	
	public String getOwes() {
		return owes;
	}
	public void setOwes(String owes) {
		this.owes = owes;
	}
	public String getOwed() {
		return owed;
	}
	public void setOwed(String owed) {
		this.owed = owed;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "BalanceArrayObject [owes=" + owes + ", owed=" + owed + ", amount=" + amount + "]";
	}
	
	
	
	
}
