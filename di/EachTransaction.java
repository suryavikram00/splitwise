package com.split.di;

import java.util.Arrays;

public class EachTransaction {

	private String description;
	private String paidBy;
	private int price;
	private String splitBy[];
	public EachTransaction(String description, String paidBy, int price, String[] splitBy) {
		
		this.description = description;
		this.paidBy = paidBy;
		this.price = price;
		this.splitBy = splitBy;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String[] getSplitBy() {
		return splitBy;
	}
	public void setSplitBy(String[] splitBy) {
		this.splitBy = splitBy;
	}
	@Override
	public String toString() {
		return "EachTransaction [description=" + description + ", paidBy=" + paidBy + ", price=" + price + ", splitBy="
				+ Arrays.toString(splitBy) + "]";
	}
	
	
	
	
	
}
