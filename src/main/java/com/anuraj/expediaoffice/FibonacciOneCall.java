
package com.anuraj.expediaoffice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

public class FibonacciOneCall {

	public static void main(String[] args) {

		System.out.println("\nPrinting raw value " + print(10));
		printFibonacci(10);
		System.out.println("\n using dynamic programming");
		System.out.print(dyanamicFibonnaci(10));
		System.out.println("\n using dynamic programming array");
		System.out.print(Arrays.toString(dyanamicFibonnaciArray(10)));
	}

	private static int dyanamicFibonnaci(int n) {

		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}

	private static int[] dyanamicFibonnaciArray(int n) {

		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}

	private static void printFibonacci(int n) {

		Stack<Integer> st = new Stack<Integer>();
		Deque<Integer> deAdd = new ArrayDeque<Integer>();
		Deque<Integer> deAddFirst = new ArrayDeque<Integer>();
		Deque<Integer> dePush = new ArrayDeque<Integer>();
		for (int i = n; i >= 0; i--) {
			st.push(print(i));
			deAddFirst.addFirst(print(i));
			deAdd.add(print(i));
			dePush.push(print(i));
		}
		System.out.println("\nPrinting stack");
		while ( !st.empty()) {
			System.out.print(st.pop() + " ");
		}
		System.out.println("\n\nPrinting original dequeue deAddFirst content");
		System.out.println(deAddFirst);
		System.out.println("\nPrinting dequeue deAddFirst with iterator");
		Iterator<Integer> it = deAddFirst.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println("\nPrinting dequeue deAddFirst with descendingIterator");
		Iterator<Integer> it1 = deAddFirst.descendingIterator();
		while (it1.hasNext()) {
			System.out.print(it1.next() + " ");
		}
		System.out.println("\n\nPrinting original dequeue deAdd content");
		System.out.println(deAdd);
		System.out.println("\nPrinting dequeue deAdd with iterator");
		Iterator<Integer> it2 = deAdd.iterator();
		while (it2.hasNext()) {
			System.out.print(it2.next() + " ");
		}
		System.out.println("\nPrinting dequeue deAdd with descendingIterator");
		Iterator<Integer> it3 = deAdd.descendingIterator();
		while (it3.hasNext()) {
			System.out.print(it3.next() + " ");
		}
		System.out.println("\n\nPrinting original dequeue dePush content");
		System.out.println(dePush);
		System.out.println("\nPrinting dequeue dePush with iterator");
		Iterator<Integer> it4 = dePush.iterator();
		while (it4.hasNext()) {
			System.out.print(it4.next() + " ");
		}
		System.out.println("\nPrinting dequeue dePush with descendingIterator");
		Iterator<Integer> it5 = dePush.descendingIterator();
		while (it5.hasNext()) {
			System.out.print(it5.next() + " ");
		}
		System.out.println();
	}

	private static int print(int n) {

		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		return print(n - 1) + print(n - 2);
	}
}
