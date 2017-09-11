
package com.anuraj.observerpattern;

public class App {

	public static void main(String[] args) {

		WeatherStationSubject subject = new WeatherStationSubject();
		WeatherObserver observer = new WeatherObserver(subject);
		subject.setHumidity(100);
		subject.setPressure(200);
		subject.setTemp(300);
	}
}
