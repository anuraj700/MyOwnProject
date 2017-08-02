
package com.hu.anuraj;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizeTheHeights {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i_t = 0; i_t < t; i_t++) {
			int k = in.nextInt();
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i_n = 0; i_n < n; i_n++) {
				arr[i_n] = in.nextInt();
			}
			Arrays.sort(arr);
			for (int i_n = 0; i_n < n; i_n++) {
				System.out.print(arr[i_n] + " ");
			}
			System.out.println("above was sorted original array");
			boolean flag = true;
			int res[] = new int[n];
			for (int i_r = 0; i_r < n; i_r++) {
				res[i_r] = arr[i_r] - k;
				if (res[i_r] <= 0) {
					if (i_r == 0) {
						flag = false;
					}
					res[i_r] = arr[i_r] + k;
				}
			}
			for (int i_n = 0; i_n < n; i_n++) {
				System.out.print(res[i_n] + " ");
			}
			System.out.println("above was calculated array");
			Arrays.sort(res);
			for (int i_n = 0; i_n < n; i_n++) {
				System.out.print(res[i_n] + " ");
			}
			System.out.println("above was calcualted sorted array");
			int diff1 = res[n - 1] - res[0];
			int lowerbound = 0;
			int diff2 = -1;
			if (flag) {
				diff2 = res[n - 1] - (arr[lowerbound] + k);
				while (true) {
					if (diff2 <= 0 && lowerbound < n - 1) {
						lowerbound++;
						diff2 = res[n - 1] - res[lowerbound];
					} else {
						break;
					}
				}
			}
			System.out.println(res[n - 1] + " " + res[0] + " " + diff1);
			System.out.println(res[n - 1] + " " + res[lowerbound] + " " + diff2);
			if (diff1 >= 0 && diff2 >= 0) {
				if (diff1 < diff2) {
					System.out.println(diff1);
				} else {
					System.out.println(diff2);
				}
			} else if (diff1 < 0) {
				System.out.println(diff2);
			} else if (diff2 < 0) {
				System.out.println(diff1);
			}
		}
		in.close();
	}

	public static void main1(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i_t = 0; i_t < t; i_t++) {
			int k = in.nextInt();
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i_n = 0; i_n < n; i_n++) {
				arr[i_n] = in.nextInt();
			}
			Arrays.sort(arr);
			/*for (int i_n = 0; i_n < n; i_n++) {
				System.out.print(arr[i_n] + " ");
			}
			System.out.println("above was sorted original array");*/
			boolean flag = true;
			int res[] = new int[n];
			for (int i_r = 0; i_r < n; i_r++) {
				res[i_r] = arr[i_r] - k;
				if (res[i_r] <= 0) {
					if (i_r == 0) {
						flag = false;
					}
					res[i_r] = arr[i_r] + k;
				}
			}
			/*for (int i_n = 0; i_n < n; i_n++) {
				System.out.print(res[i_n] + " ");
			}
			System.out.println("above was calculated array");*/
			Arrays.sort(res);
			/*for (int i_n = 0; i_n < n; i_n++) {
				System.out.print(res[i_n] + " ");
			}
			System.out.println("above was calcualted sorted array");*/
			int diff1 = res[n - 1] - res[0];
			int lowerbound = 0;
			int diff2 = -1;
			if (flag) {
				diff2 = res[n - 1] - (arr[lowerbound] + k);
				while (true) {
					if (diff2 <= 0 && lowerbound < n - 1) {
						lowerbound++;
						diff2 = res[n - 1] - res[lowerbound];
					} else {
						break;
					}
				}
			}
			/*System.out.println(res[n - 1] + " " + res[0] + " " + diff1);
			System.out.println(res[n - 1] + " " + res[lowerbound] + " " + diff2);*/
			if (diff1 >= 0 && diff2 >= 0) {
				if (diff1 < diff2) {
					System.out.println(diff1);
				} else {
					System.out.println(diff2);
				}
			} else if (diff1 < 0) {
				System.out.println(diff2);
			} else if (diff2 < 0) {
				System.out.println(diff1);
			}
		}
		in.close();
	}
}
/*

Input:
1
6
19
34 0 19 24 28 8 12 14 5 45 31 27 11 41 45 42 27 36 41 

Its Correct output is:
33

And Your Output is:
37




7
2
4
1 5 8 10
3
5
3 9 12 16 20
4
6
100 150 200 250 300 400
6
1
42
3
4
27 29 28 23 
8
3
3 14 1
6
19
34 0 19 24 28 8 12 14 5 45 31 27 11 41 45 42 27 36 41 

output
5
11
292
0
2
5
33

*/