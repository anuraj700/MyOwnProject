
package com.anuraj.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationSubject implements Subject {

	private int temp;
	private int pressure;
	private int humidity;
	private List<Observer> observerList;

	public WeatherStationSubject() {

		this.observerList = new ArrayList<>();
	}

	@Override
	public void addObserver(Observer o) {

		this.observerList.add(o);
	}

	@Override
	public void removeObserver(Observer o) {

		this.observerList.remove(o);
	}

	@Override
	public void notifyAllObserver() {

		for (Observer o : this.observerList) {
			o.update(this.temp, this.pressure, this.humidity);
		}
	}

	public void setTemp(int temp) {

		this.temp = temp;
		notifyAllObserver();
	}

	public void setPressure(int pressure) {

		this.pressure = pressure;
		notifyAllObserver();
	}

	public void setHumidity(int humidity) {

		this.humidity = humidity;
		notifyAllObserver();
	}
}
