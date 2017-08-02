package com.anuraj.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	Stack<String> stack = new Stack<String>();
	Queue< String> queue = new LinkedList<String>();
	
	List<String> stackList= new ArrayList<String>();
	List<String> queueList= new ArrayList<String>();
	int stackCursor =0;
	int queueCursor =0;

	void pushCharacter (char c){
		//stack.push(""+c);
		stackList.add(""+c);
	}
	
	void enqueueCharacter(char ch){
		//queue.add(""+ch);
		queueList.add(""+ch);

	}
	
	
	char popCharacter(){
		//return stack.pop().charAt(0);
		String result = stackList.get(stackList.size()-1);
		stackList.remove(stackList.size()-1);
		return result.charAt(0);
	}
	
	char dequeueCharacter(){
		//return queue.remove().charAt(0);
		String result = queueList.get(0);
		queueList.remove(0);
		return result.charAt(0);
	}
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Solution p = new Solution();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;                
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is " 
                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
	
}
