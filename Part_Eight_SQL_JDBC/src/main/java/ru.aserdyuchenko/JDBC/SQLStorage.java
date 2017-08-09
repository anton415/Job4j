package ru.aserdyuchenko.JDBC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

class SQLStorage {
    private static final Logger Log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/sqlite";
        String username = "postgres";
        String password = "i am root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM test");
            while (rs.next()) {
                System.out.println(String.format("%s", rs.getInt("number")));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
    }
}