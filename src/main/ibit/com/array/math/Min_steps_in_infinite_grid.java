package com.array.math;


class point  
{ 
    int x, y; 
    point(int a, int b) 
    { 
        x = a; 
        y = b; 
          
    } 
}
public class Min_steps_in_infinite_grid {

	
	public static void main(String args[]) 
	{ 
	    // arr stores sequence of points 
	    // that are to be visited 
	    point arr[] = new point[4]; 
	    arr[0] = new point(4, 6); 
	    arr[1] = new point(1, 2); 
	    arr[2] = new point(4, 5); 
	    arr[3] = new point(10, 12); 
	  
	    int n = arr.length; 
	    System.out.print(coverPoints(arr, n)); 
	}
	
	 static int coverPoints(point arr[], int n){
		
		int step_count =0 ;
		for (int i =0 ;i <n-1 ; i++){
			
			step_count = step_count+ shortestPath(arr[i], arr[i+1]);
		}
		return step_count;
	 }	
	 static int shortestPath(point a, point b){
		int dx = Math.abs(a.x-b.x);
		int dy = Math.abs(a.y-b.y);
		return Math.max(dx, dy);
	}
	

}
