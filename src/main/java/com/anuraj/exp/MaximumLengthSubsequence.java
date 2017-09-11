package com.anuraj.exp;

import java.util.Scanner;

public class MaximumLengthSubsequence {
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i=0;i<n;i++){
			arr[i]= in.nextInt();
		}
		int finalCount =1;
		for(int j=0;j<n-1;j++){
			int count=1;
			int first= arr[j];
			for (int i=j+1;i<n;i++){
				if(Math.abs(arr[i]-first) ==1 || Math.abs(arr[i]-first) ==0){
					count++;
					first = arr[i];
				}	
			}
			if(count>finalCount){
				finalCount = count;
			}
		}
		
		System.out.println(finalCount);
	}

}


/*
8
2 5 6 3 7 6 5 8

7
-2 -1 5 -1 4 0 3
*/