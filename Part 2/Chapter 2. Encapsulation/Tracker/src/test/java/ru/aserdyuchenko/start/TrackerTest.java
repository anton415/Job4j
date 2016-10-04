package ru.aserdyuchenko.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import ru.aserdyuchenko.models.Task;
import ru.aserdyuchenko.models.Item;

public class TrackerTest {
	@Test
    public void whenAddTwoNewItemAndСheckSecondItem() {
		Tracker tracker = new Tracker();
		tracker.add(new Task("first task", "first desc"));
		tracker.add(new Task("second task", "second desc"));
		Item item = tracker.findByName("second task");
		String result = item.getName();
		assertThat(result, is("second task"));
    }
	@Test
    public void whenRemovalFirstItem() {
		Tracker tracker = new Tracker();
		tracker.add(new Task("first task", "first desc"));
		tracker.add(new Task("second task", "second desc"));
		int position = tracker.findPositionByName("first task");
		tracker.removalItem(position);
		Item item = tracker.findByName("second task");
		String result = item.getName();
		//Я понимаю что так тест не проверяется, но я не могу придумать лучшего способа посмотреть, какой в результате получился массив.
		for (Item index : tracker.getAll()) {
			System.out.println(index.getDescription());//я не могу понять, почему в этой строчке тест возвращает Failures: NullPointer		
		}
		assertThat(result, is("second task"));
    }	
	@Test
    public void whenEditingFirstDescription() {
		Tracker tracker = new Tracker();
		tracker.add(new Task("first task", "first desc"));
		tracker.add(new Task("second task", "second desc"));
		int position = tracker.findPositionByName("first task");
		tracker.updateItem(position, new Task("first task", "first description"));
		Item item = tracker.findByName("first task");
		String result = item.getDescription();
		assertThat(result, is("first description"));
    }
	@Test
    public void whenFindItemByName() {
		Tracker tracker = new Tracker();
		tracker.add(new Task("first task", "first desc"));
		tracker.add(new Task("second task", "second desc"));
		Item item = tracker.findByName("first task");
		String result = item.getName();
		assertThat(result, is("first task"));
    }	
}
