
package com.gfg.set402;

public class FindDupOnTimeConstSpace {

	/*Given an array of n elements which contains elements from 0 to n-1, 
	with any of these numbers appearing any number of times.
	Find these repeating numbers in O(n) and using only constant memory space.
	There is a problem in above approach. It prints the repeated number more than once.
	Note: method modifies the original array
	*/
	static void printRepeating(int arr[], int size) {

		int i;
		System.out.println("\nThe repeating elements are : ");
		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.print(Math.abs(arr[i]) + " ");
		}
	}

	/*
	 * 1- Traverse the given array from i= 0 to n-1 elements
	 Go to index arr[i]%n and increment its value by n.
	3- Now traverse the array again and print all those 
	indexes i for which arr[i]/n is greater than 1.

	This approach works because all elements are in range
	from 0 to n-1 and arr[i]/n would be greater than 1
	only if a value "i" has appeared more than once.
	Note: method modifies the original array
	 */
	static void printRepeating2(int arr[], int n) {

		// First check all the values that are
		// present in an array then go to that
		// values as indexes and increment by
		// the size of array
		for (int i = 0; i < n; i++) {
			int index = arr[i] % n;
			arr[index] += n;
		}
		// Now check which value exists more
		// than once by dividing with the size
		// of array
		for (int i = 0; i < n; i++) {
			if ((arr[i] / n) > 1) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args) {

		int arr[] = { 4, 2, 4, 5, 2, 3, 1 };
		int arr_size = arr.length;
		printRepeating(arr, arr_size);
		int arr1[] = { 1, 6, 3, 1, 3, 6, 6 };
		printRepeating(arr1, arr1.length);
		System.out.println("\nOther method to find without repetition");
		int arr2[] = { 1, 6, 3, 1, 3, 6, 6 };
		printRepeating2(arr2, arr2.length);
		// below are other methods
		System.out.println("\nSimple solution");
		int arr3[] = { 4, 2, 4, 5, 2, 3, 1 };
		basicSol(arr3);
		System.out.println("\nUsing count array solution");
		useCountArray(arr3);
		System.out.println("\nUsing two equation solution");
		useEquation(arr3, arr3.length);
	}

	/*
	 * Basis solution Time Complexity: O(n*n)
	Auxiliary Space: O(1)
	 */
	static void basicSol(int[] ar) {

		int size = ar.length;
		int i, j;
		for (i = 0; i < size; i++) {
			for (j = i + 1; j < size; j++) {
				if (ar[i] == ar[j])
					System.out.print(ar[i] + " ");
			}
		}
	}

	/* use count array
	 * Time Complexity: O(n)
	Auxiliary Space: O(n)
	 */
	static void useCountArray(int[] ar) {

		int size = ar.length;
		int i;
		int count[] = new int[size];
		for (i = 0; i < size; i++) {
			if (count[ar[i]] == 1) {
				System.out.print(ar[i] + " ");
			} else {
				count[ar[i]]++;
			}
		}
	}

	/*
	 *  (Make two equations)
	 *  Time Complexity: O(n)
	Auxiliary Space: O(1)
	 */
	static void useEquation(int arr[], int size) {

		/* S is for sum of elements in arr[] */
		int S = 0;
		/* P is for product of elements in arr[] */
		int P = 1;
		/* x and y are two repeating elements */
		int x, y;
		/* D is for difference of x and y, i.e., x-y*/
		int D;
		int n = size - 2, i;
		/* Calculate Sum and Product of all elements in arr[] */
		for (i = 0; i < size; i++) {
			S = S + arr[i];
			P = P * arr[i];
		}
		/* S is x + y now */
		S = S - n * (n + 1) / 2;
		/* P is x*y now */
		P = P / fact(n);
		/* D is x - y now */
		D = (int) Math.sqrt(S * S - 4 * P);
		x = (D + S) / 2;
		y = (S - D) / 2;
		System.out.println("The two repeating elements are :");
		System.out.print(x + " " + y);
	}

	private static int fact(int n) {

		return (n == 0) ? 1 : n * fact(n - 1);
	}
}
