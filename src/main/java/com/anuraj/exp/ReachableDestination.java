package com.anuraj.exp;

import java.util.Scanner;

public class ReachableDestination {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		
		if(isReachable(x1,y1,x2,y2)){
			System.out.println("True");
		}else{
			System.out.println("False");
		}

		
	}
	
	static boolean isReachable(int x1,int y1,int x2,int y2){
		if(x1>x2 || y1>y2){
			return false;
		}
		if(x1==x2 && y1==y2 ){
			return true;
		}
		return isReachable(x1+y1, y1, x2, y2) || isReachable(x1, x1+y1, x2, y2);
	}
}

/*
 2 10 26 12
 
 20 10 6 12
 */
