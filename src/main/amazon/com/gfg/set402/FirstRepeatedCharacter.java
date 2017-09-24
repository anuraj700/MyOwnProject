
package com.gfg.set402;

import java.util.Arrays;
import java.util.HashSet;

public class FirstRepeatedCharacter {

	/*
	geeksforgeeks
	e is first repeated character
	e is the first element that repeats
	*/
	/*Simple Solution: The solution is to run two nested loops. Start traversing from left side.
	For every character, check if it repeats or not. If the character repeats, 
	increment count of repeating characters. When the count becomes k, return the character. 
	Time Complexity of this solution is O(n2)*/
	static void simpleSolution(String str) {

		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				} else {
					break;
				}
			}
			if (count > 0) {
				System.out.println(str.charAt(i) + " repeats " + count + " times");
				break;
			}
		}
	}

	/*	We can Use Sorting to solve the problem in O(n Log n) time. Following are detailed steps.
		1) Copy the given array to an auxiliary array temp[].
		2) Sort the temp array using a O(nLogn) time sorting algorithm.
		3) Scan the input array from left to right. For every element, count its
		occurrences in temp[] using binary search. As soon as we find a characterthat occurs more than once, we return the character.

		This step can be done in O(n Log n) time*/
	static void solutionWithSorting(String str) {

		char[] a = str.toCharArray();
		char[] temp = str.toCharArray();
		Arrays.sort(temp);
		for (int i = 0; i < a.length; i++) {
			//TODO : complete after learning binary search
		}
	}

	/*	An efficient solution is to use Hashing to solve this in O(n) time on average.

		Create an empty hash.
		Scan each character of input string and insert values to each keys in the hash.
		When any character appears more than once, hash key value is increment by 1, and return the character.*/
	static char solutionWithHashing(String str) {

		char[] a = str.toCharArray();
		HashSet<Character> hs = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (hs.contains(a[i])) {
				return a[i];
			} else {
				hs.add(a[i]);
			}
		}
		return '\0';
	}

	public static void main(String[] args) {

		String str = "geeksforgeeks";
		simpleSolution(str);
		//solutionWithSorting(str);
		System.out.println(solutionWithHashing(str));
	}
}
