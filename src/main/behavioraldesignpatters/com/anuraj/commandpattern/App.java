
package com.anuraj.commandpattern;

public class App {

	public static void main(String[] args) {

		//command
		//reciever - light
		//invoker - switcher
		//client - main method
		Switcher switcher = new Switcher();
		Light light = new Light();
		TurnOnCommand onCommand = new TurnOnCommand(light);
		TurnOffCommand offCommand = new TurnOffCommand(light);
		switcher.addCommand(onCommand);
		switcher.addCommand(offCommand);
		switcher.executeCommands();
	}
}
