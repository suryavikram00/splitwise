package com.split.di;

public class SimplifiedDebts implements BalanceSummaryFactoryInterface {

	@Override
	public BalanceSummaryInterface getBalanceSummaryObject() {
		// TODO Auto-generated method stub
		return new SimplifiedBalanceSummary();
	}

}
