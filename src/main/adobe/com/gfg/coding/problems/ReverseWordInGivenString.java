package com.gfg.coding.problems;

import java.util.Scanner;
import java.util.Stack;

/*
 * Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.

Input:
The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.

Output:
For each test case, in a new line, output a single line containing the reversed String.

Constraints:
1 <= T <= 100
1 <= |S| <= 2000

Example:
Input:
2
i.like.this.program.very.much
pqr.mno

Output:
much.very.program.this.like.i
mno.pqr
 */
public class ReverseWordInGivenString {

	public static String reverse(String str) {
		StringBuilder result = new StringBuilder();
		String[] arr=  str.split("\\.");
		
		Stack<String> stk  = new Stack<>();
		//"i,like,this".split(",");
		for(String st : arr){
			stk.push(st);
		}
		while(!stk.empty()){
			result.append(stk.pop());
			result.append(".");
		}
		int len = result.toString().length();
		return result.toString().substring(0, len-1);
		//return result.toString();
	}


	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n > 0) {
			String a = in.next();
			System.out.println(reverse(a));
			n--;
		}

		in.close();
	}

}
