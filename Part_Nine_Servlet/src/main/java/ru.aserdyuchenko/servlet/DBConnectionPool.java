package ru.aserdyuchenko.servlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Serdyuchenko AN.
 * @since 25.11.2017
 * @version 1
 */
public class DBConnectionPool {
    private Connection connection;
    private final Settings settings;
    private int MAX_CONNECTION = 10;
    List<Connection> freeConnections = new ArrayList();
    private String SQL_CREATE_TABLE = "CREATE TABLE users (login character varying (50), name character varying (50), email character varying (50), createDate character varying (50))";

    private DBConnectionPool() {
        try {
            settings = Settings.getInstance();
            this.connection = DriverManager.getConnection(
                    settings.value("jdbc.url"),
                    settings.value("jdbc.username"),
                    settings.value("jdbc.password"));
            this.connection.setAutoCommit(false);
            if (!ifTableExist()) createTable();
            loadDrivers();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Регистрация JDBC-драйвера для базы данных.
     */
    private void loadDrivers() {
        try {
            Driver driver = (Driver) Class.forName(settings.value("jdbc.driver_class")).newInstance();
            DriverManager.registerDriver(driver);
        } catch (IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if table exist.
     */
    private boolean ifTableExist() throws SQLException {
        try {
            DatabaseMetaData md = this.connection.getMetaData();
            md.getTables(null, null, "users", null);
            this.connection.commit();
            return true;
        } catch (SQLException e) {
            this.connection.rollback();
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Create table.
     */
    private void createTable() throws SQLException {
        try (Statement statement = this.connection.createStatement()) {
            statement.addBatch(SQL_CREATE_TABLE);
            this.connection.commit();
        } catch (SQLException e) {
            this.connection.rollback();
            e.printStackTrace();
        }
    }

    private static class LazyHolder {
        static final DBConnectionPool INSTANCE = new DBConnectionPool();
    }

    /**
     * Метод контролирует создание экземпляра класса DBConnectionPool,
     * предоставляя различным запросам ссылку только на один единственный объект.
     * @return DBConnectionPool.LazyHolder.INSTANCE.
     */
    public static synchronized DBConnectionPool getInstance() {
        return DBConnectionPool.LazyHolder.INSTANCE;
    }

    /**
     * Предоставляет возможность получить соединение с базой данных в виде объекта Connection.
     * Внутри метода проверяется содержимое контейнера, предоставляющего собой объект класса ArrayList.
     * В том случае, когда контейнер содержит элементы, из него извлекается одно из доступных соединений
     * и возвращается объекту-клиетую Если же свободных соединений нет, тогда создается новое соединение,
     * которое также возвращается объекту-клиенту.
     */
    public synchronized Connection getConnection() {

        if(!freeConnections.isEmpty()) {
            this.connection = freeConnections.get(freeConnections.size() - 1);
            freeConnections.remove(this.connection);

            try {
                if (this.connection.isClosed()) {
                    this.connection = getConnection();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            this.connection = newConnection();
        }
        return this.connection;
    }

    /**
     * Возможность возвратить использованное соединение обратно в пул.
     */
    public synchronized void freeConnection() {
        if ((this.connection != null) && (freeConnections.size()) <= MAX_CONNECTION) {
            freeConnections.add(this.connection);
        }
    }

    /**
     * Внутри метода вызываются статические методы getConnection() класса DriverManager.
     * Метод возвращает ссылку на объект Connection.
     */
    private Connection newConnection() {
        try {
            this.connection = DriverManager.getConnection(
                    settings.value("jdbc.url"),
                    settings.value("jdbc.username"),
                    settings.value("jdbc.password")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
    }

    /**
     * После того, как все необходимые действия с базой данных выполнены,
     * и больше запросов от пользователя не поступает, можно удалить все элементы из пула.
     * Закрываются и удаляются все открытые соединения.
     */
    public synchronized void released() {
        Iterator allConnection = freeConnections.iterator();
        while (allConnection.hasNext()) {
            Connection con = (Connection) allConnection.next();
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        freeConnections.clear();
    }
}
