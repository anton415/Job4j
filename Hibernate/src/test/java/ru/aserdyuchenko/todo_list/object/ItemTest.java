/**
 * Item test.
 * @author Anton Serdyuchenko.
 * @since 28.04.2018
 */
package ru.aserdyuchenko.todo_list.object;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Item test class.
 */
public class ItemTest {

    /**
     * Create a task object and retrieve its value fields.
     */
    @Test
    public void whenCreateItemThenGetDescription() {
        String testDescription = "Test description.";
        Item item = new Item(testDescription);
        assertThat(item.getDescription(), is(testDescription));
        assertFalse(item.isDone());
    }
}