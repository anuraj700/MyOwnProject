package com.anuraj.gfg.string;

public class LongestPalindromeString {
	
	static void printSubStr(String str, int low, int high) { 
        System.out.println(str.substring(low, high + 1)); 
    } 
	
	// Time O(n^2)
	/*Step to generate odd length palindrome:
	Fix a centre and expand in both directions for longer palindromes.

	Step to generate even length palindrome
	Fix two centre ( low and high ) and expand in both directions for longer palindromes.
*/		
	public static void main(String[] args) {
		String str = "forgeeksskeegfor"; 
        System.out.println("Length is: " +  
                           longestPalSubstr(str));
	}
	
	static int longestPalSubstr(String str) {
		int maxlength =1;
		
		int start = 0 ;
		int len = str.length();
		
		int low , high;
		
		for (int i = 0 ;i < len ;i++){
			
			// Find the longest even length palindrome with  
            // center points as i-1 and i.
			low= i-1;
			high = i;
			
			while(low >0 && high < len && str.charAt(low) == str.charAt(high) ){
				
				if(high -low +1 > maxlength){
					start = low;
					maxlength = high -low +1;
				}
				--low;
				++high;
			}
			
			
			// Find the longest odd length palindrome with  
            // center point as i 
			low = i-1;
			high = i+1;
			while (low < 0 && high > len && str.charAt(low) == str.charAt(high)){
				
				if(high -low +1 > maxlength){
					start = low;
					maxlength = high -low +1;
				}
				--low;
				++high;
				
			}
		}
		 System.out.print("Longest palindrome substring is: "); 
	     printSubStr(str, start, start + maxlength - 1); 
		
		return maxlength;
		
	}
    
}
