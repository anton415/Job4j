package ru.aserdyuchenko.crudServlet;

import org.junit.Test;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 */
public class StorageTest {
    @Test
    public void whenAddInStorageAndGetResult() throws SQLException {
        Storage storage = new Storage();
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        storage.add("anton415", "Anton Serdyuchenko", "anton415@gmail.com", df.format(dateobj));
        System.out.println(storage.get());
    }
}