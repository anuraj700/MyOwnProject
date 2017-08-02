package com.anuraj.hackerrank;


	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	public class CircularArrayRotation {

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int q = in.nextInt();
	        int[] a = new int[n];
	        int[] b = new int[n];
	        int k1 = k%n;
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
//	       	for (int a_k = 0; a_k < k%n; a_k++) {
//				int finaltemp = a[n - 1];
//				for (int a_i = n; a_i > 1; a_i--) {
//					a[a_i - 1] = a[a_i - 2];
//				}
//				a[0] = finaltemp;
//			}
	        for (int a_i = n-1; a_i >= 0; a_i--) {
				//int temp = a[a_i];
	        	int c=n;
	        	if (a_i-k1<0){
	        		b[a_i]=a[a_i-k1+c];
	        	}else{
		        	b[a_i] = a[a_i - k1];

	        	}
	        	c--;
	        	//a[a_i - k%n]= temp;
			}
	        for(int a0 = 0; a0 < q; a0++){
	            int m = in.nextInt();
	   			System.out.println(b[m]);

	        }
	    }
}
