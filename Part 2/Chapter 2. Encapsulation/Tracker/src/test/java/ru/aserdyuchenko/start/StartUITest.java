package ru.aserdyuchenko.start;

import org.apache.commons.io.output.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import ru.aserdyuchenko.models.Task;
import ru.aserdyuchenko.models.Item;
import ru.aserdyuchenko.start.Input;
import ru.aserdyuchenko.start.StubInput;


public class StartUITest {
	@Test
    public void whenAddNewItem() {
	StubInput stubInput = new StubInput();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	System.setOut(new PrintStream(out));
	stubInput.addNewItem();
	assertThat(out.toString(), is("Add new item."));
    }
}
