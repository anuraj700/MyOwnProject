
package com.gfg.set402;

public class Segregate0and1 {

	/*
	 * You are given an array of 0s and 1s in random order. 
	 * Segregate 0s on left side and 1s on right side of the array.
	 *  Traverse array only once.
	 */
	/*
	 * Method 1 (Count 0s or 1s) 
	Thanks to Naveen for suggesting this method.
	1) Count the number of 0s. Let count be C.
	2) Once we have count, we can put C 0s at the beginning and 1s at the remaining n – C positions in array.

	Time Complexity : O(n)
	 */
	static void segregate0and1(int[] arr, int n) {

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				count++;
		}
		for (int i = 0; i < n; i++) {
			if (i < count)
				arr[i] = 0;
			else
				arr[i] = 1;
		}
	}

	/*
	 * in single pass
	 * Method 2 (Use two indexes to traverse)
	Maintain two indexes. Initialize first index left as 0 and second index right as n-1.

	Do following while left < right
	a) Keep incrementing index left while there are 0s at it
	b) Keep decrementing index right while there are 1s at it
	c) If left < right then exchange arr[left] and arr[right]
	 */
	static void segregate0and1method2(int[] arr, int n) {

		int left = 0;
		int right = n - 1;
		while (left < right) {
			while (arr[left] == 0 && left < right)
				left++;
			while (arr[right] == 1 && left < right)
				right--;
			if (left < right) {
				//				int temp = arr[left];
				//				arr[left] = arr[right];
				//				arr[right] = temp;
				arr[left] = 0;
				arr[right] = 1;
				left++;
				right--;
			}
		}
	}

	public static void main(String[] args) {

		int arr[] = new int[] { 0, 1, 0, 1, 1, 1 };
		int n = arr.length;
		segregate0and1(arr, n);
		print(arr, n);
		int arr1[] = { 0, 1, 0, 1, 1, 1, 0, 0, 1 };
		segregate0and1method2(arr1, arr1.length);
		print(arr1, arr1.length);
	}

	static void print(int arr[], int n) {

		System.out.print("\nArray after segregation is ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
