package com.split.di;

public class User implements Comparable<User>{

	private String userName;
	
	private Integer balances;

	public User(String userName, Integer integer) {
		
		this.userName = userName;
		this.balances = integer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getBalances() {
		return balances;
	}

	public void setBalances(Integer balances) {
		this.balances = balances;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", balances=" + balances + "]";
	}
	
	

	@Override
	public int compareTo(User o) {
		if(this.balances>o.balances)
		return 1;
		
		return -1;
	}
	
	
	
}
