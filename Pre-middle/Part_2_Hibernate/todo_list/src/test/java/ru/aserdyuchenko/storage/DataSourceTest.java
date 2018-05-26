package ru.aserdyuchenko.storage;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import ru.aserdyuchenko.models.Item;
import ru.aserdyuchenko.storage.DataSource;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DataSourceTest {
    /**
     * Data source.
     */
    private static DataSource source;

    @Before
    public void before() {
        source = DataSource.getInstance();
    }

    @AfterClass
    public static void after() {
        source.closeFactory();
    }

    @Test
    public void whenSaveItem() {
        Item item = new Item("test item 2");
        assertTrue(source.save(item));
    }

    @Test
    public void whenGetAllItems() {
        List<Item> list = source.getAllItems();
        assertFalse(list.isEmpty());
    }

    @Test
    public void whenAddTestItemAndCheckThatListWithItemsNotEmpty() {
        Item item = new Item("test item");
        source.save(item);
        List<Item> list = source.getAllItems();
        assertFalse(list.isEmpty());
    }
}