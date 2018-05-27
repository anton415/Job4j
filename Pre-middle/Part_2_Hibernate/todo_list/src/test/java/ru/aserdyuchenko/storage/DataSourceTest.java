package ru.aserdyuchenko.storage;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import ru.aserdyuchenko.models.Item;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * TODO: Test when get all not done items.
 */
public class DataSourceTest {
    private static final Logger logger = Logger.getLogger(DataSourceTest.class);
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
    public void whenAddTestItemAndCheckThatListWithItemsNotEmpty() {
        Item item = new Item("test item");
        source.save(item);
        List<Item> list = source.getAllItems();
        assertFalse(list.isEmpty());
    }

    /**
     * Get id after save item.
     */
    @Test
    public void whenSaveItemThenGetId() {
        Item item = new Item("For get id.");
        int id = source.save(item);
        assertNotEquals("Expect id not equals -1.", -1, id);
    }

    /**
     * Get item by id.
     * Equals them by description.
     */
    @Test
    public void whenSaveItemThenGetByIdAndEqualsByDescription() {
        Item itemNew = new Item("For get item by id");
        int id = source.save(itemNew);
        Item itemFromDB = source.getItemById(id);
        assertEquals("Item not equals by description.", itemNew.getDescription(), itemFromDB.getDescription());
    }

    /**
     * When try get none exist item, get exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenTryGetNoneExistItemThenGetException() {
        source.getItemById(-1);
    }


    /**
     * Get all not done items.
     */
    @Test
    public void whenGetListWithAllNotDoneItems() {
        boolean allNotDone = true;
        List<Item> items = source.getOnlyNotDoneItems();
        for (Item item : items) {
            if (item.isDone()) {
                allNotDone = false;
                break;
            }
        }
        assertTrue(allNotDone);
    }
}