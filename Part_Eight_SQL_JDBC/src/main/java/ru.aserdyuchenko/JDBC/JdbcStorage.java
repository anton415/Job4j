package ru.aserdyuchenko.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 */
public class JdbcStorage {
    private final Connection connection;

    /**
     * Constructor.
     */
    public JdbcStorage() {
        try {
            final Settings settings = Settings.getInstance();
            this.connection = DriverManager.getConnection(
                    settings.value("jdbc.url"),
                    settings.value("jdbc.username"),
                    settings.value("jdbc.password"));
            if (!ifTableExist()) createTable();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Get all data from table.
     */
    public List<Integer> get() throws SQLException {
        List<Integer> list = new ArrayList<>();
        try (final Statement statement = this.connection.createStatement();
            final ResultSet rs = statement.executeQuery("select * from test")) {
            while (rs.next()) {
                list.add(rs.getInt("number"));
            }
            rs.close();
            statement.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Create table.
     */
    private void createTable() throws SQLException {
        try (Statement statement = this.connection.createStatement()) {
            statement.execute("CREATE TABLE test (number Int)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete all frome table "test".
     */
    private void delete() throws SQLException {
        try (Statement statement = this.connection.createStatement()) {
            statement.execute("delete from test");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add numbers in table. From 1 to N.
     * @param n - count numbers.
     */
    public void add(int n) throws SQLException {
        delete();
        try (final PreparedStatement statement = this.connection.prepareStatement("insert into test values(?)")) {
            for (int i = 1; i <= n; i++) {
                statement.setInt(1, i);
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if table exist.
     */
    private boolean ifTableExist() {
        try {
            DatabaseMetaData md = connection.getMetaData();
            md.getTables(null, null, "test", null);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}