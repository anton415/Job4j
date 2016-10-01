package ru.aserdyuchenko.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import ru.aserdyuchenko.models.Task;
import ru.aserdyuchenko.models.Item;

public class TrackerTest {
    @Test
    public void whenAddNewFirstItem() {
		Tracker tracker = new Tracker();
		String result = null;
		tracker.add(new Task("first task", "first desc"));
		for (Item index : tracker.getAll()) {
			result = index.getName();		
		}
		assertThat(result, is("first task"));
    }
	@Test
    public void whenAddNewSecondItem() {
		Tracker tracker = new Tracker();
		String result = null;
		tracker.add(new Task("first task", "first desc"));
		tracker.add(new Task("second task", "second desc"));
		for (Item index : tracker.getAll()) {
			result = index.getName();		
		}
		assertThat(result, is("second task"));
    }
	@Test
    public void whenRemovalSecondItem() {
		Tracker tracker = new Tracker();
		String result = null;
		tracker.add(new Task("first task", "first desc"));
		tracker.add(new Task("second task", "second desc"));
		tracker.removal(new Task("second task", "second desc"));
		for (Item index : tracker.getAll()) {
			result = index.getName();		
		}
		assertThat(result, is("first task"));
    }	
	@Test
    public void whenEditingDescription() {
		Tracker tracker = new Tracker();
		String result = null;
		tracker.add(new Task("first task", "first desc"));
		tracker.add(new Task("second task", "second desc"));
		Item item = tracker.findByName("first task");
		tracker.editingDesc(item, "first description");
		item = tracker.findByName("first task");
		result = item.getDescription();
		assertThat(result, is("first description"));
    }
	@Test
    public void whenFindItem() {
		Tracker tracker = new Tracker();
		String result = null;
		String needId = null;
		tracker.add(new Task("first task", "first desc"));
		tracker.add(new Task("second task", "second desc"));
		Item item = tracker.findByName("first task");
		result = item.getName();
		assertThat(result, is("first task"));
    }	
}
