package com.anuraj.gfg.string;

import java.util.Stack;

public class ParanthesisChecker {

	public static void main(String[] args) {
		char exp[] = {'{','(',')','}','[',']'}; 
        if (areParenthesisBalanced(exp)) 
          System.out.println("Balanced "); 
        else
          System.out.println("Not Balanced "); 
	}
	
	static boolean areParenthesisBalanced(char[] exp){
		
		Stack<Character> st = new Stack<>();
		for (int i = 0 ;i < exp.length ;i++){
			
			if(exp[i] == '(' || exp[i] == '{' || exp[i] == '['){
				st.push(exp[i]);
				continue;
			}
			
			if(exp[i] == ')' || exp[i] == '}' || exp[i] == ']'){
				if(st.empty()){
					return false;
				} else if ( !isMatchingPair(st.pop(),exp[i])) {
					return false;
				}
			}
			
			
		}
		
		if(st.empty()){
			return true;
		}else{
			return false;
		}
	}
	
	static boolean isMatchingPair (char first , char second) {
		 if ( first == '(' && second == ')')
			 return true;
		 if(first == '{' && second == '}')
			 return true;
		 if ( first == '[' && second == ']')
			 return true;
		 return false;
		
	}
}
