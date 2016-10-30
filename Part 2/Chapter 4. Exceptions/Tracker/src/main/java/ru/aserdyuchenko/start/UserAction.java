package ru.aserdyuchenko.start;

import ru.aserdyuchenko.start.Input;
import ru.aserdyuchenko.start.Tracker;

public interface UserAction {
	int key();

	void execute(Input input, Tracker tracker);

	String info();
}
