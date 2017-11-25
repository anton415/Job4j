package ru.aserdyuchenko.servlet;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSource {
    private final Connection connection;
    private static DataSource datasource;
    private BasicDataSource ds;
    private String SQL_SELECT = "SELECT * FROM users";
    private String SQL_CREATE_TABLE = "CREATE TABLE users (login character varying (50), name character varying (50), email character varying (50), createDate character varying (50))";
    private String SQL_INSERT = "INSERT INTO users VALUES(?, ?, ?, ?)";
    private String SQL_DELETE = "DELETE FROM users WHERE login = ?";
    private String SQL_UPDATE = "UPDATE users SET name=?, email=?, createDate=? WHERE login=?";

    private DataSource() throws IOException, SQLException, PropertyVetoException {
        ds = new BasicDataSource();
        final Settings settings = Settings.getInstance();
        ds.setDriverClassName(settings.value("jdbc.driver_class"));
        ds.setUsername(settings.value("jdbc.username"));
        ds.setPassword(settings.value("jdbc.password"));
        ds.setUrl(settings.value("jdbc.url"));

        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);

        this.connection = ds.getConnection();
        this.connection.setAutoCommit(false);

        if (!ifTableExist()) createTable();
    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.connection;
    }

    /**
     * Get all data from table.
     */
    public List<User> getList() throws SQLException {
        List<User> users = new LinkedList<>();
        try (final Statement statement = getConnection().createStatement()) {
            final ResultSet rs = statement.executeQuery(SQL_SELECT);
            while (rs.next()) {
                users.add(new User(rs.getString("login"), rs.getString("name"), rs.getString("email"), rs.getString("createDate")));
            }
            getConnection().commit();
            rs.close();
            statement.close();
            return users;
        } catch (SQLException e) {
            getConnection().rollback();
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Update user.
     * @throws SQLException
     */
    public void update(String name, String email, String createDate, String login) throws SQLException {
        try {
            final PreparedStatement statement = getConnection().prepareStatement(SQL_UPDATE);
            statement.addBatch();
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, createDate);
            statement.setString(4, login);
            statement.executeUpdate();
            getConnection().commit();
            statement.close();
        } catch (SQLException e) {
            getConnection().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Create table.
     */
    public void createTable() throws SQLException {
        try (Statement statement = getConnection().createStatement()) {
            statement.addBatch(SQL_CREATE_TABLE);
            getConnection().commit();
        } catch (SQLException e) {
            getConnection().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Add user.
     */
    public void add(String login, String name, String email, String createDate) throws SQLException {
        try {
            final PreparedStatement statement = getConnection().prepareStatement(SQL_INSERT);
            statement.addBatch();
            statement.setString(1, login);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, createDate);
            statement.executeUpdate();
            getConnection().commit();
            statement.close();
        } catch (SQLException e) {
            getConnection().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Check if table exist.
     */
    private boolean ifTableExist() throws SQLException {
        try {
            DatabaseMetaData md = getConnection().getMetaData();
            md.getTables(null, null, "users", null);
            getConnection().commit();
            return true;
        } catch (SQLException e) {
            getConnection().rollback();
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete all from table "test".
     */
    public void delete(String login) throws SQLException {
        try {
            final PreparedStatement statement = getConnection().prepareStatement(SQL_DELETE);
            statement.addBatch();
            statement.setString(1, login);
            statement.executeUpdate();
            getConnection().commit();
            statement.close();
        } catch (SQLException e) {
            getConnection().rollback();
            e.printStackTrace();
        }
    }
}
