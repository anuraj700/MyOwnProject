
package com.gfg.inmobi.set3;

public class TwoWaterJug {

	static int gcd(int n, int m) {

		// n > m we have already put check n is larger
		if (m == 0) {
			return n;
		}
		return gcd(m, n % m);
	}

	static int pour(int fromJug, int toJug, int d) {

		// initialize the source and destination jugs
		int from = fromJug;
		int to = 0;
		// initialize steps
		int step = 1;
		// break the loop if either of jugs =d
		while (from != d && to != d) {
			// find min that can be transfered
			int temp = Math.min(from, toJug - to);
			// transfer water
			from -= temp;
			to += temp;
			//increment step
			++step;
			if (from == d || to == d) {
				break;
			}
			// if the first jug is empty then fill it
			if (from == 0) {
				from = fromJug;
				++step;
				;
			}
			// if the second jug is fill then empty is
			if (to == toJug) {
				to = 0;
				++step;
			}
		}
		return step;
	}

	static int minStep(int m, int n, int d) {

		if (m > n) {
			// swap to make sure n is one with large capacity
			m = m + n;
			n = m - n;
			m = m - n;
		}
		if (d > n) {
			// we cannot measure larger
			return -1;
		}
		if (d % gcd(n, m) != 0) {
			// if gcd of n and m doesnt divide d then solution is not possible
			return -1;
		}
		// return minimum of two cases
		return Math.min(pour(n, m, d),// n to m
		                pour(m, n, d)); // m to n
	}

	public static void main(String[] args) {

		int n = 3, m = 5, d = 4;
		System.out.println("Minimum number of steps is :" + minStep(m, n, d));
	}
}
