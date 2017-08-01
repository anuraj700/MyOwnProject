
package com.hu.anuraj;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SequencePrinter2 {

	AtomicInteger sharedOutput = new AtomicInteger(0);

	public static void main(String[] args) {

		SequencePrinter2 s2 = new SequencePrinter2();
		Worker2 w1 = s2.new Worker2();
		Worker2 w2 = s2.new Worker2();
		Worker2 w3 = s2.new Worker2();
		w1.setNext(w2);
		w2.setNext(w3);
		w3.setNext(w1);
		Thread t1 = new Thread(w1, "Thread-1");
		Thread t2 = new Thread(w2, "Thread-2");
		Thread t3 = new Thread(w3, "Thread-3");
		t1.start();
		t2.start();
		t3.start();
		//w1.accept(1);
	}

	class Worker2 implements Runnable {

		BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
		Worker2 next = null;

		public void setNext(Worker2 t) {

			this.next = t;
		}

		public void accept(int i) {

			q.add(i);
		}

		public void run() {

			while (sharedOutput.get() < 9) {
				synchronized (sharedOutput) {
					try {
						int i = sharedOutput.get() + 1;
						System.out.println(Thread.currentThread().getName() + " : " + i);
						sharedOutput.incrementAndGet();
						//Thread.sleep(1000);
						//						if (next != null) {
						//							next.accept(i + 1);
						//						}
						sharedOutput.notifyAll();
						try {
							sharedOutput.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} catch (Exception e) {
						System.err.println(Thread.currentThread().getName() + "interrupted");
					}
				}
			}
		}
	}
}