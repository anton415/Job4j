package ru.aserdyuchenko.todo_list.storage;

import org.junit.Before;
import org.junit.Test;
import ru.aserdyuchenko.todo_list.models.Item;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;

public class DataSourceTest {
    /**
     * Data source.
     */
    private DataSource source;

    @Before
    public void init() {
        source = new DataSource();
    }

    @Test
    public void whenSaveItem() {
        Item item = new Item("test item 2");
        assertTrue(source.save(item));
    }

    @Test
    public void whenAddTestItemAndCheckThatListWithItemsNotEmpty() {
        Item item = new Item("test item");
        source.save(item);
        List<Item> list = source.getAllItems();
        assertFalse(list.isEmpty());
    }

    @Test
    public void when() {

        System.out.println(source.getOnlyNotDoneItems());
    }

//    @Test
//    public void whenCreateItemWithDefaultDoneFalseThenSetItemDoneTrue() {
//        Item newItem = new Item("Test");
//
//        source.save(newItem);
//        List<Item> list = source.getAllItems();
//        Item itemFromDS = list.get(list.size() - 1);
//
//
//        assertTrue(itemFromDS.isDone());
//    }
}