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
    public void whenAddNewItem() {
	Tracker tracker = new Tracker();
	Input input = new StubInput(new String[] {"1", "name", "desc", "4" ,"5"});
	StartUI startUI = new StartUI(input);
	startUI.init();
	assertThat(tracker.findByName("name"), is(IsNull.notNullValue()));

/*
	Почему, то что написано ниже работает, а то что выше падает?
	Я постарался сделать как ты говорил.
	Есть входные данные. И получается массив имитирует, всё что я бы вводил с консоли.
	Но я не понимаю почему заявка не сохраняется?
	Она сохраняется, но пробадает с завершением метода init().
	То что она сохраняется подтверждает пункт меню "вывод всех заявок", когда мы передаем в меню значение 4.

*/


/*
	Tracker tracker = new Tracker();
	tracker.add(new Task("name", "desc"));
	assertThat(tracker.findByName("name"), is(IsNull.notNullValue()));
*/
    }
}
