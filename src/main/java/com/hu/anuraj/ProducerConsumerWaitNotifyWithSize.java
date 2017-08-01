
package com.hu.anuraj;

import java.util.ArrayList;
import java.util.List;

class Producer1 implements Runnable {

	private List<Integer> sharedQueue;
	private int maxSize = 2;

	public Producer1(List<Integer> sharedQueue) {

		this.sharedQueue = sharedQueue;
	}

	public void run() {

		for (int i = 1; i <= 10; i++) {
			try {
				produce(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void produce(int i) throws InterruptedException {

		synchronized (sharedQueue) {
			while (sharedQueue.size() == maxSize) {
				System.out.println("Producer is full, waiting for consumer to consume , size = " + sharedQueue.size());
				sharedQueue.wait();
			}
		}
		synchronized (sharedQueue) {
			System.out.println("Producing :" + i);
			sharedQueue.add(i);
			Thread.sleep((long) (Math.random() * 1000));
			sharedQueue.notify();
		}
	}
}

class Consumer1 implements Runnable {

	private List<Integer> sharedQueue;

	public Consumer1(List<Integer> sharedQueue) {

		this.sharedQueue = sharedQueue;
	}

	public void run() {

		while (true) {
			try {
				consume();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {

		synchronized (sharedQueue) {
			while (sharedQueue.size() == 0) {
				System.out.println("Waiting for producer to produce, size=" + sharedQueue.size());
				sharedQueue.wait();
			}
		}
		synchronized (sharedQueue) {
			Thread.sleep((long) (Math.random() * 2000));
			System.out.println("Consuming:" + sharedQueue.remove(0));
			sharedQueue.notify();
		}
	}
}

public class ProducerConsumerWaitNotifyWithSize {

	public static void main(String[] args) {

		List<Integer> sharedQueue = new ArrayList<Integer>();
		Producer1 prod = new Producer1(sharedQueue);
		Consumer1 cons = new Consumer1(sharedQueue);
		Thread prodThread = new Thread(prod, "ProdThread");
		Thread consThread = new Thread(cons, "ConsThread");
		consThread.start();
		prodThread.start();
	}
}
