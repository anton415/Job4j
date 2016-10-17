package ru.aserdyuchenko.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import ru.aserdyuchenko.models.Task;
import ru.aserdyuchenko.models.Item;
import ru.aserdyuchenko.start.Input;
import ru.aserdyuchenko.start.StubInput;


public class StartUITest {
	@Test
    public void whenAddNewItemAndWatchAllItem() {
		Tracker tracker = new Tracker();
		Input input = new StubInput(new String[] {"1","4","5"});
 		new StartUI(input).init();
    }
}
