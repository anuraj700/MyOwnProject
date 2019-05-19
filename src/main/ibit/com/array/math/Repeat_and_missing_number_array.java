package com.array.math;

public class Repeat_and_missing_number_array {
	
	public static void main(String[] args) 
    { 
        int arr[] = { 7, 3, 4, 5, 5, 6, 2 }; 
        int n = arr.length; 
        printTwoElements(arr, n); 
    }
	
	private static void printTwoElements(int[] arr, int n){
		
		int i =0;
		
		for ( i =0;i<n;i++){
			
			int abs_val = Math.abs(arr[i]);
			if(arr[abs_val-1]>0){
				arr[abs_val-1] =-arr[abs_val-1];
			}else{
				System.out.println("Repeating number is "+ abs_val);
			}
		}
		
		for( i=0;i<n;i++){
			if(arr[i]>0){
				System.out.println("Missing number is "+(i+1));
			}
		}
		
	}

}
