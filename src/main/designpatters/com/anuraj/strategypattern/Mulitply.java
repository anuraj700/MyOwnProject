
package com.anuraj.strategypattern;

public class Mulitply implements Strategy {

	@Override
	public void operations(int num1, int num2) {

		System.out.println(num1 * num2);
	}
}
