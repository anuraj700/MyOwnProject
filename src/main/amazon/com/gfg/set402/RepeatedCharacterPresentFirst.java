
package com.gfg.set402;

public class RepeatedCharacterPresentFirst {

	/*
	geeksforgeeks
	G is repeated character present first in the string
	mind that it will be g, not e.
	*
	*
	look into FirstRepeatedCharacter program
	e is first repeated character
	e is the first element that repeats
	*/
	/*Simple Solution using O(N^2) complexity
	The solution is to loop through the string for each character and search for the same in the rest of the string. 
	This would need two loops and thus not optimal.*/
	static int simpleSolution(String str) {

		int p = -1;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					p = i;
					break;
				}
			}
			if (p != -1) {
				break;
			}
		}
		return p;
	}

	/*	Optimization by counting occurrences

		This solution is optimized by using the following techniques:
		1. We loop through the string and hash the characters using ASCII codes. 
		Store 1 if found and store 2 if found again. Also, store the position of the letter first found in.

		2. We run a loop on the hash array and now we find the minimum position of any character repeated.

		This will have a runtime of O(N).*/
	static int optimizedSolution(String str) {

		int p = -1, k;
		int MAX_CHAR = 256;
		int[] hash = new int[MAX_CHAR];
		int[] pos = new int[MAX_CHAR];
		for (int i = 0; i < str.length(); i++) {
			k = (int) str.charAt(i);
			if (hash[k] == 0) {
				hash[k]++;
				pos[k] = i;
			} else if (hash[k] == 1) {
				hash[k]++;
			}
		}
		for (int i = 0; i < MAX_CHAR; i++) {
			if (hash[i] == 2) {
				if (p == -1) {
					p = pos[i];
				} else if (p > pos[i]) {
					p = pos[i];
				}
			}
		}
		return p;
	}

	public static void main(String[] args) {

		String str = "geeksforgeeks";
		int p = simpleSolution(str);
		if (p == -1) {
			System.out.println("NotFound");
		} else {
			System.out.println(str.charAt(p) + " is repeated character present first");
		}
		p = optimizedSolution(str);
		if (p == -1) {
			System.out.println("NotFound");
		} else {
			System.out.println(str.charAt(p) + " is repeated character present first");
		}
	}
}
