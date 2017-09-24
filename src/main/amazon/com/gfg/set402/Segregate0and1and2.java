
package com.gfg.set402;

public class Segregate0and1and2 {

	/*
	 Time Complexity: O(n)
	 */
	static void sort012(int[] arr, int n) {

		int low = 0;
		int high = n - 1;
		int mid = 0;
		int temp = 0;
		while (mid <= high) {
			switch (arr[mid]) {
				case 0: {
					temp = arr[low];
					arr[low] = arr[mid];
					arr[mid] = temp;
					low++;
					mid++;
					break;
				}
				case 1: {
					mid++;
					break;
				}
				case 2: {
					temp = arr[mid];
					arr[mid] = arr[high];
					arr[high] = temp;
					high--;
					break;
				}
			}
		}
	}

	public static void main(String[] args) {

		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int arr_size = arr.length;
		sort012(arr, arr_size);
		print(arr, arr_size);
	}

	static void print(int arr[], int n) {

		System.out.print("\nArray after segregation is ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
