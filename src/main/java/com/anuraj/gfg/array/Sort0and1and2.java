package com.anuraj.gfg.array;

public class Sort0and1and2 {

	
	/*
	 * time complexity O(n)
	 * Lo := 1; Mid := 1; Hi := N;
	while Mid <= Hi do
	Invariant: a[1..Lo-1]=0 and a[Lo..Mid-1]=1 and a[Hi+1..N]=2; a[Mid..Hi] are unknown.
	case a[Mid] in
	0: swap a[Lo] and a[Mid]; Lo++; Mid++
	1: Mid++
	2: swap a[Mid] and a[Hi]; Hi–*/
	
	public static void main(String[] args) {
		//int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}; 
		int arr[] = {0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1}; 
        int arr_size = arr.length; 
        sort012(arr, arr_size); 
        System.out.println("Array after seggregation "); 
        printArray(arr, arr_size);
	}
	static void sort012(int arr[], int n) 
    {
		int low = 1,mid=1;
		int high = n-1;
		int temp =0;
		while(mid <= high){
			
			switch (arr[mid]){
				case 0:
					temp = arr[low];
					arr[low]= arr[mid];
					arr[mid]= temp;
					low++;
					mid++;
					break;
				case 1:
					mid++;
					break;
				case 2:
					temp= arr[mid];
					arr[mid] = arr[high];
					arr[high] = temp;
					high--;
					break;
			}
		}
    }
	
	static void printArray(int arr[], int arr_size) 
    { 
        int i; 
        for (i = 0; i < arr_size; i++) 
            System.out.print(arr[i]+" "); 
        System.out.println(""); 
    }

}
