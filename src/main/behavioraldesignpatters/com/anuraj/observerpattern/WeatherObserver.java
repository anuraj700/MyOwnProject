
package com.anuraj.observerpattern;

public class WeatherObserver implements Observer {

	private int temp;
	private int pressure;
	private int humidity;
	private Subject subject;

	WeatherObserver(Subject subject) {

		this.subject = subject;
		this.subject.addObserver(this);
	}

	@Override
	public void update(int temp, int pressure, int humidity) {

		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		showData();
	}

	private void showData() {

		System.out.println("Temp : " + this.temp + " pressure : " + this.pressure + " humidity : " + this.humidity);
	}
}
