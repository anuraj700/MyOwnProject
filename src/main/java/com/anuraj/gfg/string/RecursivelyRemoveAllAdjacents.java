package com.anuraj.gfg.string;

public class RecursivelyRemoveAllAdjacents {

	/*We can remove all duplicates in O(n) time. 
	1) Start from the leftmost character and remove duplicates at left corner if there are any.
	2) The first character must be different from its adjacent now. Recur for string of length n-1 (string without first character).
	3) Let the string obtained after reducing right substring of length n-1 be rem_str. There are three possible cases
	……..a) If first character of rem_str matches with the first character of original string, remove the first character from rem_str.
	……..b) If remaining string becomes empty and last removed character is same as first character of original string. Return empty string.
	……..c) Else, append the first character of the original string at the beginning of rem_str.
	4) Return rem_str.*/
	static String removeUtil(String str, char last_removed) 
    { 
		if(str.length() ==0 ||str.length() ==1){
			return str;
		}
		
		if(str.charAt(0) == str.charAt(1)){
			last_removed = str.charAt(0);
			while(str.length() >1 && str.charAt(0) == str.charAt(1)){
				str= str.substring(1,str.length());
			}
			str = str.substring(1,str.length());
			return removeUtil(str,last_removed);
		}
		
		String rem_str = removeUtil(str.substring(1,str.length()),last_removed);
		
		if(rem_str.length() !=0 && rem_str.charAt(0) == str.charAt(0)){
			last_removed = rem_str.charAt(0);
			return rem_str.substring(1,rem_str.length());
		}
		
		if(rem_str.length() ==0 && last_removed == str.charAt(0)){
			return rem_str;
		}
		return (str.charAt(0)+rem_str);
    }
	
	static String remove(String str)   
    { 
           char last_removed = '\0'; 
           return removeUtil(str, last_removed);        
    }
	public static void main(String[] args) {
		String str1 = "geeksforgeeg"; 
        System.out.println(remove(str1)); 

        String str2 = "azxxxzy"; 
        System.out.println(remove(str2)); 

        String str3 = "caaabbbaac"; 
        System.out.println(remove(str3)); 

        String str4 = "gghhg"; 
        System.out.println(remove(str4)); 

        String str5 = "aaaacddddcappp"; 
        System.out.println(remove(str5)); 

        String str6 = "aaaaaaaaaa"; 
        System.out.println(remove(str6)); 

        String str7 = "qpaaaaadaaaaadprq"; 
        System.out.println(remove(str7)); 

        String str8 = "acaaabbbacdddd"; 
        System.out.println(remove(str8)); 
	}

}
