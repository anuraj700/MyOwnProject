
package com.anuraj.expediaoffice;

import java.util.Arrays;
import java.util.Scanner;

public class ZeroMatrix {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int rowCount = in.nextInt();
		int columnCount = in.nextInt();
		int[][] arr = new int[rowCount][columnCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		System.out.println("\nInput array");
		printArr(arr);
		boolean[] rowArray = new boolean[rowCount];
		boolean[] colArray = new boolean[columnCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				if (arr[i][j] == 0) {
					rowArray[i] = true;
					colArray[j] = true;
				}
			}
		}
		System.out.println("\nRow and columns have been determined");
		System.out.println(Arrays.toString(rowArray));
		System.out.println(Arrays.toString(colArray));
		for (int i = 0; i < rowArray.length; i++) {
			if (rowArray[i]) {
				arr = makeRowZero(i, columnCount, arr);
			}
		}
		for (int j = 0; j < colArray.length; j++) {
			if (colArray[j]) {
				arr = makeColumnZero(j, rowCount, arr);
			}
		}
		System.out.println("\nfinal output");
		printArr(arr);
		System.out.println("\n trying lokesh");
		lokesh();
	}

	private static int[][] makeRowZero(int rowIndex, int columnCount, int[][] arr) {

		for (int j = 0; j < columnCount; j++) {
			arr[rowIndex][j] = 0;
		}
		return arr;
	}

	private static int[][] makeColumnZero(int colIndex, int rowCount, int[][] arr) {

		for (int i = 0; i < rowCount; i++) {
			arr[i][colIndex] = 0;
		}
		return arr;
	}

	private static void printArr(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] input = { { 2, 3, 1, 2 }, { 7, 2, 2, 1 }, { 4, 0, 2, 7 } };
	private static int rows = input.length;
	private static int columns = input[0].length;

	private static void lokesh() {

		boolean isFirstRowZero = false;
		boolean isFirstColZero = false;
		printArr(input);
		// finding out whether first row needed to be zero
		for (int i = 0; i < columns; i++) {
			if (input[0][i] == 0) {
				isFirstRowZero = true;
				break;
			}
		}
		// finding out whether first columns needed to be zero
		for (int j = 0; j < rows; j++) {
			if (input[j][0] == 0) {
				isFirstColZero = true;
				break;
			}
		}
		// iterating over the 2d-array to find out the position of zero and accordingly updating first rows and first column
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				if (input[i][j] == 0) {
					input[i][0] = 0;
					input[0][j] = 0;
				}
			}
		}
		// making required rows zero
		for (int i = 1; i < columns; i++) {
			if (input[0][i] == 0) {
				for (int j = 1; j < rows; j++) {
					input[j][i] = 0;
				}
			}
		}
		// making required columns zero
		for (int i = 1; i < rows; i++) {
			if (input[i][0] == 0) {
				for (int j = 1; j < columns; j++) {
					input[i][j] = 0;
				}
			}
		}
		if (isFirstRowZero) {
			for (int j = 0; j < rows; j++) {
				input[0][j] = 0;
			}
		}
		if (isFirstColZero) {
			for (int i = 0; i < columns; i++) {
				input[i][0] = 0;
			}
		}
		// printing arrays
		printArr(input);
	}
}
/*
input 1
2 3
1 2 0
4 5 6


input 2
3 3
2 3 0 
7 2 2
4 1 2

input 3 
3 3
2 3 0 
7 2 2
4 0 2

input 4
3 4
2 3 1 2 
7 2 2 1 
4 0 2 7 

*/