package com.split.di;

public class NonSimplifiedDebts implements BalanceSummaryFactoryInterface {

	@Override
	public BalanceSummaryInterface getBalanceSummaryObject() {
		
		return new NonSimplifiedBalanceSummary();
	}

}
