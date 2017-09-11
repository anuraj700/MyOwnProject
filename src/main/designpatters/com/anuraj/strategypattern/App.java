
package com.anuraj.strategypattern;

public class App {

	public static void main(String[] args) {

		Manager manager = new Manager();
		manager.setStrategy(new Add());
		manager.operations(1, 4);
		manager.setStrategy(new Mulitply());
		manager.operations(1, 4);
	}
}
