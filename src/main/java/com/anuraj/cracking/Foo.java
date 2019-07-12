package com.anuraj.cracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Foo {
	public static void main(String[] args)  throws Exception{
		main1(args);
	}
	public static void main1(String[] args) throws InterruptedException {
        List<String> inputByLine = new ArrayList<String>();
        try {
            // Get the object of DataInputStream
            InputStreamReader isr = new InputStreamReader(System.in,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null){
                inputByLine.add(line.toString());
            }
           
            for (String line2 : inputByLine){
            	int count0 = 0;
                int count1 = 0;
            	Scanner in = new Scanner(line2);
            	int[] arr = new int[line2.length()];
            	while(in.hasNext()){
            		int temp = in.nextInt();
            		System.out.println("remp is"+temp);
            		if(temp ==0)
            			count0++;
            		else
            			count1++;
            	}
            	for(int i =0 ;i < line2.length();i++){
            		
            	
            		if(i< count1)
            			arr[i] =1;
            		else
            			arr[i] =0;
            	}
            	for(int i =0 ;i < line2.length();i++)
            		System.out.print(arr[i]);
            }
            
            
            
           // for (String line2 : inputByLine)
            //System.out.print(line2);
            isr.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
}
	
	public static void main2(String[] args) throws InterruptedException {
        List<String> inputByLine = new ArrayList<String>();
        try {
            // Get the object of DataInputStream
            InputStreamReader isr = new InputStreamReader(System.in,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null){
                inputByLine.add(line.toString());
            }
            //jack   is       from  America.
           // Pattern pattern = new Patt"//s+";
            
            for (String line2 : inputByLine){
                System.out.println(line2);
                String result ="";
                Scanner in = new Scanner(line2);
                while(in.hasNext()){
                	//System.out.print(in.next()+" " );
                	result = result + in.next() + " ";
                }
                System.out.println(result.substring(0,result.length()-1));
            }
            isr.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
