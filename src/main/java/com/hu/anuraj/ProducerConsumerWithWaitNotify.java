
package com.hu.anuraj;

import java.util.ArrayList;

class Producer implements Runnable {

	ArrayList<Integer> sharedQueue;

	Producer() {

		sharedQueue = new ArrayList<Integer>();
	}

	public void run() {

		synchronized (this) {
			for (int i = 1; i < 11; i++) {
				sharedQueue.add(i);
				System.out.println("System is producing : " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
			}
			System.out.println("Production is over");
			this.notify();
		}
	}
}

class Consumer implements Runnable {

	Producer prod;

	Consumer(Producer obj) {

		this.prod = obj;
	}

	public void run() {

		synchronized (this.prod) {
			System.out.println("Waiting for production to get over");
			try {
				this.prod.wait();
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
		int productSize = this.prod.sharedQueue.size();
		for (int i = 0; i < productSize; i++) {
			System.out.println("consuming : " + this.prod.sharedQueue.remove(0));
		}
	}
}

public class ProducerConsumerWithWaitNotify {

	public static void main(String[] args) {

		Producer prod = new Producer();
		Consumer cons = new Consumer(prod);
		Thread prodThread = new Thread(prod, "Prodthread");
		Thread consThread = new Thread(cons, "Consthred");
		consThread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		prodThread.start();
	}
}
