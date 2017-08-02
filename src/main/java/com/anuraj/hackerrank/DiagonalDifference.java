package com.anuraj.hackerrank;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in .nextInt();
		int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int sumDiagonal1=0;
        int sumDiagonal2=0;
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
            	if(a_i==a_j){
            		sumDiagonal1 = sumDiagonal1 + a[a_i][a_j];
            	}
                if (a_i+a_j == n-1) {                                          
            		sumDiagonal2 = sumDiagonal2 + a[a_i][a_j];                                                
            	}	
            }
        }
        System.out.println(Math.abs(sumDiagonal1-sumDiagonal2));

	}
}
