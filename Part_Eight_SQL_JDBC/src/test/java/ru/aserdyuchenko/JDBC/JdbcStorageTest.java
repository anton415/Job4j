package ru.aserdyuchenko.JDBC;

import org.junit.Test;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 */
public class JdbcStorageTest {
    private JdbcStorage storage = new JdbcStorage();

    @Test
    public void whenPrintAllTable() {
        storage.get();
    }

    @Test
    public void whenAddNumberInTable() {
        storage.add(1);
    }

}