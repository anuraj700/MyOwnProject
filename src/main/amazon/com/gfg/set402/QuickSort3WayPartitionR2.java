
package com.gfg.set402;

public class QuickSort3WayPartitionR2 {

	/*
	 * In 3 Way QuickSort, an array arr[l..r] is divided in 3 parts:
	a) arr[l..i] elements less than pivot.
	b) arr[i+1..j-1] elements equal to pivot.
	c) arr[j..r] elements greater than pivot.
	 */
	static int i, j;

	static void partition(int a[], int low, int high) {

		// To handle 2 elements
		if (high - low <= 1) {
			if (a[high] < a[low]) {
				int temp = a[high];
				a[high] = a[low];
				a[low] = temp;
			}
			i = low;
			j = high;
			return;
		}
		int mid = low;
		int pivot = a[high];
		while (mid < high) {
			if (a[mid] < pivot) {
				int temp = a[low];
				a[low] = a[mid];
				a[mid] = temp;
				low++;
				mid++;
			} else if (a[mid] == pivot) {
				mid++;
			} else if (a[mid] > pivot) {
				int temp = a[high];
				a[high] = a[mid];
				a[mid] = temp;
				high--;
			}
		}
		i = low - 1;
		j = mid;//or high-1
	}

	static void quicksort(int[] a, int low, int high) {

		if (low >= high)
			return;
		partition(a, low, high);
		quicksort(a, low, i);
		quicksort(a, j, high);
	}

	public static void main(String[] args) {

		int a[] = { 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4 };
		int size = a.length;
		print(a, size);
		quicksort(a, 0, size - 1);
		print(a, size);
	}

	static void print(int arr[], int n) {

		System.out.print("\nArray after segregation is ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
