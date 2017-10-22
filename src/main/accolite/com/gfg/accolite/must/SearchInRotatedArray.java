
package com.gfg.accolite.must;

import java.util.Scanner;

public class SearchInRotatedArray {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		while (k > 0) {
			int n = in.nextInt();
			int a[] = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			int val = in.nextInt();
			searchInArray(a, val);
			k--;
		}
		in.close();
	}

	static void searchInArray(int[] arr, int val) {

		//printArray(arr);
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (val == arr[i]) {
				System.out.println(i);
				return;
			}
		}
		System.out.println( -1);
	}

	static void printArray(int[] output) {

		int n = output.length;
		for (int i = 0; i < n; i++)
			System.out.print(output[i] + " ");
	}
}
/*
3
9
5 6 7 8 9 10 1 2 3
10
3
3 1 2
1
4
3 5 1 2
6
*/