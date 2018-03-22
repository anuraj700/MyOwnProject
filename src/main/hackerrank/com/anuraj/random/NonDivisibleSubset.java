
package com.anuraj.random;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NonDivisibleSubset {

	static int nonDivisibleSubset(int k, int[] arr) {

		// Complete this function
		Set<Integer> subset = new HashSet<Integer>();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[i] + arr[j]) % k != 0) {
					System.out.println("Adding i: " + arr[i] + " j: " + arr[j]);
					subset.add(arr[i]);
					subset.add(arr[j]);
				} else {
					System.out.println("Removing i: " + arr[i] + " j: " + arr[j]);
					subset.remove(arr[i]);
					subset.remove(arr[j]);
				}
			}
		}
		return subset.size();
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		int result = nonDivisibleSubset(k, arr);
		System.out.println(result);
		in.close();
	}
}
