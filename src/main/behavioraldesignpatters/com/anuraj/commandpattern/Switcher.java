
package com.anuraj.commandpattern;

import java.util.ArrayList;
import java.util.List;

// invoker
public class Switcher {

	private List<Command> commands;

	public Switcher() {

		this.commands = new ArrayList<>();
	}

	public void addCommand(Command c) {

		this.commands.add(c);
	}

	public void executeCommands() {

		for (Command c : this.commands) {
			c.execute();
		}
	}
}
