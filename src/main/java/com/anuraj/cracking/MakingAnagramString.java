package com.anuraj.cracking;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MakingAnagramString {
	public static int numberNeeded(String first, String second) {

		Map<Object, Integer> ma = new HashMap<Object, Integer>();
		for (int i = 0; i < first.length(); i++) {
			Integer val = 1;
			if (ma.containsKey(first.charAt(i))) {
				val = ma.get(first.charAt(i)) + 1;
			} else {
				val = 1;
			}
			ma.put(first.charAt(i), val);
		}
		// System.out.println(ma.toString());

		Integer result = 0;
		for (int i = 0; i < second.length(); i++) {
			Integer val = 1;
			if (ma.containsKey(second.charAt(i))) {
				val = ma.get(second.charAt(i)) - 1;
				ma.put(second.charAt(i), val);

			} else {
				result++;
			}
		}
		// System.out.println(ma.toString());
		Collection<Integer> mapValues = ma.values();
		for (Integer obj : mapValues) {
			result = result + Math.abs(obj);
		}
		return result;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
		System.out.println(numberNeeded2(a, b));
		in.close();
	}

	// for reference some other guy solution

	public static int numberNeeded2(String first, String second) {
		int[] lettercounts = new int[26];
		for (char c : first.toCharArray()) {
			lettercounts[c - 'a']++;
		}
		for (char c : second.toCharArray()) {
			lettercounts[c - 'a']--;
		}
		int result = 0;
		for (int i : lettercounts) {
			result += Math.abs(i);
		}
		return result;
	}
}