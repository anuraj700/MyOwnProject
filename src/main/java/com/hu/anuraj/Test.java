package com.hu.anuraj;

public class Test implements Runnable
{
  public void run()
  {
    System.out.printf("BO ");
  }
  public static void main(String[] args) throws InterruptedException
  {
    Thread thread1 = new Thread(new Test());
    thread1.start();
    //thread1.start();
    System.out.println(thread1.getState());
    String s1 = new String("HELLO");
    String s2 = new String("HELLO");
    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
    new A();
    System.out.println(new Car().toString());
    System.out.println(new Car().sum(2.3f, 2));
    System.out.println(new Car().equals(new Car()));
  }
}

class A {
	
	int s1;
	
	A(){
		System.out.println("constructor");
	}
	
	{System.out.println("intializer block");}
	
	static{
		System.out.println("static");
	}
	
	int a = 2;
	float s = 3;
	int a1 = new Integer(3);
	float s2 = new Integer(3);
	
	//int a2 = 2f;
	
	float s3 = new Integer(4) +10;
	
	
	
}

class Car {
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	double sum(int x,int y){
		
		return x+y;
	}
	
	double sum(float x ,float y){
		return x+y;
	}
}
