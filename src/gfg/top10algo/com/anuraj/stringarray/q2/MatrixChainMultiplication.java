
package com.anuraj.stringarray.q2;

/*
 * https://www.geeksforgeeks.org/?p=15553 Dynamic programming
 */
public class MatrixChainMultiplication {

	/*
	 * Solution 1 : optimal substructure : using recursive approach
	 */
	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	static int matrixChainOrder(int[] arr, int start, int end) {

		if (start == end) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		// place parenthesis at different places between first
		// and last matrix, recursively calculate count of
		// multiplications for each parenthesis placement and
		// return the minimum count
		for (int k = start; k < end; k++) {
			int count = matrixChainOrder(arr, start, k) + matrixChainOrder(arr, k + 1, end) + arr[start - 1] * arr[k] * arr[end];
			if (count < min) {
				min = count;
			}
		}
		return min;
	}

	/*
	 * Solution 2 : overlapping subproblem : using dynamic programming
	 */
	static int matrixChainOrder(int[] p, int n) {

		/* For simplicity of the program, one extra row and one
		extra column are allocated in m[][].  0th row and 0th
		column of m[][] are not used */
		int m[][] = new int[n][n];
		int i, j, k, L, q;
		/* m[i,j] = Minimum number of scalar multiplications needed
		to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
		dimension of A[i] is p[i-1] x p[i] */
		// cost is zero when multiplying one matrix.
		for (i = 1; i < n; i++) {
			m[i][i] = 0;
		}
		//L is chain length
		for (L = 2; L < n; L++) {
			for (i = 1; i < n - L + 1; i++) {
				j = i + L - 1;
				if (j == n) {
					continue;
				}
				m[i][j] = Integer.MAX_VALUE;
				for (k = i; k <= j - 1; k++) {
					// q = cost/scalar multiplication
					q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (q < m[i][j]) {
						m[i][j] = q;
					}
				}
			}
		}
		return m[1][n - 1];
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4 };
		int n = arr.length;
		System.out.println("Minimum number of multiplications is " + matrixChainOrder(arr, 1, n - 1));
		System.out.println("Minimum number of multiplications is " + matrixChainOrder(arr, n));
	}
}
