package com.array.primers;

import java.util.ArrayList;

public class Array_2d {

	public static void main(String[] args) {
		//A : [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]] ;
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(1);temp.add(2);temp.add(3);temp.add(4);
		A.add(temp);
		temp=new ArrayList<>();
		temp.add(5);temp.add(6);temp.add(7);temp.add(8);
		A.add(temp);
		temp=new ArrayList<>();
		temp.add(9);temp.add(10);temp.add(11);temp.add(12);
		A.add(temp);
		ArrayList<ArrayList<Integer>> B =  new Array_2d().performOps(A);
		for (int i = 0; i < B.size(); i++) {
		    for (int j = 0; j < B.get(i).size(); j++) {
		            System.out.print(B.get(i).get(j) + " ");
		    }
		}


	}
	
	private ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());
        
            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
}


}
