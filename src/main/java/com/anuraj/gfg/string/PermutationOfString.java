package com.anuraj.gfg.string;

public class PermutationOfString {

	public static void main(String[] args) {
		String s = "abb"; 
        printPermutn(s, "");
        //printDistinctPermutn (s ,"");
	}
	static void printPermutn(String s, String ans){
		
		if(s.length() ==0){
			System.out.println(ans + " ");
			return;
		}
		
		for (int i = 0 ; i < s.length();i++){
			// ith character of str 
			char ch = s.charAt(i);
			// Rest of the string after excluding  
            // the ith character 
			String ros = s.substring(0,i) + s.substring(i+1);
			
			printPermutn(ros, ans+ch);
		}
	}
	
	static void printDistinctPermutn(String s , String ans){
		
		if(s.length() ==0){
			System.out.println(ans + " ");
			return;
		}
		
		boolean[] alpha = new boolean[26];
		
		for (int i =0 ;i <s.length();i++){
			
			char ch = s.charAt(i);
			
			String ros = s.substring(0,i) +s.substring(i+1);
			
			if(alpha[ch- 'a'] == false){
				printDistinctPermutn(ros, ans+ch);
			}
			alpha[ch-'a'] = true;
		}
	}

}
