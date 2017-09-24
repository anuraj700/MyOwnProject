
package com.gfg.set402;

import java.util.Scanner;

public class SudokuValidatiorR1 {

	private static final Integer TSUM = 45;
	private static final Integer TPRODUCT = 362880;

	private static boolean validate(int[][] arr) {

		int sum = 0;
		int prod = 1;
		int i;
		int j;
		//row  validation
		for (i = 0; i < 9; i++) {
			sum = 0;
			prod = 1;
			for (j = 0; j < 9; j++) {
				//check for duplication
				if (i != j && arr[i][j] == arr[i][i])
					return false;
				sum = sum + arr[i][j];
				prod = prod * arr[i][j];
			}
			if (sum != TSUM || prod != TPRODUCT)
				return false;
		}
		// column validation
		for (j = 0; j < 9; j++) {
			sum = 0;
			prod = 1;
			for (i = 0; i < 9; i++) {
				//check for duplication	
				if (i != j && arr[i][j] == arr[j][j])
					return false;
				sum = sum + arr[i][j];
				prod = prod * arr[i][j];
			}
			if (sum != TSUM || prod != TPRODUCT)
				return false;
		}
		// 3X3 boxes valiation
		int m;
		int n;
		for (i = 0; i < 9; i = i + 3) {
			for (j = 0; j < 9; j = j + 3) {
				sum = 0;
				prod = 1;
				for (m = i; m < i + 3; m++) {
					for (n = j; n < j + 3; n++) {
						sum = sum + arr[m][n];
						prod = prod * arr[m][n];
					}
				}
				if (sum != TSUM || prod != TPRODUCT)
					return false;
			}
		}
		return true;
	}

	private static boolean validateSUDOKU(int[][] board, int row, int col) {

		for (int i = 0; i < 9; i++) {
			if (i != col && board[row][i] == board[row][col]) {
				return false;
			}
			if (i != row && board[i][col] == board[row][col]) {
				return false;
			}
		}
		int r = row - row % 3;
		int c = col - col % 3;
		int temp = c;
		for (int i = 0; i < 3; i++, r++) {
			for (int j = 0; j < 3; j++, temp++) {
				if (r != row && temp != col && board[r][temp] == board[row][col]) {
					return false;
				}
			}
			temp = c;
		}
		return true;
	}

	public static void main(String[] args) {

		int[][] arr = new int[9][9];
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		in.close();
		System.out.println(validate(arr));
		boolean temp = true;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				temp = temp && validateSUDOKU(arr, i, j);
			}
		}
		System.out.println(temp);
	}
}
/*
false
1 2 4 5 4 9 4 9 7 
5 4 9 4 9 7 1 2 4 
4 9 7 1 2 4 5 4 9 
2 4 5 4 9 4 9 7 1 
4 9 4 9 7 1 2 4 5 
9 7 1 2 4 5 4 9 4 
4 5 4 9 4 9 7 1 2 
9 4 9 7 1 2 4 5 4 
7 1 2 4 5 4 9 4 9

true

1 2 3 4 5 6 7 8 9
5 7 8 1 3 9 6 2 4
4 9 6 8 7 2 1 5 3
9 5 2 3 8 1 4 6 7
6 4 1 2 9 7 8 3 5
3 8 7 5 6 4 2 9 1
7 1 9 6 2 3 5 4 8
8 6 4 9 1 5 3 7 2
2 3 5 7 4 8 9 1 6

*/