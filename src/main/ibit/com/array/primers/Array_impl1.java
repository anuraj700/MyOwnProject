package com.array.primers;

import java.util.ArrayList;

public class Array_impl1 {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(5);A.add(10);A.add(2);A.add(1);
		ArrayList<Integer> B = new Array_impl1().performOps(A);
		for (int i = 0; i < B.size(); i++) {
		        System.out.print(B.get(i) + " ");
		}

	}
	
	private ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
                B.set(i, A.get(i));
                B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
}

}
