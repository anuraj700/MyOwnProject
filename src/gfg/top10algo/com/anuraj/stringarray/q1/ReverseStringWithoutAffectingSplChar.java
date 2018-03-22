
package com.anuraj.stringarray.q1;

public class ReverseStringWithoutAffectingSplChar {

	static boolean isAlphabet(char c) {

		return ((c > 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
	}

	static void reverse(char[] arr, int start, int end) {

		while (start < end) {
			if ( !isAlphabet(arr[start])) {
				start++;
			} else if ( !isAlphabet(arr[end])) {
				end--;
			} else {
				char temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}
	}

	static void printArray(char[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {

		String str = "a!!!b.c.d,e'f,ghi";
		char[] arr = str.toCharArray();
		printArray(arr);
		reverse(arr, 0, arr.length - 1);
		System.out.println("Reversed array is");
		printArray(arr);
	}
}
