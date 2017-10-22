
package com.gfg.accolite.must;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		while (k > 0) {
			int n = in.nextInt();
			int a[] = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			findMajorityElement(a);
			k--;
		}
		in.close();
	}

	static void findMajorityElement(int[] arr) {

		//printArray(arr);
		int n = arr.length;
		int top = n / 2;
		Map<Integer, Integer> master = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (master.containsKey(arr[i])) {
				int temp = master.get(arr[i]) + 1;
				master.put(arr[i], temp);
				if (temp > top) {
					System.out.println(arr[i]);
					return;
				}
			} else {
				master.put(arr[i], 1);
			}
		}
		System.out.println("NO Majority Element");
	}

	static void printArray(int[] output) {

		int n = output.length;
		for (int i = 0; i < n; i++)
			System.out.print(output[i] + " ");
	}
}
/*
2
5
3 1 3 3 2
3
1 2 3
*/