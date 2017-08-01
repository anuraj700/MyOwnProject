
package com.hu.anuraj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AstronautPair {

	public static void main(String[] args) throws Exception {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bfr.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int I = Integer.parseInt(temp[1]);
		Integer[][] arr = new Integer[N][N];
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < I; i++) {
			temp = bfr.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			// Store a and b in an appropriate data structure of your choice
			Integer value = null;
			if (m.isEmpty()) {
				value = minOf(a, b);
				m.put(a, value);
				m.put(b, value);
			} else if (m.containsKey(a)) {
				value = minOf(minOf(a, b), m.get(a));
				m.put(b, value);
			} else if (m.containsKey(b)) {
				value = minOf(minOf(a, b), m.get(b));
				m.put(a, value);
			} else {
				value = minOf(a, b);
				m.put(a, value);
				m.put(b, value);
			}
			arr[a][b] = value;
			arr[b][a] = value;
			if (a < b) {
				putInArray(b, m, arr);
				putInArray(a, m, arr);
			} else {
				putInArray(a, m, arr);
				putInArray(b, m, arr);
			}
		}
		System.out.println(m.toString());
		for (int i1 = 0; i1 < N; i1++) {
			for (int j1 = 0; j1 < N; j1++) {
				System.out.print(arr[i1][j1] + "\t");
			}
			System.out.println();
		}
		long combinations = 0;
		// Compute the final answer - the number of combinations
		for (int i1 = 0; i1 < N; i1++) {
			for (int j1 = i1 + 1; j1 < N; j1++) {
				if (arr[i1][j1] == null) {
					combinations = combinations + 1;
				}
			}
		}
		System.out.println(combinations);
	}

	public static int minOf(int a, int b) {

		return Math.min(a, b) + 1;
	}

	public static void putInArray(int i, Map<Integer, Integer> m, Integer[][] arr) {

		for (Map.Entry<Integer, Integer> obj : m.entrySet()) {
			if (obj.getValue() == m.get(i) && i != obj.getKey()) {
				arr[i][obj.getKey()] = m.get(i);
				arr[obj.getKey()][i] = m.get(i);
			}
		}
	}
}
