package com.anuraj.gfg.top;

import java.util.Arrays;

public class ReverseArray {

	static void doReverse(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[n - 1 - i];
			arr[n - 1 - i] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		doReverse(arr1);
		int[] arr2 = { 4, 5, 1, 2 };
		doReverse(arr2);
		reverseString("example");
	}

	
	static void reverseString (String str){
		char[] arr = str.toCharArray();
		int n = arr.length;
		for (int i = 0; i < n / 2; i++) {
			char temp = arr[i];
			arr[i] = arr[n - 1 - i];
			arr[n - 1 - i] = temp;
		}
		System.out.println(String.valueOf(arr));
	}
}
