package ru.aserdyuchenko.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import ru.aserdyuchenko.models.Task;
import ru.aserdyuchenko.models.Item;
import ru.aserdyuchenko.start.Input;
import ru.aserdyuchenko.start.StubInput;
import org.hamcrest.core.IsNull;


public class StartUITest {
	@Test
    public void whenAddNewItemAndDisplayAllItem() {
	Tracker tracker = new Tracker();
	Input input = new StubInput(new String[] {"1", "name", "desc","4", "5"});
	StartUI startUI = new StartUI(input);
	startUI.init();
	assertThat(tracker.findByName("name"), is(IsNull.notNullValue()));
    }

	@Test
    public void whenEditItemAndDisplayAllItem() {
	Tracker tracker = new Tracker();
	Input input = new StubInput(new String[] {"1", "name", "desc", "2", "name", "new desc","4", "5"});
	StartUI startUI = new StartUI(input);
	startUI.init();
	assertThat(tracker.findByName("name"), is(IsNull.notNullValue()));
    }

	@Test
    public void whenRemoveItemAndDisplayAllItem() {
	Tracker tracker = new Tracker();
	Input input = new StubInput(new String[] {"1", "name", "desc", "3", "name", "4", "5"});
	StartUI startUI = new StartUI(input);
	startUI.init();
	assertThat(tracker.findByName("name"), is(IsNull.nullValue()));
    }
}
