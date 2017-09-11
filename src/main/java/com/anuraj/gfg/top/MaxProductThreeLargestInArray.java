
package com.anuraj.gfg.top;

import java.util.Arrays;

/*
 * 2) A unsorted array of integers is given; you need to find the max product formed my multiplying three numbers. (You
 * cannot sort the array, watch out when there are negative numbers)
 */
public class MaxProductThreeLargestInArray {

	private int findProduct(int[] arr) {

		int x = Integer.MIN_VALUE; //first largest
		int y = Integer.MIN_VALUE;//Second largest
		int z = Integer.MIN_VALUE;//third largest
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > x) {
				z = y;
				y = x;
				x = arr[i];
			} else if (arr[i] > y) {
				z = y;
				y = arr[i];
			} else if (arr[i] > z) {
				z = arr[i];
			}
		}
		//System.out.println(x + " " + y + " " + z);
		int a = Integer.MAX_VALUE; // first smallest
		int b = Integer.MAX_VALUE; // second smallest
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < a) {
				b = a;
				a = arr[i];
			} else if (arr[i] < b) {
				b = arr[i];
			}
		}
		//System.out.println(a + " " + b);
		int temp = y * z;
		if (z < 0 && x > 0) {
			temp = Math.max(temp, a * b);
		}
		return x * temp;
	}

	public static void main(String[] args) {

		MaxProductThreeLargestInArray obj = new MaxProductThreeLargestInArray();
		int[] arr = { -4, -8, -5, -2, 9, -1, -4 };
		System.out.println("Input array " + Arrays.toString(arr));
		System.out.println("Product is " + obj.findProduct(arr));
		Arrays.sort(arr);
		System.out.println("below is corresponding sorted array " + Arrays.toString(arr));
		int[] arr1 = { 4, 8, 5, -2, 9, -1, -4 };
		System.out.println("Input array " + Arrays.toString(arr1));
		System.out.println("Product is " + obj.findProduct(arr1));
		Arrays.sort(arr1);
		System.out.println("below is corresponding sorted array " + Arrays.toString(arr1));
		int[] arr2 = { -4, -8, -5, -2, 9, 1, -4 };
		System.out.println("Input array " + Arrays.toString(arr2));
		System.out.println("Product is " + obj.findProduct(arr2));
		Arrays.sort(arr2);
		System.out.println("below is corresponding sorted array " + Arrays.toString(arr2));
		int[] arr3 = { -4, -8, -5, -2, -9, -1, -4 };
		System.out.println("Input array " + Arrays.toString(arr3));
		System.out.println("Product is " + obj.findProduct(arr3));
		Arrays.sort(arr3);
		System.out.println("below is corresponding sorted array " + Arrays.toString(arr3));
	}
}
/*
 Input array [-4, -8, -5, -2, 9, -1, -4]
Product is 360
below is corresponding sorted array [-8, -5, -4, -4, -2, -1, 9]
Input array [4, 8, 5, -2, 9, -1, -4]
Product is 225
below is corresponding sorted array [-4, -2, -1, 4, 5, 8, 9]
Input array [-4, -8, -5, -2, 9, 1, -4]
Product is -36
below is corresponding sorted array [-8, -5, -4, -4, -2, 1, 9]
*/