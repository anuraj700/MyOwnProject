
package com.anuraj.stringarray.q1;

public class ReverseArray {

	/* standard string reversal algorith
	 * 
	 */
	static void reverse(int[] arr, int start, int end) {

		if (start >= end) {
			return;
		}
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		reverse(arr, start + 1, end - 1);
	}

	static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6 };
		printArray(arr);
		reverse(arr, 0, 5);
		System.out.println("Reversed array is");
		printArray(arr);
	}
}
