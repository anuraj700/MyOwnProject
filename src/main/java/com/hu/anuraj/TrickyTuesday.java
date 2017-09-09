
package com.hu.anuraj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArrayList;
 
class Employee{
    String name; 
    public Employee() {}
    public Employee(String name) {
        this.name = name;
    }  
    public String toString() {
        return "name=" + name;
    }
    static class ComparatorName implements Comparator<Employee>{
        public int compare(Employee obj1, Employee obj2) {
           return obj1.name.compareTo(obj2.name);
        }
    }
}
 
/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class TrickyTuesday {
    public static void main(String[] args) {
    	
    	List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
    	 
        copyOnWriteArrayList.add("ind");
        copyOnWriteArrayList.add("usa");
        copyOnWriteArrayList.add(null);

        for (String string : copyOnWriteArrayList) {
               System.out.print(string+" ");
               System.out.println(copyOnWriteArrayList);
               copyOnWriteArrayList.add("newEle3");
               System.out.println(copyOnWriteArrayList);

        }
        Employee emp1=new Employee("ankit");
        Employee emp2=new Employee("brad");
       
       ArrayList<Employee> list=new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.set(1,emp1);
 
        Collections.sort(list,new Employee.ComparatorName());
        System.out.println(list);
    }
}