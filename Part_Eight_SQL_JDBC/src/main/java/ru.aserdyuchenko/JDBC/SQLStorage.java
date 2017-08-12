package ru.aserdyuchenko.JDBC;

import org.apache.log4j.Logger;
import java.sql.*;

class SQLStorage {
    private static final Logger Log = Logger.getLogger(SQLStorage.class);
    private String url;
    private String username;
    private String password;
    private int n;

    public void setN(int n) {
        this.n = n;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void connectToDB() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.url, this.username, this.password);
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