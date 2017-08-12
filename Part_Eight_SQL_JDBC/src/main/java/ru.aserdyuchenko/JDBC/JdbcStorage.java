package ru.aserdyuchenko.JDBC;

import java.sql.*;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 */
public class JdbcStorage {
    private final Connection connection;

    public JdbcStorage() {
        final Settings settings = Settings.getInstance();
        try {
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void get() {
        try (final Statement statement = this.connection.createStatement();
            final ResultSet rs = statement.executeQuery("select * from test")) {
            while (rs.next()) {
                System.out.println(rs.getInt("number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(int n) {
        try (final PreparedStatement statement = this.connection.prepareStatement("insert into test values(?)")) {
            statement.setInt(1, 1);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
