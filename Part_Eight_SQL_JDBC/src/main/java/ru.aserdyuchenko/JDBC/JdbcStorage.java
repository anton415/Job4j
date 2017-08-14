package ru.aserdyuchenko.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 * TODO shift all .close() in finally.
 * TODO add method create table.
 * TODO add since tag in javaDoc.
 */
public class JdbcStorage {
    private final Connection connection;

    /**
     * Constructor.
     */
    public JdbcStorage() {
        final Settings settings = Settings.getInstance();
        try {
            this.connection = DriverManager.getConnection(
                    settings.value("jdbc.url"),
                    settings.value("jdbc.username"),
                    settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Print all numbers in table.
     */
    public void print() {
        try (final Statement statement = this.connection.createStatement();
            final ResultSet rs = statement.executeQuery("select * from test")) {
            while (rs.next()) {
                System.out.println(String.format("%s", rs.getInt("number")));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * Get all data from table.
     */
    public List<Integer> get() {
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
        } finally {

        }
    }

    /**
     * Delete all frome table "test".
     */
    public void delete() {
        try {
            final Statement statement = this.connection.createStatement();
            statement.execute("delete from test");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * Add numbers in table. From 1 to N.
     * @param n - count numbers.
     */
    public void add(int n) {
        delete();
        try (final PreparedStatement statement = this.connection.prepareStatement("insert into test values(?)")) {
            for (int i = 1; i <= n; i++) {
                statement.setInt(1, i);
                statement.executeUpdate();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * Check if table exist.
     */
    public boolean ifTableExist() {
        try {
            DatabaseMetaData md = connection.getMetaData();
            md.getTables(null, null, "test", null);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {

        }
    }
}