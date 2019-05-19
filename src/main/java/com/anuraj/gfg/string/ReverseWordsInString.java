package com.anuraj.gfg.string;

import java.util.regex.Pattern;

public class ReverseWordsInString {

	public static void main(String[] args) {
		 String s1 = "Welcome to geeksforgeeks"; 
	        System.out.println(reverseWords(s1)); 
	  
	        String s2 = "I love Java Programming"; 
	        System.out.println(reverseWords2(s2));
	}
	
	static String reverseWords(String str){
		String result = "";;
		
		String [] arr = str.split(" ");
		for (int i =arr.length-1 ;i >=0 ;i --){
			result = result + arr[i] + " ";
		}
		return result.substring(0, result.length()-1);
	}

	static String reverseWords2 (String str){
		String result ="";
		Pattern pattern = Pattern.compile("\\s");
		String[] arr = pattern.split(str);
		for(int i =0 ;i < arr.length ;i++){
			if(i == arr.length -1){
				result = arr[i]+ result;
			}else{
				result = " " + arr[i] + result;
			}
		}
		return result;
	}
	
}
