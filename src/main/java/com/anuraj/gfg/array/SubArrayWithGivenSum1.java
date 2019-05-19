package com.anuraj.gfg.array;

public class SubArrayWithGivenSum1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubArrayWithGivenSum1 arraysum = new SubArrayWithGivenSum1(); 
	        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23}; 
	        int n = arr.length; 
	        int sum = 23; 
	        arraysum.subArraySum(arr, n, sum);
	        arraysum.subArraySum2(arr, n, sum);
	}
	// METHOD 1 LOOP O(n2)
	/*A simple solution is to consider all subarrays one by one and check the sum
	of every subarray. Following program implements the simple solution. 
	We run two loops: the outer loop picks a starting point i and the inner
	loop tries all subarrays starting from i.*/
	private int subArraySum(int[] arr, int n , int sum){
		
		int curr_sum, i ,j;
		
		for(i =0 ;i <n;i++){
			
			curr_sum = arr[i];
			
			for(j = i+1 ;j<=n;j++){
				
				if(curr_sum== sum){
					int p = j-1;
					System.out.println("sum found between indexes "+i +" and "+p);
					return 1;
				}
				if(curr_sum>sum || j==n){
					break;
				}
				curr_sum = curr_sum+arr[j];
			}
		}
		System.out.println("No sub array found");
		
		return 0;
	}
	
	/*Method 2 (Efficient) complexity for each number 2 operations,total = 2n so O(n)
	Initialize a variable curr_sum as first element. curr_sum indicates 
	the sum of current subarray. Start from the second element and add all
	elements one by one to the curr_sum. If curr_sum becomes equal to sum, 
	then print the solution. If curr_sum exceeds the sum, then remove
	trailing elements while curr_sum is greater than sum.*/
	
	private int subArraySum2(int[] arr, int n , int sum){
	
			int curr_sum= arr[0],start=0,i;
			 for (i = 1;i<n ;i++){
				 
				 while (curr_sum>sum && start <i-1){
					 curr_sum = curr_sum -arr[start];
					 start++;
				 }
				 if(curr_sum == sum){
					 int p = i-1;
					 System.out.println("sum found between indexes "+start+ " and "+p);
					 return 1;
				 }
				 if(i<n){
					 curr_sum= curr_sum+arr[i];
				 }
				 
				 
			 }
			 System.out.println("No sub array found");
			return 0;
			
	}
}
