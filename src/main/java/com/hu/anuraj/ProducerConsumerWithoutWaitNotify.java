
package com.hu.anuraj;

import java.util.ArrayList;
import java.util.List;

class Producer2 implements Runnable {

	List<Integer> sharedQueue;
	boolean productionInProcess;

	public Producer2() {

		sharedQueue = new ArrayList<Integer>();
		productionInProcess = true;
	}

	public void run() {

		for (int i = 1; i <= 10; i++) {
			System.out.println("Producing: " + i);
			sharedQueue.add(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		productionInProcess = false;
	}
}

class Consumer2 implements Runnable {

	Producer2 prod;

	public Consumer2(Producer2 prod) {

		this.prod = prod;
	}

	public void run() {

		while (this.prod.productionInProcess) {
			System.out.println("Waiting for production to over");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Production has finished");
		int prodSize = this.prod.sharedQueue.size();
		for (int i = 0; i < prodSize; i++) {
			System.out.println("Consuming :" + this.prod.sharedQueue.remove(0));
		}
	}
}

public class ProducerConsumerWithoutWaitNotify {

	public static void main(String[] args) {

		Producer2 prod = new Producer2();
		Consumer2 cons = new Consumer2(prod);
		Thread prodThread = new Thread(prod, "ProdThread");
		Thread consThread = new Thread(cons, "ConsThread");
		consThread.start();
		prodThread.start();
	}
}
