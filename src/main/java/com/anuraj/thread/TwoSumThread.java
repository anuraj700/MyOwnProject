package com.anuraj.thread;

public class TwoSumThread implements Runnable{
	

	@Override
	public void run() {
		add(2, 3);
		
	}
    private Integer sum1Lock = new Integer(0);
    private Integer sum2Lock = new Integer(0);

    public void add(int val1, int val2){
        synchronized(this.sum1Lock){
            this.sum1Lock += val1;
            System.out.println("sum of 1: "+sum1Lock + " by "+Thread.currentThread().getName());
        }

        synchronized(this.sum2Lock){
            this.sum2Lock += val2;
            System.out.println("sum of 2: "+sum2Lock + " by "+Thread.currentThread().getName());
        }
        
    }

    
	public static void main(String[] args) {
		TwoSumThread ts = new TwoSumThread();
		Thread t1 = new Thread(ts,"t1");
		Thread t2 = new Thread(ts,"t2");
		
		t1.start();
		t2.start();
		
	}
}
