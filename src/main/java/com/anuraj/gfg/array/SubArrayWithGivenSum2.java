package com.anuraj.gfg.array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum2 {

	public static void main(String[] args) {
		int[] arr = {10, 2, -2, -20, 10}; 
        int n = arr.length; 
        int sum = -10; 
        subArraySum(arr, n, sum); 
	}
	// METHOD 1 LOOP O(n)
	/*An efficient way is to use a map. The idea is to maintain sum of
	 *  elements encountered so far in a variable (say curr_sum).
	 *   Let the given number is sum. Now for each element, we check if 
	 *   curr_sum – sum exists in the map or not. If we found it in the map 
	 *   that means, we have a subarray present with given sum,
	 *    else we insert curr_sum into the map and proceed to next element.
	 *    If all elements of the array are processed and we didn’t find any
	 *     subarray with given sum, then subarray doesn’t exists..*/
	private static int subArraySum(int[] arr, int n , int sum){
		
		int curr_sum =0, start=0 ,end=-1;
		Map<Integer,Integer> hashMap = new HashMap<>();
		
		for(int i =0 ;i <n;i++){
			
			curr_sum = curr_sum + arr[i];
			//check whether cur_sum - sum = 0, if 0 it means 
            //the sub array is starting from index 0- so stop
			if(curr_sum - sum ==0){
				start = 0;
				end = i;
				break;
			}
			//if hashMap already has the value, means we already  
            // have subarray with the sum - so stop 
			if(hashMap.containsKey(curr_sum-sum)){
				start = hashMap.get(curr_sum -sum)+1;
				end =i;
				break;	
						
			}
			
			hashMap.put(curr_sum, i);
			
		}
		
		if(end ==-1){
			System.out.println("No sub array found");
			
			return 0;
		}else{
			System.out.println("Sum found between indexes " 
                    + start + " to " + end); 
			return 1;
		}
		
	}
	
	
}
