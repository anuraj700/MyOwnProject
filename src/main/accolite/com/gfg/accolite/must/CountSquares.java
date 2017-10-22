
package com.gfg.accolite.must;

import java.util.Scanner;

public class CountSquares {

	private static long returnCount(long b) {

		long a = 1;
		long cnt = 0;
		for (long i = a; i < b; i++) {
			for (long j = 1; j * j <= i; j++) {
				if (j * j == i) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static double countSquares(long b) {

		long a = 1;
		if (perfect(Math.sqrt(b))) {
			return Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a));
		}
		return (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
	}

	private static boolean perfect(double b) {

		// both can be used-- checking if the input last number is itself perfect square
		// and we have find count exculding it
		//if (Math.floor(b) == Math.ceil(b))
		if (Math.round(b) == b)
			return true;
		return false;
	}

	public static void main(String[] args) {

		System.out.println("Count is: " + returnCount(18));
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			long b = in.nextLong();
			System.out.println(Math.round(countSquares(b)));
			t--;
		}
		in.close();
	}
}
