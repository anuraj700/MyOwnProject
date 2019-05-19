package com.array.math;

public class Add_one_to_number {
	
	public static void main(String[] args) {
		int[] a = { 1, 9 , 3, 9};
		int n = a.length;
		int[] result = newArr(a,n);
		addOne(result,n);
		printArry(result);
		int[] b = { 9, 9, 9 };
		 n = b.length;
		 result = newArr(b,n);
		 System.out.println();
		addOne(result,n);
		printArry(result);
	}
	
	static int[] newArr(int[] a,int n){
		int [] result = new int[n+1];
		result[0]=0;
		for ( int i =1; i <=n;i++){
			result[i] = a[i-1];
		}
		return result;
	}
	
	static void addOne( int[] a , int n){
		int i = n;
		
		if(a[i] < 9){
			a[i]= a[i]+1;
			return;
		}
		
		a[i]= 0;
		i--;
		
		addOne(a,i);
		
		 
	}
	
	static void printArry(int[] a){
		int n = a.length;
		if (a[0] > 0) 
            System.out.print(a[0] + ", "); 
  
        // print the array elements 
        // after adding one 
        for (int i = 1; i < n; i++) { 
            System.out.print(a[i]); 
  
            if (i < n-1) 
                System.out.print(", "); 
        } 
	}

}
