package com.anuraj.gfg.array;

public class EquilibriumPoint {

	public static void main(String[] args) {
		EquilibriumPoint equi = new EquilibriumPoint(); 
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 }; 
        int arr_size = arr.length; 
        System.out.println(equi.equilibrium(arr, arr_size)); 
        System.out.println(equi.equilibrium2(arr, arr_size)); 
	}

	/*Method 2 (Tricky and Efficient) O(n)
	The idea is to get total sum of array first. Then Iterate through
	the array and keep updating the left sum which is initialized as zero. 
	In the loop, we can get right sum by subtracting the elements one by one.*/
	int equilibrium2(int arr[], int n) {
		
		int sum =0;
		
		for(int i =0 ;i < n;i++){
			sum =+ arr[i];
		}
		
		int leftsum =0;
		for(int i =0 ;i<n;i++){
			
			sum = sum - arr[i];
			if(leftsum == sum){
				return i;
			}
			
			leftsum = leftsum +arr[i];
		}
		
		return -1;
	}
	
	/*Method 1 (Simple but inefficient)
	Use two loops. Outer loop iterates through all the element and 
	inner loop finds out whether the current index picked by the
	outer loop is equilibrium index or not. Time complexity of this 
	solution is O(n^2).*/
	int equilibrium(int arr[], int n) {
	
	 int leftsum,rightsum;
	 int i , j;
	 
	 for(i =0 ;i <n;i++){
		 
		 leftsum=0;
		 for(j=0;j<i;j++){
			 leftsum +=arr[j];
		 }
		 
		 rightsum=0;
		 for(j=i+1;j<n;j++){
			 rightsum +=arr[j];
		 }
		 
		 if(leftsum==rightsum){
			 return i;
		 }
	 }
		
		return -1;
	}
}
