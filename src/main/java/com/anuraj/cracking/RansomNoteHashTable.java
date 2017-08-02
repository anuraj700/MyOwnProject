package com.anuraj.cracking;

import java.util.*;
import java.util.Map.Entry;

public class RansomNoteHashTable {
	Map<String, Integer> magazineMap;
	Map<String, Integer> noteMap;

	public RansomNoteHashTable(String magazine, String note) {
		magazineMap = new HashMap<String, Integer>();
		noteMap = new HashMap<String, Integer>();

		for (String str : magazine.split(" ")) {
			Integer value = 1;
			if (magazineMap.containsKey(str)) {
				value = magazineMap.get(str) + 1;
			}
			magazineMap.put(str, value);
		}
		System.out.println(magazineMap.toString());
		for (String str : note.split(" ")) {
			Integer value = 1;
			if (noteMap.containsKey(str)) {
				value = noteMap.get(str) + 1;
			}
			noteMap.put(str, value);
		}
		System.out.println(noteMap.toString());
	}

	public boolean solve() {

		for (Map.Entry<String, Integer> entry : noteMap.entrySet()) {
			if (magazineMap.containsKey(entry.getKey())) {
				if (magazineMap.get(entry.getKey()) - entry.getValue() < 0) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		// Eat whitespace to beginning of next line
		scanner.nextLine();

		RansomNoteHashTable s = new RansomNoteHashTable(scanner.nextLine(),
				scanner.nextLine());
		scanner.close();

		boolean answer = s.solve();
		if (answer)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}
