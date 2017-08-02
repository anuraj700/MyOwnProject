package com.anuraj.cracking;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeftArrayRotation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		in.close();
		int[] output = new int[n];
		output = arrayLeftRotation(a, n, k);
		for (int i = 0; i < n; i++)
			System.out.print(output[i] + " ");

		System.out.println();

		output = arrayLeftRotation2(a, n, k);
		for (int i = 0; i < n; i++)
			System.out.print(output[i] + " ");

	}

	public static int[] arrayLeftRotation(int[] a, int n, int k) {

		//int[] b= a.clone();
		int[] b= new int[n];
		System.arraycopy(a, 0, b, 0, n);
		// looping times of rotation
		for (int i = 0; i < k; i++) {
			int first = b[0];
			for (int j = 1; j < n; j++) {
				b[j - 1] = b[j];
			}
			b[n - 1] = first;
		}
		return b;

	}

	public static int[] arrayLeftRotation2(int[] a, int n, int k) {
		int b[] = new int[n];
		for (int j = 0; j < n; j++) {
			if (j + k < n) {
				b[j] = a[j + k];
			} else {
				b[j] = a[j + k - n];
			}
		}
		return b;
	}

}
