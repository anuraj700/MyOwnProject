package com.anuraj.gfg.array;

public class Segregate0and1 {

	public static void main(String[] args) {
		int arr[] = new int[]{ 0, 1, 0, 1, 1, 1 }; 
        int n = arr.length; 
        segregate0and1(arr, n); 
        print(arr, n); 
        System.out.println();
        arr = new int[]{ 0, 1, 0, 1, 1, 1 };
        segregate0and1Twoindex(arr,n);
        print(arr, n); 
        System.out.println();
        arr = new int[]{ 0, 1, 0, 1, 1, 1 };
        segregate0and1another(arr,n);
        print(arr, n); 
	}

	static void print(int arr[], int n) 
    { 
        System.out.print("Array after segregation is "); 
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " ");     
    }
	/*Method 1 (Count 0s or 1s) 
	1) Count the number of 0s. Let count be C.
	2) Once we have count, we can put C 0s at the beginning and 
	1s at the remaining n – C positions in array.
	Time Complexity : O(n)*/
	
	static void segregate0and1(int[] arr ,int n){
		
	}
	
	/*Method 2 (Use two indexes to traverse) O(n)
	Maintain two indexes. Initialize first index left as 0 and
	second index right as n-1.

	Do following while left < right
	a) Keep incrementing index left while there are 0s at it
	b) Keep decrementing index right while there are 1s at it
	c) If left < right then exchange arr[left] and arr[right]*/
	
	static void segregate0and1Twoindex(int[] arr ,int n){
		
		int left =0;
		int right = n-1;
		
		while(left<right){
			
			while(arr[left]==0 && left<right){
				left++;
			}
			while(arr[right]==1 && left<right){
				right--;
			}
			if(left<right){
				arr[left] =0;
				arr[right] =1;
				left++;
				right--;
				
			}
		}
	}
	/*Another approach :  O(n)
		1. Take two pointer type0(for element 0) starting from beginning 
		(index = 0) and type1(for element 1) starting from end
		(index = array.length-1).
		Initialize type0 = 0 and type1 = array.length-1
		2. It is intended to Put 1 to the right side of the array. 
		Once it is done, then 0 will definitely towards left side of array.*/
	
	static void segregate0and1another(int[] arr,int n){
		
		int type0 = 0;
		int type1 = n-1;
		
		
		while(type0 < type1){
			
			if(arr[type0] ==1){
				//swap
				/*int temp = arr[type1];
				arr[type1] = arr[type0];
				arr[type0] = temp;*/
						
				arr[type1] = arr[type0] +arr[type1];
				arr[type0] = arr[type1] -arr[type0];
				arr[type1] = arr[type1] - arr[type0];
				type1--;
			}else{
				type0++;
			}
			
		}
				
	}
}
