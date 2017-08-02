package com.anuraj.hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlusMinus {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       // String time = in.next();
        String time ="04:00:00AM";
        String hr=null,min=null,ss=null,mode=null;
        int cHr =12;
        String pattern = "(\\d+)(:)(\\d+)(:)(\\d+)(\\w+)(.*)";
        Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(time);
		System.out.println(m.groupCount());
		if (m.find()) {
			for (int i=0; i<m.groupCount();i++){
				System.out.println("group"+i+":"+ m.group(i));
			}
			hr = m.group(1);
			min = m.group(3);
			ss = m.group(5);
			mode = m.group(6);
		}else {
			System.out.println("NO MATCH");
		}
       if ("PM".equalsIgnoreCase(mode) && !hr.equalsIgnoreCase("12")){
    	   cHr= 12+ Integer.parseInt(hr);
    	   hr = ""+cHr;
       }
       if ("AM".equalsIgnoreCase(mode) && hr.equalsIgnoreCase("12")){
    	   cHr= 12+ Integer.parseInt(hr);
           hr = ""+cHr;
       }
       if(cHr==24 && "AM".equalsIgnoreCase(mode)){
    	   hr="00";
       }
       System.out.println(hr+":"+min+":"+ss);
    }
}
