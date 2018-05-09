/**
 * Item test.
 * @author Anton Serdyuchenko.
 * @since 28.04.2018
 */
package ru.aserdyuchenko.todo_list.object;

import org.junit.Test;
import ru.aserdyuchenko.todo_list.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

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

    /**
     * Create a task object and test set and get method.
     */
    @Test
    public void whenCreateItemThenTestSetAndGetMethods() {
        String testDescription = "Test description.";
        Item item = new Item(testDescription);

        String resultDescription = item.getDescription();
        boolean resultDone = item.isDone();

        assertThat(resultDescription, is(testDescription));
        assertFalse(resultDone);
    }

    /**
     * When change description.
     */
    @Test
    public void whenChangeDescription() {
        String oldDescription = "Old description.";
        String newDescription = "New description.";
        Item item = new Item(oldDescription);

        item.setDescription(newDescription);
        String resultDescription = item.getDescription();

        assertThat(resultDescription, is(newDescription));
    }
}