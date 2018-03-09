package com.anuraj.matrix;

public class SpiralPrintMatrix {
	
	
	static void printSprint(int m, int n, int[][]a){
		
		int k=0,l=0,i;
		
		while(k<m && l<n){
			
			for(i=l;i<n;i++){
				System.out.print(a[k][i] + " ");
			}
			k++;
			
			for(i=k;i<m ;i++){
				System.out.print(a[i][n-1]+" ");
			}
			n--;
			
			
			if(k<m){
				for(i=n-1;i>=l;i--){
					System.out.print(a[m-1][i]+" ");
				}
				m--;
			}
			
			if(l<n){
				for(i=m-1;i>=k;i--){
					System.out.print(a[i][l]+" ");
				}
				l++;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int row = 4;
        int col = 6;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                      {7,  8,  9,  10, 11, 12},
                      {13, 14, 15, 16, 17, 18},
                      {19, 20, 21, 22, 23, 24}
                    };
        printSprint(row,col,a);

	}

}
