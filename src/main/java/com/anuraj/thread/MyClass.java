package com.anuraj.thread;

public class MyClass implements Runnable{
     int x=0;
    @Override
    public void run() {
 
           System.out.println(Thread.currentThread().getName()+" is waiting for lock");
           synchronized (this) {
                  try {
                        System.out.println(Thread.currentThread().getName()+" has acquired lock and value is"+ x++);
                        Thread.sleep(2000); //sleep for 2 seconds
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
                  System.out.println(Thread.currentThread().getName()+" has ended");
           }
           
    
    }
    
    public static void main(String[] args) {
                  MyClass obj=new MyClass();
                  
        Thread thread1=new Thread(obj,"Thread-1");
        Thread thread2=new Thread(obj,"Thread-2");
        Thread thread3=new Thread(obj,"Thread-3");
        
        thread1.start();
        thread2.start();   //swetharao@ansaluniversity.edu.in 511711231 511712500



        					//name of student 
        thread3.start();
    }
 
}

