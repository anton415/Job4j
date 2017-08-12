package ru.aserdyuchenko.JDBC;

import org.junit.Test;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 */
public class SQLStorageTest {
    @Test
    public void whenConnectToDBAndReadAllData() {
        SQLStorage storage = new SQLStorage();
        storage.setUrl("jdbc:postgresql://localhost:5432/sqlite");
        storage.setUsername("anton");
        storage.setPassword("password");
        storage.setN(3);
        storage.connectToDB();
    }
}