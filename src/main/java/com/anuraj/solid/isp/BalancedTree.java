
package com.anuraj.solid.isp;

public class BalancedTree implements IBalancedTree, Tree {

	public void rightRotation() {

		System.out.println("doing right");
	}

	public void leftRotation() {

		System.out.println("doing left");
	}

	public int findMax() {

		System.out.println("Balanced max");
		return 0;
	}

	public int findMin() {

		System.out.println("Balanced min");
		return 0;
	}

	public void traverse() {

		System.out.println("Balanced traverse");
	}
}
