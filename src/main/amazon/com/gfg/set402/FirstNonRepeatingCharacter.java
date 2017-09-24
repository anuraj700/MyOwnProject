
package com.gfg.set402;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

	// Method 1: start O(n)
	static final int NO_OF_CHARS = 256;
	static char count[] = new char[NO_OF_CHARS];

	static void getCharCountArray(String str) {

		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
		}
	}

	static int firstNonRepeating(String str) {

		int index = -1, i;
		for (i = 0; i < str.length(); i++) {
			if (count[str.charAt(i)] == 1) {
				index = i;
				break;
			}
		}
		return index;
	}

	static void printDuplicate(String str) {

		int i;
		for (i = 0; i < str.length(); i++) {
			if (count[str.charAt(i)] > 1) {
				System.out.println("Duplicate char is " + str.charAt(i));
			}
		}
	}

	// Method 1: end
	// Method 2: start O(n)
	static class CountIndex {

		int count, index;

		// constructor for first occurrence
		public CountIndex(int index) {

			this.count = 1;
			this.index = index;
		}

		// method for updating count
		public void incCount() {

			this.count++;
		}
	}

	static HashMap<Character, CountIndex> hm = new HashMap<Character, CountIndex>(NO_OF_CHARS);

	static void getCharCountArray2(String str) {

		for (int i = 0; i < str.length(); i++) {
			if (hm.containsKey(str.charAt(i))) {
				hm.get(str.charAt(i)).incCount();
			} else {
				hm.put(str.charAt(i), new CountIndex(i));
			}
		}
	}

	static int firstNonRepeating2(String str) {

		int result = Integer.MAX_VALUE, i;
		for (i = 0; i < str.length(); i++) {
			if (hm.get(str.charAt(i)).count == 1 && result > hm.get(str.charAt(i)).index) {
				result = hm.get(str.charAt(i)).index;
			}
		}
		return result;
	}

	static void printDuplicate2(String str) {

		int i;
		for (i = 0; i < str.length(); i++) {
			if (hm.get(str.charAt(i)).count > 1) {
				System.out.println("Duplicate char is " + str.charAt(i));
			}
		}
	}

	// Method 2: end
	// Method 3: start  O(n)
	static int[] alphabet = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	static void getCharCountArray3(String str) {

		for (int i = 0; i < str.length(); i++) {
			alphabet[str.charAt(i) - 97]++;
		}
	}

	static int firstNonRepeating3(String str) {

		int result = Integer.MAX_VALUE, i;
		for (i = 0; i < alphabet.length; i++) {
			if (alphabet[i] == 1) {
				result = i + 97;
				break;
			}
		}
		return result;
	}

	static void printDuplicate3(String str) {

		int i, a;
		char c;
		for (i = 0; i < alphabet.length; i++) {
			if (alphabet[i] > 1) {
				a = i + 97;
				c = (char) a;
				System.out.println("Duplicate char is " + c);
			}
		}
	}

	// Method 3: end
	public static void main(String[] args) {

		String str = "geeksforgeeks";
		//Method 1
		System.out.println("Executing method 1");
		getCharCountArray(str);
		int index = firstNonRepeating(str);
		System.out.println(index == -1 ? "Either all characters are repeating or string " + "is empty" : "First non-repeating character is "
		                                                                                                 + str.charAt(index));
		printDuplicate(str);
		//Method 2
		System.out.println("Executing method 2");
		getCharCountArray2(str);
		index = firstNonRepeating2(str);
		System.out.println(index == Integer.MAX_VALUE ? "Either all characters are repeating or string " + "is empty" : "First non-repeating character is "
		                                                                                                                + str.charAt(index));
		printDuplicate2(str);
		//Method 3
		System.out.println("Executing method 3");
		getCharCountArray3(str);
		index = firstNonRepeating3(str);
		if (index == Integer.MAX_VALUE) {
			System.out.println("Either all characters are repeating or string is empty");
		} else {
			char c = (char) index;
			System.out.println("First non-repeating character is " + c);
		}
		printDuplicate3(str);
	}
}
