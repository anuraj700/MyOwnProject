package com.anuraj.misc;

public class CheckReturnInFinally {
	
	public static void main(String[] args) {
		
		System.out.println(check());
		
	}

	private static int check(){
		try{
			int i = 6%6;
			return i;
		}catch(ArithmeticException e){
			return 2;
		}finally{
			return 3;
		}
	}
	
}
