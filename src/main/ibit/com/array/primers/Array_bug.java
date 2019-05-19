package com.array.primers;

import java.util.ArrayList;

public class Array_bug {
	
	private  ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(B>A.size()){
            B = B%A.size();
        }
       // System.out.println("value of B is"+B);
        for (int i = 0; i < A.size()-B; i++) {
            ret.add(A.get(i+B));
           //System.out.println("adding is"+A.get(i+B)); 
        }
        //System.out.println("printing");
        int j =0;
        //for(int n = B;n <= A.size();n++){
        for(int n = A.size()-B ;n <A.size();n++){
           ret.add(A.get(j));
           //System.out.println("adding anohter is"+A.get(j)); 

           j++;
        }
        return ret;
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);A.add(2);A.add(3);A.add(4);A.add(5);A.add(6);
		ArrayList<Integer> B = new Array_bug().rotateArray(A, 1);
		for(int i=0;i<B.size();i++){
			System.out.print(B.get(i) +" ");
		}
	}

}
