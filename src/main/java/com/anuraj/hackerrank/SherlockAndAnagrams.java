	package com.anuraj.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SherlockAndAnagrams {
    static int sherlockAndAnagrams(String s){
        // Complete this function
    	Map<String,String> all= new HashMap<String,String>();
    	int count=0;
        for(int i=0;i<=s.length();i++){
            for(int j=i+1;j<=s.length();j++){
            	//System.out.println(i+""+j);
            	//System.out.println(s.substring(i,j));
            	String s1=s.substring(i,j);
            	all.put(i+""+j, s1 );
            }
            
        }
        System.out.println(all.values().toString());
        String[] arr = all.values().toArray(new String[0]);
        
        for ( int i=0;i<arr.length;i++){
        	for (int j=i+1;j<arr.length;j++){
        		if(arr[i].length() == arr[j].length()){
    				int counter=0;
        			for(int k =0;k<arr[i].length();k++){
        				if(arr[j].contains(Character.toString(arr[i].charAt(k)))){
        					counter++;
        					arr[j].replaceFirst(Character.toString(arr[i].charAt(k)), "");
        				}
        			}
        			if(counter == arr[i].length() ){
        				System.out.println(arr[i]);
        				System.out.println(arr[j]);

    					count++;
    				}
        		}
        		
        	}
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q =1;// in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = "hucpoltgty";//in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }
}
