package ru.aserdyuchenko.todo_list.storage;

import org.junit.Test;
import ru.aserdyuchenko.todo_list.models.Item;

import java.util.List;

import static org.junit.Assert.*;

public class DataSourceTest {

    @Test
    public void whenSaveItem() {
        DataSource source = new DataSource();
        Item item = new Item("test item 2");
        assertTrue(source.save(item));
    }

    @Test
    public void whenAddTestItemAndCheckThatListWithItemsNotEmpty() {
        DataSource source = new DataSource();
        Item item = new Item("test item");
        source.save(item);
        List<Item> list = source.getAllItems();
        assertFalse(list.isEmpty());
    }
}