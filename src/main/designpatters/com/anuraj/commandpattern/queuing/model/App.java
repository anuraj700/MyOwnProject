
package com.anuraj.commandpattern.queuing.model;

public class App {

	public static void main(String[] args) {

		final Algorithm algorithm = new Algorithm();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				algorithm.produce();
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				algorithm.consume();
			}
		});
		t1.start();
		t2.start();
	}
}
