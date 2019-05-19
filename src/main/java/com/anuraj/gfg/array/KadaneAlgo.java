package com.anuraj.gfg.array;

public class KadaneAlgo {
	
	//for finding maximum sum contiguous array
	public static void main(String[] args) 
    { 
    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3}; 
    int n = a.length;    
    int max_sum = maxSubArraySum(a, n); 
    System.out.println("Maximum contiguous sum is " 
                       + max_sum); 
    } 
	static int maxSubArraySum(int[]a ,int n){
		
		int curr_max = a[0];
		int max_so_far = a[0];
		
		for( int i = 1 ; i<n ;i++){
			curr_max = Math.max(a[i], curr_max+a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
	}
		return max_so_far;

}
}
