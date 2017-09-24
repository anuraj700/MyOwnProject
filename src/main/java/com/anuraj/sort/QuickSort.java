package com.anuraj.sort;

public class QuickSort {

	private int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;

	}

	private void recursiveSort(int[] arr, int low, int high) {

		if (low < high) {
			int pi = partition(arr, low, high);
			recursiveSort(arr, low, pi - 1);
			recursiveSort(arr, pi + 1, high);
		}
	}

	private void iterativeSort(int[] arr, int low, int high) {
		int[] stack = new int[high - low + 1];
		int top = -1;
		stack[++top] = low;
		stack[++top] = high;
		while (top >= 0) {
			high = stack[top--];
			low = stack[top--];

			int p = partition(arr, low, high);

			if (p - 1 > low) {
				stack[++top] = low;
				stack[++top] = p - 1;
			}

			if (p + 1 < high) {
				stack[++top] = p + 1;
				stack[++top] = high;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;
		QuickSort obj = new QuickSort();
		obj.recursiveSort(arr, 0, n - 1);
		System.out.println("Recursive Sorted array is");
		obj.printArray(arr);
		
		int arr1[] = { 4, 3, 5, 2, 1, 3, 2, 3 };
		obj.iterativeSort(arr1, 0, arr1.length - 1);
		System.out.println("Iterative Sorted array is");
		obj.printArray(arr1);

	}

	private void printArray(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
