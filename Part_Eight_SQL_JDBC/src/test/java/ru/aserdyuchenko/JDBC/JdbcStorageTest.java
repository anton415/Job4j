package ru.aserdyuchenko.JDBC;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 * TODO add assert in all tests.
 */
public class JdbcStorageTest {
    private JdbcStorage storage = new JdbcStorage();

    @Test
    public void whenPrintAllTable() {
        storage.print();
    }

    @Test
    public void whenAddNumberInTableAndPrintTable() {
        storage.add(3);
        storage.print();
    }

    @Test
    public void whenDeleteAllFromeTableAndPriteTable() {
        storage.delete();
        storage.print();
    }

    @Test
    public void whenCheckIfTableExist() {
        assertTrue(storage.ifTableExist());
    }


}