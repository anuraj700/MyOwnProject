
package com.anuraj.strategypattern;

public class Manager implements Strategy {

	private Strategy strategy;

	public void setStrategy(Strategy strategy) {

		this.strategy = strategy;
	}

	@Override
	public void operations(int num1, int num2) {

		this.strategy.operations(num1, num2);
	}
}
