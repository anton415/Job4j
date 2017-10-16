package ru.aserdyuchenko.crudServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 */
public class UsersServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UsersServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        try {
            Class.forName("org.postgresql.Driver");
            Settings settings = Settings.getInstance();
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/sqlite",
                    "anton",
                    "password");
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            Map<String, User> users = new HashMap<>();
            while (rs.next()) {
                users.put(rs.getString("login"), new User(rs.getString("name"), rs.getString("email"), rs.getString("createDate")));
            }
            writer.append(users.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.flush();
    }
/*
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            this.storage.add(request.getParameter("login"), request.getParameter("name"), request.getParameter("email"), request.getParameter("createDate"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        this.users.put(request.getParameter("login"), new User(request.getParameter("name"), request.getParameter("email"), request.getParameter("createDate")));
        doGet(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        this.users.remove(request.getParameter("login"));
        doGet(request, response);
    }
*/

}
