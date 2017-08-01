
package com.hu.anuraj;

import java.util.Scanner;

public class LISInCircularManner {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int k = 0; k < t; k++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			int c = 1;
			int curr = 0;
			int next = 0;
			int j = 0;
			int c1 = 1;
			while (true) {
				if (next < n - 1) {
					curr = next;
					next = next + 1;
				} else {
					curr = next;
					next = 0;
				}
				if (arr[next] > arr[curr]) {
					c1++;
					j++;
					//System.out.println(j + " at if " + c1);
				} else {
					if (c1 > c) {
						c = c1;
					}
					c1 = 1;
					j++;
					//System.out.println(j + " at else " + c);
				}
				if (j == (2 * n)) {
					break;
				}
			}
			/*			for (int i = 0; i < n; i++) {
							System.out.print(arr[i] + " ");
						}
			*/System.out.println(c);
		}
		in.close();
	}
}
/*

84
87 78 16 94 36 87 93 50 22 63 28 91 60 64 27 41 27 73 37 12 69 68 30 83 31 63 24 68 36 30 3 23 59 70 68 94 57 12 43 30 74 22 20 85 38 99 25 16 71 14 27 92 81 57 74 63 71 97 82 6 26 85 28 37 6 47 30 14 58 25 96 83 46 15 68 35 65 44 51 88 9 77 79 89 

Its Correct output is:
14

And Your Output is:
4
*/